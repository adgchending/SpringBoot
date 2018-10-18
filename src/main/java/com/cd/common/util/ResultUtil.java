package com.cd.common.util;

/**
 * @Param:描述: 结果工具类
 * @return：返回结果描述:
 * @Throws：返回异常结果:
 * @Author: chenshangxian
 * @Date: 2018-9-17 16:07
 */
public class ResultUtil {

    /**
     * @Param:描述:成功时使用默认的状态和信息
     * @return：返回结果描述:返回一个成功对象 new Result("OK","success",data)
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-9-17 16:10
     */
    public static Result success(Object data) {
        return new Result("OK", "success", data);
    }

    /**
     * @Param:描述:成功时使用默认的状态和信息
     * @return：返回结果描述:返回一个成功对象 new Result("OK","success",data)
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-9-17 16:10
     */
    public static Result success(String msg) {
        return new Result("OK", "success", msg);
    }

    /**
     * @Param:描述:使用默认的成功的信息和信息，用在返回成功时，不用返回的数据的情况下
     * @return：返回结果描述:
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-9-17 16:10
     */
    public static Result success() {
        return success(null);
    }


    /**
     * @Param:描述:请求失败时，自定义返回的状态和消息
     * @return：返回结果描述: 错误结果对象
     * @Throws：返回异常结果:@param:code 自定义的状态码,@param msg 自定义的错误消息
     * @Author: chenshangxian
     * @Date: 2018-9-17 16:11
     */
    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }

    /**
     * @Param:描述:请求失败时，使用默认的错误状态码
     * @return：返回结果描述:Result("ERROR",msg,null); 错误结果对象
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-9-17 16:11
     */
    public static Result error(String msg) {
        return error("ERROR", msg);
    }
}
