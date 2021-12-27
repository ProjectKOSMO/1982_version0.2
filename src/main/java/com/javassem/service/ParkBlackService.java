package com.javassem.service;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;

import java.util.HashMap;
import java.util.List;

public interface ParkBlackService {
  List<ParkBlackVO> getBlackList(HashMap map);
  int countBlacklist();
}
