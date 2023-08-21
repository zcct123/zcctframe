package com.zcct.common.web.rest;

import com.zcct.common.web.domain.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaochong
 * @version 1.0
 * @date 2023/8/18 13:12
 * @description:
 */
public class RestBashController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ResultInfo success(Object result) {

        return new ResultInfo(result);
    }

    protected ResultInfo success() {

        return new ResultInfo();
    }
}
