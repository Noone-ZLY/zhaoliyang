package com.zly.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    /*
     * id主键
     */
    private Long id;

    /*
     * 姓名
     */
    private String name;

    /*
     * 密码
     */
    private String password;

    /*
     * 盐值
     */
    private String salt;

    /*
     * 邮箱
     */
    private String email;

    /*
     * 电话号码
     */
    private String phoneNumber;

    /*
     * 登陆状态
     */
    private Integer status;

    /*
     * 用户创建时间
     */
    private Date createTime;

    /*
     * 用户上次登录时间
     */
    private Date lastLoginTime;

    /*
     * 用户更新时间
     */
    private Date lastUpdateTime;
}
