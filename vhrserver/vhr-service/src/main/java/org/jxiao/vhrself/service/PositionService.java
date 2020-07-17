package org.jxiao.vhrself.service;

import org.jxiao.vhrself.mapper.PositionMapper;
import org.jxiao.vhrself.model.Position;
import org.jxiao.vhrself.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {

        return positionMapper.getAllPositions();
    }

    public Integer addPositon(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());

        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {

        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionsByIds(Integer[] ids) {
        return positionMapper.deletePositionsByIds(ids);
    }
}
