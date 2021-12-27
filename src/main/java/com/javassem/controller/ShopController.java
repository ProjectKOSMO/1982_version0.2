package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javassem.domain.ShopVO;
import com.javassem.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	// 일자리 찾기 업체 가져오기.
	@RequestMapping(value="/user/storeClose.do", method=RequestMethod.GET)
	public String select(ShopVO vo, Model m,String searchCondition, String searchKeyword ){
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<ShopVO> list = shopService.getShopList(map);
		m.addAttribute("ShopList", list);
		return "user/storeClose" ;
	}
	

	@RequestMapping({"/user/userSupport.do"})
	public void getShop(ShopVO vo, Model m){
		ShopVO result = this.shopService.getShop(vo);
		m.addAttribute("shop", result);
	}
	}
	

	

