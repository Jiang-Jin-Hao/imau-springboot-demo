package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    UserDao userDao;

    public int addUser(User user) {
        return userDao.insert(user);
    }

    public String delUserById(String id) {
        return String.valueOf(userDao.deleteById(id));
    }

    public int delUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);

        return userDao.delete(queryWrapper);
    }

    public User findUser(int id) {

        return userDao.selectById(id);
    }

    public User findUser(String username) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);

        return userDao.selectOne(queryWrapper);
    }

    public List<User> findUsers(String username) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);

        return userDao.selectList(queryWrapper);

    }

    public int updateUserById(User user) {

        return userDao.updateById(user);

    }

    public int updateUserByUsername(User oldUser, User newUser) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", oldUser.getUsername());

        return userDao.update(newUser, updateWrapper);
    }

}
