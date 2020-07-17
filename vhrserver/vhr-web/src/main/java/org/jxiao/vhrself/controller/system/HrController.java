package org.jxiao.vhrself.controller.system;

import org.jxiao.vhrself.model.Hr;
import org.jxiao.vhrself.model.RespBean;
import org.jxiao.vhrself.model.Role;
import org.jxiao.vhrself.service.HrSerice;
import org.jxiao.vhrself.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrSerice hrSerice;

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrSerice.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrSerice.updateHr(hr) == 1) {
            return RespBean.ok("跟新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRoles(Integer hrid, Integer[] rids) {
        if (hrSerice.updateHrRoles(hrid, rids)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrSerice.deleteHrById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
