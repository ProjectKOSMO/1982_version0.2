package com.javassem.service;


import com.javassem.domain.UserInfoViewVO;
import com.javassem.domain.UserVO;

public interface UserService {
  UserVO idCheck_Login(UserVO paramUserVO);
  
  int userInsert(UserVO paramUserVO);
  
  String userDate(UserVO paramUserVO);
  
  void insertUserInfoView(UserInfoViewVO paramUserInfoViewVO);
  
  void updateUserInfoView(UserInfoViewVO paramUserInfoViewVO);
  
  void deleteUserInfoView(UserInfoViewVO paramUserInfoViewVO);
  
  UserInfoViewVO getUserInfoView(UserInfoViewVO paramUserInfoViewVO);
}
