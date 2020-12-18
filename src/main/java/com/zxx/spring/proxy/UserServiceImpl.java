package com.zxx.spring.proxy;

/**
 * @author zxx
 * @date 2020/11/12 10:16
 * @description 1.0
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("新增了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");

    }

    @Override
    public void select() {
        System.out.println("查询了一个用户");

    }

    @Override
    public void update() {
        System.out.println("修改了一个用户");

    }
}
