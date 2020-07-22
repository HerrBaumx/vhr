package org.jxiao.vhrself.controller;

import org.jxiao.vhrself.model.Hr;
import org.jxiao.vhrself.service.HrSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    HrSerice hrSerice;

    @GetMapping("/hrs")
    public List<Hr> getAllHrs() {
        return hrSerice.getAllHrsExceptCurrentHr();
    }
}
