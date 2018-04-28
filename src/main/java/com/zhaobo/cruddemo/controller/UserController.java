package com.zhaobo.cruddemo.controller;


import com.zhaobo.cruddemo.entity.UserEntity;
import com.zhaobo.cruddemo.jpa.UserJPA;
import com.zhaobo.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping(value = "/user")
public class UserController {



    @Autowired
    private UserService userService;

//    @Autowired
//    private UserJPA userJPA;



    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,UserEntity user){
//        //直接将业务逻辑在controller里面写了
//        UserEntity userEntity = userJPA.findOne(new Specification<UserEntity>() {
//            @Override
//            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                criteriaQuery.where(criteriaBuilder.equal(root.get("t_name"),user.getT_name()));
//                return null;
//            }
//        });

         user = userService.login(user);
         if (user != null)
          {
             request.getSession().setAttribute("user",user);
             request.getSession().setAttribute("t_name",user.getT_name());
             request.getSession().setAttribute("t_address",user.getT_address());
             request.getSession().setAttribute("t_age",user.getT_age());
              return "user_index";
          }
         else {
             request.setAttribute("message","invalid username or password");
             request.setAttribute("time",new Date());
             return "index";
         }

    }
}
