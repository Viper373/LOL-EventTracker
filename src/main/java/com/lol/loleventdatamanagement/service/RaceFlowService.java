package com.lol.loleventdatamanagement.service;

import cn.hutool.core.util.IdUtil;
import com.lol.loleventdatamanagement.pojo.EventDouble;
import com.lol.loleventdatamanagement.pojo.RaceFlow;
import com.lol.loleventdatamanagement.vo.RaceFlowVO;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RaceFlowService {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 添加比赛流程至MongoDB
     * @param raceFlow
     */

    public void addRaceFlow(RaceFlow raceFlow){
        // 比赛编号根据雪花算法生成
        raceFlow.setId(IdUtil.getSnowflake(1, 1).nextIdStr());
        // 设置比赛状态
        raceFlow.setStatus("未开始");
        // 添加预约比赛至MongoDB
        mongoTemplate.insert(raceFlow, "lol");
    }

        /**
         * 更新比赛信息
         * 追加战队信息
         */
    public void updateAndAddEvent(EventDouble eventDouble) {
        // 获取赛程状态
        String status = eventDouble.getStatus();
        // 初始化Query对象，根据赛事编号查询
        Query query = new Query(Criteria.where("_id").is(eventDouble.getRaceFlowId()));
        // 初始化Update对象
        Update update = new Update();
        // 更新比赛状态
        update.set("status", status);
        // 追加比赛数据
        update.push("events", eventDouble);
        // 更新比赛信息
        mongoTemplate.upsert(query, update, EventDouble.class, "lol");
    }
        /**
         * 通过赛事编号查询
         *
         * @param id
         * @return
         */
    public RaceFlow selectEventById(String id) {
        // 初始化Query对象，根据赛事编号查询
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, RaceFlow.class, "lol");
    }
        /**
         * 查询所有订单
         *
         * @return
         */
    public Map<String, Object> selectTeamList() {
        List<RaceFlow> raceFlowList = mongoTemplate.findAll(RaceFlow.class, "lol");
        List<RaceFlowVO> list = new ArrayList<>();
        for(RaceFlow raceFlow: raceFlowList){
            RaceFlowVO raceFlowVO = new RaceFlowVO();
            raceFlowVO.setId(raceFlow.getId());
            raceFlowVO.setStatus(raceFlow.getStatus());
            raceFlowVO.setEventTime(raceFlow.getEventTime());
            raceFlowVO.setEventName(raceFlow.getEventName());
            raceFlowVO.setEventStage(raceFlow.getEventStage());
            raceFlowVO.setTeamAName(raceFlow.getTeamA().getName());
            raceFlowVO.setTeamBName(raceFlow.getTeamB().getName());
            list.add(raceFlowVO);
        }
        Map<String, Object> result = new HashMap<>();
        if (list == null || list.isEmpty()) {
            result.put("code", "0");
            result.put("message", "没有相关赛事信息");
        } else {
            result.put("code", "0");
            result.put("count", list.size());
            result.put("data", list);
        }
        return result;
    }
        /**
         * 根据赛事编号删除赛程信息
         *
         * @param id
         * @return
         */
    public boolean deleteTeamById(String id) {
        // 初始化 Query 对象，根据赛事编号查询
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult result = mongoTemplate.remove(query, RaceFlow.class, "lol");
        return result.getDeletedCount() > 0 ? true : false;
    }
}

