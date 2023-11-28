package com.lol.loleventdatamanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class RaceFlow implements Serializable{
    private String id; // 赛事编号
    private String status; // 赛程状态

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eventTime; // 赛程时间
    private String eventName; // 赛事名称
    private String eventStage; // 赛事阶段

    private Team teamA; //A战队信息
    private Team teamB; //B战队信息

    private List<EventDouble> events; // 双方赛事数据
}
