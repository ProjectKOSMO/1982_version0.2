package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.GraphVO;



public interface GraphDAO {

	List<GraphVO> getMatchList();
	List<GraphVO> getReusingList();
	int getJoinTotal();
	int getJoinToday();
	int getJoinYesterday1();
	int getJoinYesterday2();
	int getJoinYesterday3();
	int getJoinYesterday4();
}
