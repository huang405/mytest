package com.winter.Controller;

import com.winter.mapper.UserMapper;
import com.winter.model.User;
import com.winter.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public int addUser(User user){

        return userService.addUser(user);

    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }

    @RequestMapping(value = "/select", method = {RequestMethod.POST})
    @ResponseBody
    public User selectByPrimaryKey(Integer userId){

        return userService.selectByPrimaryKey(userId);

    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ResponseBody
    public int updateByPrimaryKey(User record) {
            User a = userService.selectByPrimaryKey(record.getUserId());
        if (a != null) {
            return userService.updateByPrimaryKey(record);
        }
        return 0;
    }
}
