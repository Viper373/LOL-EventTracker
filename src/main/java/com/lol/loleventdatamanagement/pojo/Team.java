package com.lol.loleventdatamanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Team implements Serializable {
    private String name; // 战队名称
    private String top; // 上单
    private String jungle; // 打野
    private String mid; // 中单
    private String adc; // ADC
    private String support; // 辅助
}
