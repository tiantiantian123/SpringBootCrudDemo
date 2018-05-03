package com.zhaobo.cruddemo.controller;

import com.zhaobo.cruddemo.entity.UserEntity;
import com.zhaobo.cruddemo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class SignController {

    @Autowired
    private UserJPA userJPA;


    @RequestMapping(value="/signup")
    public String submit(@RequestParam(value="t_name") String name,
                         @RequestParam(value="t_pwd") String password,
                         @RequestParam(value = "t_address") String addr,
                         @RequestParam(value = "t_age") int age,
                         @RequestParam(value="t_pic")MultipartFile file,
                         HttpServletRequest request) {
        UserEntity user = new UserEntity();
        user.setT_name(name);
        user.setT_pwd(password);
        user.setT_address(addr);
        user.setT_age(age);
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("d:\\workspace_zhaobo\\cruddemo\\src\\main\\webapp\\static\\img\\"+name+".jpg")));//保存图片到目录下
                out.write(file.getBytes());
                out.flush();
                out.close();
                String filename=name+".jpg";
                user.setT_pic(filename);
                userJPA.save(user);//增加用户
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            request.getSession().setAttribute("user",user);
            return "user_index";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

}
