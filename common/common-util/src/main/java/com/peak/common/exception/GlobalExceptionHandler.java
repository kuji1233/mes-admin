package com.peak.common.exception;

import com.peak.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName : GlobalExceptionHandler
 * @Author : Administrator
 * @Date: 2022/5/9 10:46
 * @Description : 全局异常处理器
 */

@Slf4j
public class GlobalExceptionHandler {
    /**
     * 统一异常处理类
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error();
    }

    /**
     * 特定异常处理
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.error().message("执行了自定义异常");
    }

    //添加异常处理方法
    @ExceptionHandler(CustomizeException.class)
    @ResponseBody
    public Result error(CustomizeException e){
        e.printStackTrace();
        return Result.error().message(e.getMsg()).code(e.getCode());
    }

}
