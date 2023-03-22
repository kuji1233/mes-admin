package com.peak.common.exception;

import com.peak.common.response.ResultStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class CustomizeException extends RuntimeException {
    @ApiModelProperty(value = "错误码", example = "10001")
    private Integer code;


    @ApiModelProperty(value = "错误信息", example = "系统有异常")
    private String msg;

    @ApiModelProperty(value="错误信息描述",example ="相关描述")
    private String description;

    //自定义构造方法
    public CustomizeException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
//        this.description=description;
    }

    public CustomizeException(ResultStatus resultStatus,String description) {
        this.code =resultStatus.getErrorCode();
        this.msg = resultStatus.getErrorMsg();
        this.description =description;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    //toString方法
    @Override
    public String toString() {
        return "GuliException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }
}