package com.changxx.mvc.test.service.impl;

import com.changxx.mvc.framework.ioc.annotation.Service;
import com.changxx.mvc.test.service.TestService;

/**
 * TestServiceImpl
 *
 * @author changxiangxiang
 * @date 16/8/21
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "just test";
    }
}
