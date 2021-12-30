package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.GraphVO;

@Repository("graphDAO")
public class GraphDAOImpl implements GraphDAO{
	
	@Autowired
	  private SqlSessionTemplate mybatis;

	
	public List<GraphVO> getMatchList() {
		return this.mybatis.selectList("hold.matching_percent");
	}
	public List<GraphVO> getReusingList() {
		return this.mybatis.selectList("hold.reusePercent");
	}
	public int getJoinTotal(){
		return this.mybatis.selectOne("hold.joinTotal");
	}
	public int getJoinToday(){
		return this.mybatis.selectOne("hold.joinToday");
	}
	public int getJoinYesterday1(){
		return this.mybatis.selectOne("hold.joinYesterday1");
	}
	public int getJoinYesterday2(){
		return this.mybatis.selectOne("hold.joinYesterday2");
	}
	public int getJoinYesterday3(){
		return this.mybatis.selectOne("hold.joinYesterday3");
	}
	public int getJoinYesterday4(){
		return this.mybatis.selectOne("hold.joinYesterday4");
	}
	

}
