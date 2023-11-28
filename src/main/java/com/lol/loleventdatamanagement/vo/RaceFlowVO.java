package com.lol.loleventdatamanagement.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class RaceFlowVO implements Serializable{
    private String id; // 赛事编号
    private String status; // 赛程状态

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eventTime; // 比赛时间
    private String eventName; // 赛事名称
    private String eventStage; // 赛事阶段

    private String teamAName;  //提取嵌入式文档的内层属性用以页面展示
    private String teamBName;  //提取嵌入式文档的内层属性用以页面展示
}
