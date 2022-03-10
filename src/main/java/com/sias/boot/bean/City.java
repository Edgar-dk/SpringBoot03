package com.sias.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edgar
 * @create 2022-03-07 12:52
 * @faction:  用于封装数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;

}
