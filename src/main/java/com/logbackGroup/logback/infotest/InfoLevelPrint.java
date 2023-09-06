package com.logbackGroup.logback.infotest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InfoLevelPrint {

    /**
     * TRACE < DEBUG < INFO < WARN < ERROR
     */
    public InfoLevelPrint() {
        log.info("InfoLevelPrint 를 출력(인포 메소드)");
        log.debug("InfoLevelPrint 를 출력(디버그 메소드)");
        log.warn("InfoLevelPrint 를 출력(워닝 메소드)");
    }
}

