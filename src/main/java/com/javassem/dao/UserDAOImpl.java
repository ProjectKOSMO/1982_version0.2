package com.javassem.dao;

import com.javassem.domain.UserInfoViewVO;
import com.javassem.domain.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
    @Autowired
    private SqlSessionTemplate mybatis;
  
    public UserVO idCheck(UserVO vo) {
    	System.out.println("===> UserMapper idCheck");
    	return (UserVO)this.mybatis.selectOne("user.idCheck", vo);
    }
  
    public int userInsert(UserVO vo) {
    	System.out.println("===>  MemberMapper userInsert()");
    	return this.mybatis.insert("user.userInsert", vo);
    }
  
    public UserVO userLogin(UserVO vo) {
    	System.out.println("===> UserMapper idCheck");
    	return (UserVO)this.mybatis.selectOne("user.idCheck", vo);
    }
  
    public String userDate(UserVO vo) {
    	return (String)this.mybatis.selectOne("sample.getDate", vo);
    }

	public void insertUserInfoView(UserInfoViewVO vo) {
		this.mybatis.insert("user.insertUserView", vo);
	}
	
	public void updateUserInfoView(UserInfoViewVO vo) {
		this.mybatis.update("user.updateUserView", vo);
	}
	
	public void deleteUserInfoView(UserInfoViewVO vo) {
	    this.mybatis.delete("user.deleteUserView", vo);
	}
	
	public UserInfoViewVO getUserInfoView(UserInfoViewVO vo) {
	    return (UserInfoViewVO)this.mybatis.selectOne("user.getUserView", vo);
	}
}
