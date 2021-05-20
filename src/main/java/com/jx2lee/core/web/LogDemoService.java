package com.jx2lee.core.web;

import com.jx2lee.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myloggerProvider;
    public void logic(String id) {
        MyLogger myLogger = myloggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
