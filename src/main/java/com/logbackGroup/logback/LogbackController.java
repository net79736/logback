package com.logbackGroup.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String hello() {return "Hello World";}

    @PostMapping("log-test")
    public void logTest() {
        LOGGER.trace("Trace Log");
        LOGGER.debug("debug Log");
        LOGGER.info("info Log");
        LOGGER.warn("warn Log");
        LOGGER.error("error Log");
    }

}
