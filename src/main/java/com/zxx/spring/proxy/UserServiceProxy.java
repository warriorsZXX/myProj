package com.zxx.spring.proxy;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.lang.reflect.Proxy;

/**
 * @author zxx
 * @date 2020/11/12 10:22
 * @description 1.0
 */
public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public UserServiceProxy(UserServiceImpl userService) {

        this.userService = userService;
    }

    @Override
    public void add() {
        userService.add();
        System.out.println();
    }

    @Override
    public void delete() {

    }

    @Override
    public void select() {

    }

    @Override
    public void update() {


    }

    public static void main(String[] args) {
        Integer a = 0;
        boolean flag = false;
        System.out.println(flag);
    }
}
