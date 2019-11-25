package com.cd.basic.api;

import com.cd.basic.pojo.domain.CsvTxtBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/csv-txt导入")
@Api(tags = "csv/txt导入")
public class CsvController {

    @ApiOperation(value = "导入")
    @PostMapping("/readCsv")
    public List<T> readCsv(MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            if (fileName.contains(".csv") || fileName.contains(".txt")) {
                InputStreamReader isr = null;
                BufferedReader br = null;
                try {
                    if (fileName.contains(".csv")) {
                        isr = new InputStreamReader(file.getInputStream(), "GB2312");
                    } else if (fileName.contains(".txt")) {
                        isr = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
                    }
                    br = new BufferedReader(isr);
                    String line = null;
                    List<String> strs = new ArrayList<>();
                    while ((line = br.readLine()) != null) {
                        strs.add(line);
                    }
                    List<CsvTxtBo> csvTxtBos = new ArrayList<>();
                    //业务处理  存到数据库  分txt和csv
//                    CsvTxtBo csvTxtBo = null;
                    CsvTxtBo csvTxtBo ;
                    if (fileName.contains(".csv")) {
                        for (String str : strs) {
                            csvTxtBo =  new CsvTxtBo();
                            String[] strarr = str.split(",");
                            csvTxtBo.setFieldName(strarr[1]);
                            csvTxtBo.setFieldValue(strarr[2]);
                            csvTxtBo.setError(strarr[3]);
                            csvTxtBo.setPatientId(strarr[4]);
                            csvTxtBo.setEnterDate(strarr[5]);
                            csvTxtBo.setOutDate(strarr[6]);
                            csvTxtBos.add(csvTxtBo);
                        }
                    } else {
                        for (String str : strs) {
                            csvTxtBo =  new CsvTxtBo();
                            String[] strarr = str.split("，");
                            String[] patinenid = strarr[1].split("：");
                            String[] visitId = strarr[2].split("：");
                            String[] error = strarr[3].split("：");
                            csvTxtBo.setPatientId(patinenid[1]);
                            csvTxtBo.setVisitId(visitId[1]);
                            csvTxtBo.setError(error[1]);
                            csvTxtBos.add(csvTxtBo);
                        }
                    }
                    //cun


                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("导入失败");
                } finally {
                    try {
                        if (br != null) {
                            br.close();
                        }
                        if (isr != null) {
                            isr.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new RuntimeException();
                    }
                }
            } else {
                throw new RuntimeException("请上传txt或者csv");
            }
        } else {
            throw new RuntimeException("文件为空");
        }
        return null;
    }

}
