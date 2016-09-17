package com.changxx.mvc.test.web;

import com.changxx.mvc.framework.ioc.annotation.Inject;
import com.changxx.mvc.framework.mvc.annotation.Action;
import com.changxx.mvc.framework.mvc.annotation.Request;
import com.changxx.mvc.framework.mvc.bean.Result;
import com.changxx.mvc.test.service.TestService;

/**
 * TestController
 *
 * @author changxiangxiang
 * @date 16/8/21
 */
@Action
public class TestController {

    @Inject
    private TestService testService;

    @Request.Get("/test")
    public Result test() {
        Result result = new Result(true);
        result.setData(testService.test());
        return result;
    }

}
