package com.zly.mapper;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.zly.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest{

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询所有用户
     */
    @Test
    public void selectAllUser() {
        List<User> userList = userMapper.selectAll();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        System.out.println(userList);
        log.debug("【userList】= {}", userList);
    }

    /**
     * 根据用户编号查询用户
     */
    @Test
    public void selectUserById() {
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

    /**
     * 插入用户
     */
    @Test
    public void inertUser() {
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder()
                .name("testSave5")
                .password(SecureUtil.md5("123456"+ salt) )
                .salt(salt)
                .email("testEmail5@qq.com")
                .phoneNumber("1730000005")
                .status(1)
                .createTime(new DateTime())
                .lastLoginTime(new DateTime())
                .lastUpdateTime(new DateTime())
                .build();
        int i = userMapper.saveUser(user);
        Assert.assertEquals(1, i);
        System.out.println(i);
    }

    /**
     * 批量插入用户
     */
    @Test
    public void batchInsertUser(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String salt = IdUtil.fastSimpleUUID();
            User user = User.builder()
                    .name("testSave" + String.valueOf(i+100))
                    .password(SecureUtil.md5("123456"+ salt) )
                    .salt(salt)
                    .email("testEmail" + String.valueOf(i+100) + "@qq.com")
                    .phoneNumber("1730000" + String.valueOf(i+100))
                    .status(1)
                    .createTime(new DateTime())
                    .lastLoginTime(new DateTime())
                    .lastUpdateTime(new DateTime())
                    .build();
            userList.add(user);
        }
        int i = userMapper.batchSaveUser(userList);
        System.out.println(i);
    }

    @Test
    public void batchInsertCompare(){
        long l1 = System.currentTimeMillis();
        for (int i = 200; i < 300; i++){
            String salt = IdUtil.fastSimpleUUID();
            User user = User.builder()
                    .name("testSave" + String.valueOf(i))
                    .password(SecureUtil.md5("123456"+ salt) )
                    .salt(salt)
                    .email("testEmail" + String.valueOf(i) + "@qq.com")
                    .phoneNumber("1730000" + String.valueOf(i))
                    .status(1)
                    .createTime(new DateTime())
                    .lastLoginTime(new DateTime())
                    .lastUpdateTime(new DateTime())
                    .build();
            int j = userMapper.saveUser(user);
        }
        long l2 = System.currentTimeMillis();

        System.out.println("任务1执行时间：" + String.valueOf(l2-l1) + " 毫秒");

        long l3 = System.currentTimeMillis();
        List<User> userList = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            String salt = IdUtil.fastSimpleUUID();
            User user = User.builder()
                    .name("testSave" + String.valueOf(i))
                    .password(SecureUtil.md5("123456"+ salt) )
                    .salt(salt)
                    .email("testEmail" + String.valueOf(i) + "@qq.com")
                    .phoneNumber("1730000" + String.valueOf(i))
                    .status(1)
                    .createTime(new DateTime())
                    .lastLoginTime(new DateTime())
                    .lastUpdateTime(new DateTime())
                    .build();
            userList.add(user);
        }
        int i = userMapper.batchSaveUser(userList);
        System.out.println(i);
        long l4 = System.currentTimeMillis();
        System.out.println("任务2执行时间：" + String.valueOf(l4-l3) + " 毫秒");
    }


    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){
        int i = userMapper.deleteById(1L);
        Assert.assertEquals(1, i);
        System.out.println(i);
    }
    
    

}