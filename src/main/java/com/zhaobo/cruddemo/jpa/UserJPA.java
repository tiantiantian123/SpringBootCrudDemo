package com.zhaobo.cruddemo.jpa;

import com.zhaobo.cruddemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface UserJPA extends JpaRepository<UserEntity,Long>,JpaSpecificationExecutor<UserEntity>,Serializable {

    @Query(value = "select * from t_user where t_name = ?1 and t_pwd = ?2",nativeQuery = true)
    public List<UserEntity> nativeLogin(String t_name, String t_pwd);
}
