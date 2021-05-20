package com.jx2lee.core.web;

import com.jx2lee.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger mylogger;
    public void logic(String id) {
        mylogger.log("service id = " + id);
    }
}
