package com.xtl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName Payment
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
