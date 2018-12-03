package com.cd.common.util;

import com.cd.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@Api(tags = "文件上传和下载", description = "统一文件上传和下载API")
public class FileUploadApi {

    @ApiOperation(value = "上传单个图片(created by mars_LV)", httpMethod = "POST", notes = "上传图片")
    @PostMapping(value = "/img/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultVo imgUpload(
            @ApiParam(value = "待上传的图片") @RequestBody MultipartFile file)
            throws IOException {
        byte[] fileByte = file.getBytes();
        if (fileByte.length != 0) {
            String path = upload(fileByte,
                    file.getOriginalFilename(), true);
            Map<String, String> map = new HashMap<>();
            map.put("imgUrl", path);
            return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(map);
        }
        Map<String, String> map = new HashMap<>();
        map.put("imgUrl", "");
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(map);
    }


    public String upload(byte[] fileByte, String fileName, Boolean isImg) {

        // 文件存储目标文件夹
        String targetFoldre = "/Users/chenshangxian/Downloads/tmp/";

        // System.out.println("path="+targetFoldre);
        // 我们用当前时间的来分割三个文件夹yyyy/MM/dd格式的
        Calendar now = Calendar.getInstance();
        String datePath = now.get(Calendar.YEAR) + "/"
                + (now.get(Calendar.MONTH) + 1) + "/"
                + now.get(Calendar.DAY_OF_MONTH);
        // 组装成一个全路径
        String fillPath = targetFoldre + datePath;

        // 如果这个路径不存在就新建立一个
        File dir = new File(fillPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

//		mkdirs()可以建立多级文件夹， mkdir()只会建立一级的文件夹， 如下：
//		new File("/tmp/one/two/three").mkdirs();
//		执行后， 会建立tmp/one/two/three四级目录
//		new File("/tmp/one/two/three").mkdir();
//		则不会建立任何目录， 因为找不到/tmp/one/two目录， 结果返回false

        // 截取文件后缀
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 组装一个完整的文件路径
        String path = UUID.randomUUID().toString() + "." + ext;
        File des = new File(dir, path);

        try {
            FileUtils.copyInputStreamToFile(new ByteArrayInputStream(fileByte),
                    des);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 获取域名或者IP地址
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//				.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		String urlPath = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName()
//				+ ":" + request.getServerPort() + urlPath;

        if (isImg) {
            return "/img/" + datePath + "/" + path;
        } else {
            return "/file/" + datePath + "/" + path;
        }
    }
}
