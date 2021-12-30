package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.GraphDAO;
import com.javassem.domain.GraphVO;

@Service("graphService")
public class GraphServiceImpl implements GraphService {
	
	@Autowired
	private GraphDAO graphDAO;


	public List<GraphVO> getMatchList() {
		return this.graphDAO.getMatchList();
	}
	public List<GraphVO> getReusingList() {
		return this.graphDAO.getReusingList();
	}
	public int getJoinTotal(){
		return this.graphDAO.getJoinTotal();
	}
	public int getJoinToday(){
		return this.graphDAO.getJoinToday();
	}
	public int getJoinYesterday1(){
		return this.graphDAO.getJoinYesterday1();
	}
	public int getJoinYesterday2(){
		return this.graphDAO.getJoinYesterday2();
	}
	public int getJoinYesterday3(){
		return this.graphDAO.getJoinYesterday3();
	}
	public int getJoinYesterday4(){
		return this.graphDAO.getJoinYesterday4();
	}

	

}
