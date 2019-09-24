package com.springboot.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //注意模板 需要这个
@RequestMapping("/env")
public class EnvController extends BaseController {

    @Value("${env}")
    private String env;

    @RequestMapping("/env")
    public String evn() {
        return this.env;
    }
}
