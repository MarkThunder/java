package com.jarico.stu_management_sys.controller;


import com.jarico.stu_management_sys.utils.ValidateImageCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
 * 这个类主要是用来接收前端发送的请求
 * */
@Controller
@RequestMapping("user")
public class UserController {

    /*定义一个方法。
    这个方法是用来返回给前端一个验证码图片的
    * */

    //生成验证码，将验证码图片返回到前端界面
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //获取验证码id，并设置到session中
        String code = ValidateImageCodeUtils.getSecurityCode();
        System.out.println("code = " + code);
        //设置到session
        session.setAttribute("code", code);
        //生成验证码图片
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        ImageIO.write(image, "png", response.getOutputStream());
    }
}
