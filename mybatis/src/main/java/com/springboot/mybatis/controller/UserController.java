package com.springboot.mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.service.UserService;
import com.springboot.mybatis.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //注意模板 需要这个
@RequestMapping("/user")

public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUserList")
    public Result findUserList() {
        try {
            List<User> userList = userService.findAll();
            return new Result(Result.ReturnValue.SUCCESS, "", userList);
        } catch (
                Exception e) {
            return new Result(Result.ReturnValue.FAILURE, e.getMessage());
        }
    }

    @PostMapping("/findByPage")
    public Result findByPaging(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<User> userList= userService.findByPaging();
        return new Result(Result.ReturnValue.SUCCESS, "", userList);
    }
}
