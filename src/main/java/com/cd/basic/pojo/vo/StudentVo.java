package com.cd.basic.pojo.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVo {
    private String name;
    private int age;
    private String sex = "男";
}
