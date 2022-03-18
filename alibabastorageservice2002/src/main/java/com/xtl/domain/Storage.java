package com.xtl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName Storage
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 22:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
