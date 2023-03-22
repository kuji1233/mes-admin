package com.peak.common.response;

/**
 * @Description: 返回码定义
 * 规定:
 * #200表示成功
 * #400表示错误
 * #1001～1999 区间表示参数错误
 * #2001～2999 区间表示用户错误
 * #3001～3999 区间表示接口异常
 * #后面对什么的操作自己在这里注明就行了
 */
public enum ResultStatus implements BaseErrorInfo {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /*错误*/
    ERROR(400, "失败"),

    EXCEPTION(-1, "系统异常"),

    PARAM_ERROR(10000, "参数错误"),

    FILE_NOT_EXIST(10002, "文件不存在"),

    FILE_NOT_DOWNLOAD(10003, "文件没有下载"),

    FILE_NOT_GENERATE(10004, "文件没有生成"),

    FILE_NOT_STORAGE(10005, "文件没有入库"),

    SYSTEM_DB_ERROR(10006, "数据库系统错误"),

    FILE_ALREADY_DOWNLOAD(10007, "文件已经下载"),


    DATA_ALREADY_EXISTS(10008, "数据已经存在"),

    MKDIR_FAILED(10009, "目录创建失败"),

    UPLOAD_FAILED(10010, "文件上传失败"),

    /**
     * 注册登录
     */
    LOGIN_SUCCESS(20000, "登录成功"),
    LOGIN_FAIL(20001, "登录失败"),
    REGISTER_SUCCESS(20002, "注册成功!"),
    REGISTER_FAIL(200003, "注册失败!"),

    VERIFICATION_CODE_FAIL(200004, "验证码不一致!"),

    /**
     * check校验
     */

    BIND_ERROR(30001, "参数校验异常：%s"),
    ACCESS_LIMIT_REACHED(30002, "请求非法!"),
    REQUEST_ILLEGAL(30004, "访问太频繁!"),
    SESSION_ERROR(30005, "Session不存在或者已经失效!"),
    PASSWORD_EMPTY(30006, "登录密码不能为空!"),
    MOBILE_EMPTY(30007, "手机号不能为空!"),
    MOBILE_ERROR(30008, "手机号格式错误!"),
    MOBILE_NOT_EXIST(30009, "手机号不存在!"),
    PASSWORD_ERROR(30010, "密码错误!"),
    USER_NOT_EXIST(30011, "用户不存在！"),


    /**
     * 订单模块
     */
    ORDER_NOT_EXIST(60001, "订单不存在"),

    /**
     * 秒杀模块
     */
    MIAO_SHA_OVER(40001, "商品已经秒杀完毕"),
    REPEATE_MIAOSHA(40002, "不能重复秒杀"),
    MIAOSHA_FAIL(40003, "秒杀失败");

    private Integer code;
    private String message;

    ResultStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return message;
    }
}
