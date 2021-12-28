package com.javassem.service;
import com.javassem.domain.ShopVO;
import java.util.List;

public interface ShopService {
  List<ShopVO> ShopList(ShopVO paramShopVO);

	// 글 목록 조회
/*	List<ShopVO> ShopList(ShopVO vo);*/

	List<ShopVO> getShopList(HashMap map);

	int countShop();
	
	ShopVO getShop(ShopVO paramShopVO);
	
	ShopVO support(ShopVO paramShopVO);
}
