package com.aowin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RemoveController {
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public void removeuser(HttpSession session){
        session.removeAttribute("user");
    }
}
