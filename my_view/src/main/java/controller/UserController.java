package main.java.controller;

import main.java.api.weather.Weather;
import main.java.service.ImageService;
import main.java.service.UserService;
import main.java.tools.CreatVcodeImage;
import main.java.vo.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService UserService;
    @Autowired
    private ImageService imageService;

    //用户登录
    @RequestMapping(value = "/ajaxLoginCheck.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(String usename, String password, String vcode_enter, String autologin, HttpSession session, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String vcode = (String) session.getAttribute("vcode");
        List<Image> imageList=imageService.getImagesByGroupId("1");
        System.out.println(UserService.queryUsersByCity());
        if (!vcode_enter.equalsIgnoreCase(vcode)) {
            map.put("code", 1);
            map.put("info", "验证码错误");
        } else {
            map = (Map<String, Object>) UserService.getUser(usename,password);
            if (map.get("code").equals(0)) { 
                session.setAttribute("lunboImage",imageList);
                session.setAttribute("currentuser",map.get("currentuser"));
                if (autologin != null) { 
                    Cookie cookie1 = new Cookie("userName", usename);
                    cookie1.setMaxAge(14 * 24 * 24 * 24); // 设置有效期为14天
                    response.addCookie(cookie1);
                    Cookie cookie2 = new Cookie("password", password);
                    cookie2.setMaxAge(14 * 24 * 24 * 24); // 设置有效期为14天
                    response.addCookie(cookie2);
                }

            }
        }
        return map;
    }

    @RequestMapping(value = "/createVerifyImage.do", method = RequestMethod.GET)
    public void CreateVerifyImage(HttpSession session,
                                  HttpServletResponse response) throws IOException {
        CreatVcodeImage creatVcodeImage = new CreatVcodeImage();
        String vCode = creatVcodeImage.creatCode();
        session.setAttribute("vcode", vCode);

        response.setContentType("img/jpeg");
        BufferedImage image = creatVcodeImage.creatimage(vCode);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/logOut.do", method = RequestMethod.GET)
    public void logOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session.removeAttribute("current");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DengLu.html");
        requestDispatcher.forward(request, response);
    }


    @RequestMapping(value = "/getWeather.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getWeather(@RequestParam(value = "city",defaultValue = "武汉") String city){
        String weather = Weather.queryWeather(city);
        System.out.println(weather);
       return weather;
    }

    @RequestMapping(value = "/getCityPerson.do")
    @ResponseBody
    public List<Map<String, Object>> getCityPerson(){
        List<Map<String,Object>>list=UserService.queryUsersByCity();
        return list;
    }
}
