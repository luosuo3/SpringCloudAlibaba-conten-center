package com.cloud.contentcenter.controller;

import com.cloud.contentcenter.dto.ShareDTO;
import com.cloud.contentcenter.service.content.ShareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王峥
 * @date 2020/6/23 5:33 下午
 */
@RestController
@RequestMapping("/shares")
public class ShareController {
    @Resource
    private ShareService shareService;

    @GetMapping("/{id}")
    public ShareDTO findByid(@PathVariable Integer id) {
        return shareService.findByid(id);
    }
}
