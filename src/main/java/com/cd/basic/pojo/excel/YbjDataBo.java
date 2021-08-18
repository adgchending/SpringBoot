package com.cd.basic.pojo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class YbjDataBo {

    @Excel(name = "病案号", orderNum = "1", isImportField = "true")
    private String patientId;

    private String idMaster;

    private String mdc;

    @Excel(name = "drg编码", orderNum = "2", isImportField = "true")
    private String drgCode;

    @Excel(name = "drg名称", orderNum = "3", isImportField = "true")
    private String drgName;

    //分组描述
    private String detail;

    //1成功  2失败
    private String drgsFlag;


}
