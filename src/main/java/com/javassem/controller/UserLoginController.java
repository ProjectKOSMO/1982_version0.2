

package com.javassem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javassem.domain.UserVO;
import com.javassem.service.UserService;

@Controller
@RequestMapping({"user"})
public class UserLoginController {
	
    @Autowired
    public UserService userService;

    public UserLoginController() {
    }

    @RequestMapping({"{step.do}"})
    public String userJoin(@PathVariable String step) {
    	System.out.println("유저 컨트롤러 로그인입니다.");
        return "/user/" + step;
    }

    @RequestMapping({"userInsert.do"})
    public String userinsert(UserVO vo) {
        this.userService.userInsert(vo);
        return "redirect:user_login.do";
    }

    @RequestMapping({"login.do"})
    public String userLogin(UserVO vo, Model m, HttpServletRequest request) throws Exception  {
        UserVO result = this.userService.idCheck_Login(vo);
        if(result==null){
        	return "redirect:user_login.do";
        }else{
        	HttpSession session = request.getSession();
        	session.setAttribute("userNum", result.getUsernum());
        	session.setAttribute("userId", result.getUserid());
        	return "user/userMain";
        }
    }

    @RequestMapping(
        value = {"idCheck.do"},
        produces = {"application/text; charset=UTF-8"}
    )
    @ResponseBody
    public String idCheck(UserVO vo) {
        UserVO result = this.userService.idCheck_Login(vo);
        String message = "사용가능한 아이디 입니다.";
        if (result != null) {
            message = "이미 사용중인 아이디 입니다.";
        }

        return message;
    }
}
