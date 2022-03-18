package com.xtl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName CommonResult
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 15:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResult<T>{
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }
}
