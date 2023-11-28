package com.lol.loleventdatamanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDouble implements Serializable {
    /**
     * 赛程明细
     */
    private String raceFlowId;  // 区别RaceFlow类中的id
    private String status;  // 用以更新赛事状态
    private Event eventA;  // 用以存储events列表中eventA字段
    private Event eventB;  // 用以存储events列表中eventB字段
}
