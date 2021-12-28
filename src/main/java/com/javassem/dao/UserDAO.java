package com.javassem.dao;

import com.javassem.domain.UserInfoViewVO;
import com.javassem.domain.UserVO;

public interface UserDAO {
  UserVO idCheck(UserVO paramUserVO);
  
  int userInsert(UserVO paramUserVO);
  
  UserVO userLogin(UserVO paramUserVO);
  
  void insertUserInfoView(UserInfoViewVO paramUserInfoViewVO);
  
  void updateUserInfoView(UserInfoViewVO paramUserInfoViewVO);
  
  void deleteUserInfoView(UserInfoViewVO paramUserInfoViewVO);
  
  UserInfoViewVO getUserInfoView(UserInfoViewVO paramUserInfoViewVO);
}
