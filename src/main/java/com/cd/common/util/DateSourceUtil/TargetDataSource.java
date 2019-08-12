package com.cd.common.util.DateSourceUtil;

import java.lang.annotation.*;

/**
 * @类名:TargetDataSource
 * @类描述:在server方法上使用，用于指定使用哪个数据源
 * @创建日期: 2019/8/12
 * @修改记录:
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author:陈尚贤
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
