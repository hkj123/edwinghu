package com.springboot.mybatis.controller;

import com.springboot.mybatis.service.AsyncService;
import com.springboot.mybatis.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //注意模板 需要这个
public class ThreadPoolController extends BaseController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/sss")
    public Result sss(){

        //调用service层的任务
        asyncService.executeAsync();

        return new Result(Result.ReturnValue.SUCCESS, "");
    }

}
