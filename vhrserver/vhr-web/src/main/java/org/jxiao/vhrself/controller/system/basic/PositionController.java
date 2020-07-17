package org.jxiao.vhrself.controller.system.basic;

import org.jxiao.vhrself.model.Position;
import org.jxiao.vhrself.model.RespBean;
import org.jxiao.vhrself.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {


    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getAllPositions(){

        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPositon(@RequestBody Position position){

        if (positionService.addPositon(position) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if (positionService.updatePosition(position) == 1) {
            return RespBean.ok("跟新成功！");
        }
        return RespBean.error("跟新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id){

        if (positionService.deletePositionById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deletePositionsByIds(Integer[] ids){
        if (positionService.deletePositionsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
