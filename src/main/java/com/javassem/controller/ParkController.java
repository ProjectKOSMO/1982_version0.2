package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;
import com.javassem.domain.ParkVO;
import com.javassem.domain.ParkownerVO;
import com.javassem.service.ParkBlackService;
import com.javassem.service.ParkService;
import com.javassem.service.ParkownerService;


@Controller
public class ParkController {
	
	
	@Autowired
	public ParkService parkService;
	@Autowired
	public ParkBlackService parkBlackService;
	@Autowired
	public ParkownerService parkownerService;
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@RequestMapping("admin/{step}.do") // 단순 페이지 이동용
	public String parkJoin(@PathVariable String step){
		System.out.println("호출");
		return "/admin/" +step;
	}
	
	@RequestMapping("admin/adminPage.do") //로그인과 동시에 블랙리스트 + 예치금리스트 데이터 넘기기
	public String userLogin(ParkVO vo,Model m,Model m2,PagingVO vo1){
		ParkVO result =  parkService.idCheck_Login(vo);
		if(result != null){
			System.out.println("리스트");
			
			List<ParkBlackVO> list = parkBlackService.getBlackList(vo1);
			m.addAttribute("blacklist",list);
			
			List<ParkownerVO> list2 = parkownerService.getOwnerList(vo1);
			m2.addAttribute("ownerlist",list2);
			
			System.out.println(list);
			System.out.println(list2);
			
			int matching = mybatis.selectOne("hold.matching");
			int whole = mybatis.selectOne("hold.wholeApply");
			int matchingPercent = mybatis.selectOne("hold.matching_percent");
			
			int reusing = mybatis.selectOne("hold.reusing");
			int whole2 = mybatis.selectOne("hold.wholeUse");
			int reusePercent = mybatis.selectOne("hold.reusePercent");
			
			int joinToday = mybatis.selectOne("hold.joinToday");
			int joinYesterday1 = mybatis.selectOne("hold.joinYesterday1");
			int joinYesterday2 = mybatis.selectOne("hold.joinYesterday2");
			int joinYesterday3 = mybatis.selectOne("hold.joinYesterday3");
			int joinYesterday4 = mybatis.selectOne("hold.joinYesterday4");
			
			int cumulToday = mybatis.selectOne("hold.cumulateToday");
			int cumulYesterday1 = mybatis.selectOne("hold.cumulateYesterday1");
			int cumulYesterday2 = mybatis.selectOne("hold.cumulateYesterday2");
			int cumulYesterday3 = mybatis.selectOne("hold.cumulateYesterday3");
			int cumulYesterday4 = mybatis.selectOne("hold.cumulateYesterday4");
			
			
			m.addAttribute("matching", matching);
			m.addAttribute("wholeApply", whole);
			m.addAttribute("matchingPercent", matchingPercent);
			
			m.addAttribute("reusing", reusing);
			m.addAttribute("wholeUse", whole2);
			m.addAttribute("reusePercent", reusePercent);
			
			m.addAttribute("joinToday", joinToday);
			m.addAttribute("joinYesterday1", joinYesterday1);
			m.addAttribute("joinYesterday2", joinYesterday2);
			m.addAttribute("joinYesterday3", joinYesterday3);
			m.addAttribute("joinYesterday4", joinYesterday4);
			
			m.addAttribute("cumulToday", cumulToday);
			m.addAttribute("cumulYesterday1", cumulYesterday1);
			m.addAttribute("cumulYesterday2", cumulYesterday2);
			m.addAttribute("cumulYesterday3", cumulYesterday3);
			m.addAttribute("cumulYesterday4", cumulYesterday4);
			
			return "/admin/" + "adminPage";
			
		}else{
			System.out.println("실패");
			return "./main";
		}
	}
}
