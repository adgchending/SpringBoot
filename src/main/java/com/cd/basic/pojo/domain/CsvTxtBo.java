package com.cd.basic.pojo.domain;

import lombok.Data;

/***
 * Lombok能通过注解的方式，在编译时自动为属性生成构造器、getter/setter、equals、hashcode、toString方法。
 */
@Data
public class CsvTxtBo {
    /***
     * 病案号
     */
    String patientId;
    /***
     * 住院次数
     */
    String visitId;
    /***
     * 错误信息
     */
    String error;

    /***
     * 字段名称
     */
    String fieldName;
    /***
     * 字段值
     */
    String fieldValue;
    /***
     * 入院日期
     */
    String enterDate;
    /***
     * 出院日期
     */
    String outDate;
}
