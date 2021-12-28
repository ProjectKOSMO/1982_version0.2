package com.javassem.controller;

import com.javassem.domain.ShopVO;
import com.javassem.service.ShopService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"user"})
public class ShopController {
    @Autowired
    private ShopService shopService;

    public ShopController() {
    }

    @RequestMapping({"storeClose.do"})
    public void select(ShopVO vo, Model m) {
        List<ShopVO> list = this.shopService.ShopList(vo);
        m.addAttribute("ShopList", list);
    }
}
