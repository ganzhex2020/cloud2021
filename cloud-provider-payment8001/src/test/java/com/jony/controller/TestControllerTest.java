package com.jony.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TestControllerTest {

    @Test
    void testslf4(){
        log.debug("sl4j.debug in main");
        log.info("sl4j.info in main");
        log.error("sl4j.error in main");
    }
}