package com.hollyland.stream.forEach;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Fruit
 * @Description TODO
 * @Author wangqiang
 * @Date 2022/9/8 14:03
 **/
@Data
@AllArgsConstructor
public class Fruit {
    private int id;
    private String name;
    private String type;
    private int price;
}
