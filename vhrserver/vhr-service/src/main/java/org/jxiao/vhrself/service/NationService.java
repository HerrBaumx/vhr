package org.jxiao.vhrself.service;

import org.jxiao.vhrself.mapper.NationMapper;
import org.jxiao.vhrself.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
