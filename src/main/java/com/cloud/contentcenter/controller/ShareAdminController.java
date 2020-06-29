package com.cloud.contentcenter.controller;

import com.cloud.contentcenter.dto.ShareAuditDTO;
import com.cloud.contentcenter.model.Share;
import com.cloud.contentcenter.service.content.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王峥
 * @date 2020/6/29 9:44 上午
 */
@RestController
@RequestMapping("/admin/shares")
public class ShareAdminController {
    @Resource
    private  ShareService shareService;
    @PutMapping("/audit/{id}")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAuditDTO auditDTO) {
//        TODO 认证和授权
        return shareService.auditById(id,auditDTO);
    }
}
