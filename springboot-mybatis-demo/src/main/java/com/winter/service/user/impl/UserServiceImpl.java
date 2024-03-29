package com.winter.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.winter.mapper.UserMapper;
import com.winter.model.User;
import com.winter.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {

        return userMapper.insertSelective(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //444
        //将参数传给这个方法就可以实现物理分页了，非常简单
        //111
        PageHelper.startPage(pageNum, pageSize);
        //333456 limit 1,20
        return userMapper.selectAllUser();
    }

    @Override
    public User selectByPrimaryKey(Integer userId){

        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        User user = userMapper.selectByPrimaryKey(record.getUserId());
        if (user != null) {
            return userMapper.updateByPrimaryKey(record);
        }
        return 0;
    }


}
