package com.lol.loleventdatamanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {
    /**
     * 赛程明细
     */
    private int kill; // 击杀
    private int baron; // 大龙
    private int dragon; // 小龙
    private int money; // 金钱
    private int tower; // 防御塔
    private String outcome; // 获胜情况
}
