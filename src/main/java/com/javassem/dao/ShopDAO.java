package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.ShopVO;

public interface ShopDAO {

/*	public List<ShopVO> ShopList(ShopVO vo);*/
	
	public List<ShopVO> getShopList(HashMap map);
	
	ShopVO getShop(ShopVO paramShopVO);
	
	int countShop();
}
