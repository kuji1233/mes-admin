package com.peak.common.response;

/**
 * @Description 自定义异常基础接口类，自定义的异常信息枚举类需实现该接口。
 * @Author xuxiang
 * @Date 2023/2/1
 * @Version 1.0
 */
public interface BaseErrorInfo {

    /*
    获取错误码
    @return 错误状态码
    */
    Integer getErrorCode();

    /*
    获取错误信息
    @return 错误信息
     */
    String getErrorMsg();
}
