package com.javassem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.SupportVO;
import com.javassem.domain.UserVO;
import com.javassem.service.UserService;


@Controller
public class UserController {
	
    @Autowired // 의존성 주입
    public UserService userService;
    
    @RequestMapping({"/user/userMypage.do"})
    public void getuser(UserVO vo, SupportVO vo1, Model m) {
      UserVO result = this.userService.getUserInfoView(vo);
      SupportVO support = this.userService.getSupportView(vo1);
      m.addAttribute("user", result);
      m.addAttribute("support", support);
    }
    
    @RequestMapping({"/user/updateMypage.do"})
    public String updateBoard(UserVO vo) {
      this.userService.updateUserInfoView(vo);
      return "redirect:userMypage.do";
    }
}
