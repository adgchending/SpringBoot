package com.cd.basic.pojo.init;

import lombok.Data;

/**
 * @类名:SysUser
 * @类描述:缓存-实体类
 * @创建日期: 2021/12/6
 * @修改记录:
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: csx
 */
@Data
public class SysUser {
    private int user_id;//用户id
    
    private String user_name;//用户账号

    private String full_name;//用户中文名

    private String password;//密码(MD5加密)

    private String salt;//盐值



}
