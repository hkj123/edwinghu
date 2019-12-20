package com.springboot.i18n.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //注意模板 需要这个
@RequestMapping("/i18n")

public class UserController extends BaseController {


    @GetMapping("/get")
    public String getI18n() {
       return "222";
    }

}
