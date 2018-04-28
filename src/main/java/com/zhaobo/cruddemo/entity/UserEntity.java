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

    @Id
    @GeneratedValue
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

}
