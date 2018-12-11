package com.aowin.controller;

import com.aowin.dao.IUserDao;
import com.aowin.model.User;
import com.aowin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public User login(User loginuser, HttpSession session){
        try {
            User user=iUserService.getlogin(loginuser);
            session.setAttribute("user",user);
            if(user!=null){
                return user;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
