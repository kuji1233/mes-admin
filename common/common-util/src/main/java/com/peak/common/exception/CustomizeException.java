package com.peak.common.exception;

import com.peak.common.response.ResultStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomizeException extends RuntimeException {
    @ApiModelProperty(value = "错误码", example = "10001")
    private Integer code;


    @ApiModelProperty(value = "错误信息", example = "系统有异常")
    private String msg;

    //构造方法
    public CustomizeException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CustomizeException(ResultStatus resultStatus) {
        
    }

    public CustomizeException(ResultStatus resultStatus, String msg) {
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