package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.Payed_listVO;
import com.javassem.service.MemberSV;
import com.javassem.service.PaySV;

@RestController
public class ImportController {
	
	@Autowired
	MemberSV memberSV;
	@Autowired
	PaySV paySV;
	
	@RequestMapping("insertPayCoupon.do")
	@ResponseBody
	public int pay(@RequestBody Payed_listVO pvo) {
		System.out.println("pvo.getMerchant_uid : " + pvo.getMerchant_uid());
		int res = paySV.insert_pay(pvo);
		if(res == 1) {
			Biz_memberVO bvo = memberSV.selectBizMember(pvo.getBiz_email());
			bvo.setPay_coupon(bvo.getPay_coupon()+5);
			System.out.println("paycoupon: " + bvo.getPay_coupon());
			res = paySV.updateBiz_pay(bvo);
			if(res == 1)
				System.out.println("biz_member pay coupon insert complete");
		}
		
		return res;
	}
	
//	@RequestMapping(value = "/coupon_cancel.do")
//	@ResponseBody
//	public String cancel(@RequestParam(value= "biz_email") String biz_email) {
//		System.out.println("biz_email = " + biz_email);
//		Payed_listVO pvo = paySV.recentlyPay(biz_email);
//					
//		PaymentCheck obj = new PaymentCheck();
//		String token = obj.getImportToken();
//		System.out.println("merchant_uid :" + pvo.getMerchant_uid());
//		int res = obj.cancelPayment(token, pvo.getMerchant_uid());
//		
//		if(res == 1) {
//			Biz_memberVO bvo = memberSV.selectBizMember(pvo.getBiz_email());
//			bvo.setPay_coupon(bvo.getPay_coupon()-5);
//			System.out.println("paycoupon: " + bvo.getPay_coupon());
//			res = paySV.updateBiz_refund(bvo);
//			if(res ==1) {
//				res = paySV.refund_pay(pvo.getMerchant_uid());
//				if(res ==1) { return "Success";}
//			}else {	return "biz_refund Failure"; }
//			return "thanks";
//		}
//		else 
//			return "anyway Failure"; 
//	}
}
