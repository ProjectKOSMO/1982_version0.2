package com.javassem.service;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;

import java.util.HashMap;
import java.util.List;

public interface ParkBlackService {
	int countBlacklist();
	List<ParkBlackVO> getBlackList(HashMap map);
	int checkCnt(ParkBlackVO vo);
	void stopAccount(HashMap map);
}
