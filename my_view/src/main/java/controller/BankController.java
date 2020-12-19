package main.java.controller;

import com.github.pagehelper.PageHelper;
import main.java.service.BankDetailsService;
import main.java.service.BankService;
import main.java.tools.CreatDetailPicture;
import main.java.tools.ZxingCodeImage;
import main.java.vo.Bankdetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BankController {
    @Autowired
    private BankService bankService;
    @Autowired
    private BankDetailsService bankDetailsService;

    @RequestMapping(value = "zhuanzhang.do")
    @ResponseBody
    public Map<String, Object> zhuanZhang(String money, String password, String other) {
        Map<String, Object> map = bankService.zhuanZhang(Integer.parseInt(money), password, other);
        return map;
    }

    @RequestMapping(value = "qukuan.do")
    @ResponseBody
    public Map<String, Object> quKuan(String money, String password) {
        Map<String, Object> map = bankService.quKuan(Integer.parseInt(money), password);
        return map;
    }

    @RequestMapping(value = "getYuE.do")
    @ResponseBody
    public Map<String, Object> yuE() {
        Map<String, Object> map = bankService.yuE();
        return map;
    }

    @RequestMapping(value = "getBankDetail.do")
    @ResponseBody
    public Map<String, Object> getBankDetails(@RequestBody Map<String, String> map) {
        int total=bankDetailsService.getBankDetailsCount(map.get("time"),map.get("inorout"));
        PageHelper.startPage(Integer.parseInt(map.get("pageNumber")),Integer.parseInt(map.get("pageSize")));
        List<Bankdetail> bankdetailList=bankDetailsService.getBankDetails(map.get("time"),map.get("inorout"));
        Map<String,Object>bankDetailMap=new HashMap<>();
        bankDetailMap.put("bankDetails",bankdetailList);
        bankDetailMap.put("total",total);
        return bankDetailMap;
    }

    @RequestMapping(value = "creataDetailsImage.do")
    @ResponseBody
    public void creataDetailsImage(@RequestParam(value = "id",defaultValue = "9") Integer id, HttpServletResponse response) throws IOException {
        List<Bankdetail> bankdetail=bankDetailsService.selectBankDetailById(id);
        BufferedImage image = CreatDetailPicture.creatDetailImage(bankdetail.get(0));
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        out.flush();
        out.close();
    }
}
