package com.javassem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.MemberDAOImpl;
import com.javassem.domain.Biz_memberVO;

@Service("memberSV")
public class MemberSVImpl implements MemberSV{

	  @Autowired
	  private MemberDAOImpl memberDAO;
	  
	  
	@Override
	public Biz_memberVO selectBizMember(String Biz_email) {
		
		System.out.println("MemberDAO 실행");
	    return memberDAO.selectMember(Biz_email);	
	};

}
