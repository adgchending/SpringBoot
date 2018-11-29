package com.cd.basic.api;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.cd.basic.pojo.bo.BasicGetDicListBo;
import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.domain.BasicBuilding;
import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.pojo.excel.BuildingEntity;
import com.cd.basic.service.BasicBuildingService;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.basic.service.BuildingServiceCustom;
import com.cd.common.Assist;
import com.cd.common.util.ExcelUtil;
import com.cd.common.util.SnowFlake;
import com.cd.common.vo.ExportExcelParam;
import com.cd.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/export")
@Api(tags = "EasyPOI导入和导出")
public class ExportController {
    @Autowired
    BasicSchoolInforService service;
    @Autowired
    BasicBuildingService basicBuildingService;
    @Autowired
    BuildingServiceCustom buildingServiceCustom;

    @ApiOperation(value = "easyPoi导出")
    @GetMapping("/out")
    public ResultVo daochu(String id, HttpServletRequest request, HttpServletResponse response) {
        BasicSchoolInfor basicSchoolInfor = service.selectBasicSchoolInforById(Long.valueOf(id));
        BasicSchoolInforBo basicSchoolInforBo = new BasicSchoolInforBo();
        BeanUtils.copyProperties(basicSchoolInfor, basicSchoolInforBo);
        //非要来个list
        ArrayList<BasicSchoolInforBo> basicSchoolInforBos = new ArrayList<BasicSchoolInforBo>();
        basicSchoolInforBos.add(basicSchoolInforBo);

        String title = "你哈";

        ExportParams exportParams = new ExportParams(title, "文件名随便来个");

        exportParams.setType(ExcelType.XSSF);
        //定义excel生成格式
        ExportExcelParam param = new ExportExcelParam();
        param.setClassName("com.cd.basic.pojo.bo.BasicSchoolInforBo");
        param.setFileName("文件名随便来个");
        param.setList(basicSchoolInforBos);
        param.setExportParams(exportParams);
        param.setRequest(request);
        param.setResponse(response);

        boolean flag = ExcelUtil.ExportExcel(param);
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(1);
    }


    //导出的流程大致分为:
    //1  先导出模版,模版先定义好,根据模版写好代码,和常规导出一样
    //2  导出模版后,在模版里填写数据,填写好后导入
    //3  分析导入的数据,提取出来循环添加到数据库

    //下面的代码供参考
    //模版在resources文件夹excel下
    @ApiOperation(value = "easyPoi导入建筑")
    @PostMapping("/in")
    public ResultVo importBuild(MultipartFile file, String campusFkCode) {

        Assist assist = new Assist();
        assist.setRequires(Assist.andEq("CAMPUS_FK_CODE", campusFkCode));
        assist.setRequires(Assist.andEq("DEL_STATUS", 3));
        List<BasicBuilding> basicBuildings = basicBuildingService.selectBasicBuilding(assist);

        List listError = new ArrayList();
        List list = new ArrayList();
        //获取文件名
        String fileName = file.getOriginalFilename();
        if (fileName.contains(".xlsx")) {
            String className = "com.cd.basic.pojo.excel.BuildingEntity";
            try {
                ExcelImportResult result = ExcelUtil.ImportExcel(file, className);
                List<BuildingEntity> buildingEntities = result.getList();


                for (BuildingEntity entity : buildingEntities) {
                    BasicBuilding basicBuilding = new BasicBuilding();
                    basicBuilding.setFkCode(SnowFlake.getId());
                    basicBuilding.setCreateTime(new Date());
                    basicBuilding.setUpdateTime(new Date());
                    basicBuilding.setDelStatus(3);
                    basicBuilding.setCampusFkCode(Long.parseLong(campusFkCode));
                    try {
                        String s = this.splitStr(entity.getType());
                        basicBuilding.setBuildingType(Long.parseLong(s));
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        listError.add("请从下拉框中选择大楼类型" + entity.getType() + ":大楼类型格式不正确");
                    }
                    for (BasicBuilding building : basicBuildings) {
                        if (building.getBuildingName().equals(entity.getName())) {
                            //同类型的建筑名称不能相同
                            if (building.getBuildingType().toString().equals(this.splitStr(entity.getType()))) {
                                listError.add("同一大楼类型的大楼名称不能重名" + "类型:(" + entity.getType() + ")中已经存在名称为:(" + entity.getName() + ")的建筑");
                            }
                        }
                    }
                    basicBuilding.setBuildingLayer(Long.parseLong(entity.getLayer()));
                    basicBuilding.setBuildingName(entity.getName());
                    list.add(basicBuilding);
                }

            } catch (Exception e) {
                listError.add("不是合法的Excel模板");
            }
        } else {
            listError.add("Excel模板不是.xlsx结尾");
        }


        if (listError.size() > 0) {
            return ResultVo.getInstance(Boolean.FALSE, "导入数据错误");
        }

        int i = basicBuildingService.insertBasicBuildingByBatch(list);
        if (i > 0) {
            return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS);
        } else {
            return ResultVo.getInstance(Boolean.FALSE, "导入数据错误");
        }

    }

    public String splitStr(String str) throws ArrayIndexOutOfBoundsException {
        String[] split = str.split(":");
        //去空格
        String s = split[1].replaceAll("\\s*", "");
        return s;
    }

    /**
     * 导出建筑模版
     *
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "easyPoi导出建筑模版")
    @GetMapping("/out/budding")
    public ResultVo exportTemplate(HttpServletRequest request, HttpServletResponse response, String schoolFkCode) {
        boolean flag = true;
        /**
         * 导入操作:1.导出模版,2.用户填写模版然后上传模版
         */
        ArrayList list = new ArrayList();
        list.add(new BuildingEntity("教学楼", "教学楼:1", "9"));
        list.add(new BuildingEntity("女生宿舍楼", "宿舍楼:3", "5"));
        list.add(new BuildingEntity("男生宿舍楼", "宿舍楼", "5"));
        list.add(new BuildingEntity("综合大楼", "行政楼", "8"));
        ExportParams params = new ExportParams(null, "建筑信息");
        params.setTitleHeight((short) 5);
        params.setType(ExcelType.XSSF);
        //创建workbook对象
        Workbook workbook = ExcelExportUtil.exportExcel(params, BuildingEntity.class, list);
        //生成Sheet和提示信息
        Sheet sheet = workbook.getSheet("建筑信息");
        //样式1
        CellStyle cellStyle1 = workbook.createCellStyle();
        Font font = workbook.createFont();
        //红色
        font.setColor(new XSSFColor(IndexedColors.RED).getIndex());
        //加粗
        font.setBold(true);
        cellStyle1.setFont(font);
        //水平居中
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);


        //样式2
        CellStyle cellStyle2 = workbook.createCellStyle();
        Font font2 = workbook.createFont();
        //加粗
        font2.setBold(true);
        cellStyle2.setFont(font2);
        //水平居中
        cellStyle2.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
        Row row = sheet.getRow(0);//设置行,下标从0开始
        Cell cell0 = row.getCell(0);//设置列,下标从0开始
        Cell cell1 = row.getCell(1);//设置列,下标从0开始
        Cell cell2 = row.getCell(2);//设置列,下标从0开始
        cell0.setCellStyle(cellStyle1);
        cell1.setCellStyle(cellStyle1);
        cell2.setCellStyle(cellStyle2);

        CellStyle cellStyle10 = workbook.createCellStyle();
        cellStyle10.setFont(font);
        //垂直居中
        cellStyle10.setVerticalAlignment(VerticalAlignment.CENTER);
        Cell rowCell11 = row.createCell(4);
        rowCell11.setCellValue("备注:红色为必填项,有下拉选项的部分请从下拉选项中选择,请勿修改选项");
        rowCell11.setCellStyle(cellStyle10);
        //计算中文长度设置自定义列宽
        sheet.setColumnWidth(4, rowCell11.getStringCellValue().getBytes().length * 256);

        //生成下拉列表
        //生成下拉框内容:此处为接口获取
        String[] arrList1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

        //设置下拉列表生效区域
        CellRangeAddressList regions1 = new CellRangeAddressList(1, 5999, 2, 2);

        //绑定下拉框和作用区域
        XSSFDataValidationHelper dvHelper1 = new XSSFDataValidationHelper((XSSFSheet) sheet);
        XSSFDataValidationConstraint dvConstraint1 = (XSSFDataValidationConstraint) dvHelper1.createExplicitListConstraint(arrList1);
        XSSFDataValidation validation1 = (XSSFDataValidation) dvHelper1.createValidation(dvConstraint1, regions1);
        //下拉列表和sheet区域绑定
        validation1.setSuppressDropDownArrow(true);
        validation1.setShowErrorBox(true);
        validation1.setErrorStyle(DataValidation.ErrorStyle.STOP);
        validation1.createErrorBox("提示信息", "请选择下拉框中的内容!");
        sheet.addValidationData(validation1);

        //生成下拉框内容:此处为接口获取

        List<BasicGetDicListBo> buildingtypeList = buildingServiceCustom.getDicList(Long.parseLong(schoolFkCode), "BUILDINGTYPE");

        String[] arrList2 = new String[buildingtypeList.size()];
        for (int i = 0; i < buildingtypeList.size(); i++) {
            String arr = buildingtypeList.get(i).getDicValue() + ":" + buildingtypeList.get(i).getDicKey().toString();
            arrList2[i] = arr; // 效率最快
        }
        //绑定下拉框和作用区域
        //如果有多条不同的生效区域就需要渲染多条
        //绑定下拉框和作用区域
        genearteOtherSheet(workbook, arrList2, 1);
        CellRangeAddressList regions2 = new CellRangeAddressList(1, 5999, 1, 1);
        XSSFDataValidationHelper dvHelper2 = new XSSFDataValidationHelper((XSSFSheet) sheet);
        DataValidationConstraint constraint1 = dvHelper1.createFormulaListConstraint("typelist!$B$1:$B$" + arrList2.length);
        XSSFDataValidation validation2 = (XSSFDataValidation) dvHelper2.createValidation(constraint1, regions2);
        //下拉列表和sheet区域绑定
        validation2.setSuppressDropDownArrow(true);
        validation2.setShowErrorBox(true);
        validation2.setErrorStyle(DataValidation.ErrorStyle.STOP);
        validation2.createErrorBox("提示信息", "请选择下拉框中的内容!");
        sheet.addValidationData(validation2);

        workbook.setSheetHidden(workbook.getSheetIndex("typelist"), 1);

        //获取浏览器类型,定义字符集
        String userAgent = request.getHeader("USER-AGENT");
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        String fileName = "建筑管理导入模版";
        fileName = fileName + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx";
        fileName = ExcelUtil.setUrlEncode(userAgent, fileName);
        response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
        response.setHeader("Access-Control-Allow-Origin", "*");
        //FileOutputStream fos = new FileOutputStream("D:/lkq/poiTestFile/建筑信息导入模版.xls");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(flag);
        }
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(flag);
    }

    public static void genearteOtherSheet(Workbook wb, String[] typeArrays,int column) {
        // 创建下拉列表值存储工作表
        Sheet sheet = wb.getSheet("typelist");
        if (sheet == null) {
            sheet = wb.createSheet("typelist");
        }
        // 循环往该sheet中设置添加下拉列表的值
        for (int i = 0; i < typeArrays.length; i++) {
            Row row = sheet.getRow(i);
            if(row == null){
                row = sheet.createRow(i);
            }
            Cell cell = row.getCell(column);
            if(cell == null){
                cell = row.createCell(column);
            }
            cell.setCellValue(typeArrays[i]);
        }
    }
}
