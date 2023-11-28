package com.lol.loleventdatamanagement.controller;
import com.lol.loleventdatamanagement.pojo.EventDouble;
import com.lol.loleventdatamanagement.pojo.RaceFlow;
import com.lol.loleventdatamanagement.service.RaceFlowService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("raceflow")
public class RaceFlowController {
    @Resource
    private RaceFlowService eventService;
    /**
     * 添加首发队员至MongoDB
     *
     * @param raceFlow
     */
    @PostMapping("add")
    public String addRaceFlow(RaceFlow raceFlow) {
        eventService.addRaceFlow(raceFlow);
        return "成功添加赛事流程，比赛即将开始---";
    }

    /**
     * 更新赛事信息
     * 添加战队信息
     * @param eventDouble
     * @return
     */
    @PostMapping("update")
    public String updateAndAddEvent(EventDouble eventDouble) {
        eventService.updateAndAddEvent(eventDouble);
        return "赛事数据更新成功";
    }
    /**
     * 通过赛事编号查询
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public RaceFlow selectEventById(@PathVariable String id) {
        return eventService.selectEventById(id);
    }
    /**
     * 查询所有比赛
     *
     * @return
     */
    @GetMapping("list")
    public Map<String, Object> selectTeamList() {
        return eventService.selectTeamList();
    }
    /**
     * 根据赛事编号删除比赛记录
     *
     * @param id
     * @return
     */
    @PostMapping("delete")
    public String deleteTeamById(String id) {
        eventService.deleteTeamById(id);
        return "删除成功";
    }
}
