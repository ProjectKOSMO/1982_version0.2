import com.javassem.domain.ShopVO;
import com.javassem.service.ShopService;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

private ShopService shopService;

  @RequestMapping({"storeClose.do"})
  public void select(HashMap vo, Model m) {
    List<ShopVO> list = this.shopService.getShopList(vo);
    m.addAttribute("ShopList", list);
  }
}
