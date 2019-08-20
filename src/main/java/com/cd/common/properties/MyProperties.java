package com.cd.common.properties;

import com.cd.basic.pojo.vo.StudentVo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @类名:MyProperties
 * @类描述:自定义配置类
 * @创建日期: 2019/8/20
 * @修改记录: <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: 陈尚贤
 */

@Getter
@Setter
@Component
@ConfigurationProperties("cd.properties")
//@EnableConfigurationProperties(MyProperties.class)
public class MyProperties {
    String name;
    int age;
    private StudentVo vo = new StudentVo();

}
