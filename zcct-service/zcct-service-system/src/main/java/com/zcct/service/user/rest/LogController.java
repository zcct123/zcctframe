package com.zcct.service.user.rest;

import com.zcct.service.user.api.dto.LogDto;
import com.zcct.service.user.service.LogService;
import com.zcct.common.web.domain.ResultInfo;
import com.zcct.common.web.rest.RestBashController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 13:10
 * @description:
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class LogController extends RestBashController {

    private final LogService logService;

    @PostMapping
    public ResultInfo add(@RequestBody LogDto operLog)
    {
        return success(logService.insertOperlog(operLog));
    }
}
