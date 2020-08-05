package org.jxiao.vhrself.controller;

import org.csource.common.MyException;
import org.csource.fastdfs.ProtoCommon;
import org.jxiao.vhrself.config.FastDFSUtils;
import org.jxiao.vhrself.model.Hr;
import org.jxiao.vhrself.model.RespBean;
import org.jxiao.vhrself.service.HrSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Map;

@RestController
public class HrInfoController {
    @Autowired
    HrSerice hrSerice;

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication) {
        return ((Hr) authentication.getPrincipal());
    }

    @PutMapping("/hr/info")
    public RespBean updateHr(@RequestBody Hr hr, Authentication authentication) {
        if (hrSerice.updateHr(hr) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,
                    authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PutMapping("/hr/pass")
    public RespBean updateHrPasswd(@RequestBody Map<String, Object> info) {
        String oldPass = (String) info.get("oldPass");
        String pass = (String) info.get("pass");
        Integer hrid = (Integer) info.get("hrid");
        if (hrSerice.updateHrPasswd(oldPass, pass, hrid)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PostMapping("/hr/userface")
    public RespBean updateHrUserface(MultipartFile file, Integer id, Authentication authentication) throws UnsupportedEncodingException,
            NoSuchAlgorithmException, MyException {
        String fileId = FastDFSUtils.upload(file);
        int ts = (int) Instant.now().getEpochSecond();
        String s = fileId.substring(fileId.indexOf("/") + 1);
        String token = ProtoCommon.getToken(fileId.substring(fileId.indexOf("/") + 1), ts,
                "FastDFS1234567890");
        StringBuffer url1 = new StringBuffer();
        url1.append(nginxHost)
                .append(fileId)
                .append("?token=")
                .append(token)
                .append("&ts=")
                .append(ts);
//        String url = nginxHost + fileId;
        if (hrSerice.updateHrUserface(url1.toString(), id) == 1) {
            Hr hr = (Hr) authentication.getPrincipal();
            hr.setUserface(url1.toString());
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,
                    authentication.getCredentials(), authentication.getAuthorities()));

            return RespBean.ok("更新成功！", url1);
        }
        return RespBean.error("更新失败！");
    }
}
