package com.zhaobo.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
//加了(strategy = GenerationType.IDENTITY)
//
//根据底层数据库自动选择方式，需要底层数据库的设置
//
//如MySQL，会使用自增字段，需要将主键设置成auto_increment
// 没添加之前报Table 'test.hibernate_sequence' doesn't exist错
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long t_id;

    @Column(name = "t_name")
    private String t_name;

    @Column(name = "t_age")
    private int t_age;

    @Column(name = "t_address")
    private String t_address;

    @Column(name = "t_pwd")
    private String t_pwd;

    @Column(name = "t_pic")
    private String t_pic;

}
