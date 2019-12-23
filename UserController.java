package controller;

import cn.dsna.util.images.ValidateCode;
import entity.Store;
import entity.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
public class UserController
{
  UserService us = new UserService();
  User user = new User();
  Store store = new Store();
  
  @RequestMapping({"/register"})
  public String register(User user, HttpServletRequest req, HttpServletResponse response, String inputCode)
  {
    String code = (String)req.getSession().getAttribute("code");
    if ((inputCode != null) && (inputCode.equalsIgnoreCase(code)))
    {
      if (this.us.isExist(user))
      {
        req.setAttribute("tip", "该用户名已被使用!");
        return "forward:register.jsp";
      }
      this.us.register(user);
      Store store = this.us.getStore(user);
      this.store = store;
      this.user = user;
      req.getSession().setAttribute("onlineUser", user);
      return "forward:login.jsp";
    }
    req.setAttribute("codeError", "验证码错误!");
    return "forward:register.jsp";
  }
  
  @RequestMapping({"/login"})
  public String login(User user, HttpServletRequest req, HttpServletResponse response, String inputCode)
    throws IOException
  {
    String code = (String)req.getSession().getAttribute("code");
    if ((inputCode != null) && (inputCode.equalsIgnoreCase(code)))
    {
      User userTemp = user;
      if (!this.us.isExist(user))
      {
        req.setAttribute("error", "请先注册!");
        return "forward:login.jsp";
      }
      userTemp = this.us.login(user);
      if ((this.us.isExist(user)) && (userTemp.getUserId() == 0))
      {
        req.setAttribute("error", "密码错误!");
        return "forward:login.jsp";
      }
      req.getSession().setAttribute("onlineUser", userTemp);
      
      Store store = this.us.getStore(userTemp);
      req.setAttribute("store", store);
      return "success";
    }
    req.setAttribute("codeError", "验证码错误!");
    return "forward:login.jsp";
  }
  
  @RequestMapping({"/getCode"})
  public void getCode(HttpServletRequest request, HttpServletResponse response)
  {
    response.setContentType("image/jpeg");
    
    ValidateCode code = new ValidateCode(100, 35, 4, 25);
    String myCode = code.getCode();
    
    request.getSession().setAttribute("code", myCode);
    try
    {
      code.write(response.getOutputStream());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
