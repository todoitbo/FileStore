package controller;

import com.alibaba.fastjson.JSON;
import entity.Store;
import entity.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.FileService;
import service.StoreService;
import service.UserService;
import utils.PinYinUtil;

@Controller
public class FileController
{
  FileService fs = new FileService();
  UserService us = new UserService();
  StoreService ss = new StoreService();
  public static Logger logger1 = Logger.getLogger(FileController.class);
  
  @RequestMapping({"/fileupload"})
  public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req, HttpServletResponse resp, String id)
    throws IOException, ServletException
  {
    User user = this.us.getUserByStoreId(Integer.parseInt(id));
    
    Store store = this.us.getStore(user);
    if (store.getCurSize() == store.getMaxSize())
    {
      req.getSession().setAttribute("onlineUser", user);
      req.getSession().setAttribute("store", store);
      req.setAttribute("error", "您的仓库已满!");
      return "success";
    }
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
    String datepath = sdf.format(new java.util.Date());
    String wholepath = req.getServletContext().getRealPath("/fileupload") + "/" + id + datepath;
    File directory = new File(wholepath);
    if (!directory.exists()) {
      directory.mkdirs();
    }
    InputStream is = file.getInputStream();
    String name = file.getOriginalFilename();
    String path1 = PinYinUtil.getPingYin(name);
    OutputStream os = new FileOutputStream(new File(wholepath, path1));
    String filePath = wholepath + path1;
    
    filePath = filePath.replace('\\', '/');
    
    int resFile = this.fs.isExist(store, filePath);
    if (resFile == -1)
    {
      this.fs.addFile(Integer.parseInt(id), filePath, new java.util.Date(), name);
      this.ss.addFile(store);
    }
    else
    {
      this.fs.upDateFile(store, filePath, new java.util.Date(), resFile);
    }
    store = this.us.getStore(user);
    int len = 0;
    byte[] bytes = new byte['Ѐ'];
    while ((len = is.read(bytes)) != -1) {
      os.write(bytes, 0, len);
    }
    os.close();
    is.close();
    req.getSession().setAttribute("onlineUser", user);
    req.getSession().setAttribute("store", store);
    return "success";
  }
  
  @RequestMapping(value={"/getFiles"}, produces={"text/json; charset=UTF-8"})
  public void getAllFiles(String storeId, HttpServletResponse resp)
    throws IOException
  {
    List<String> list = new ArrayList();
    list = this.fs.getAllFiles(Integer.parseInt(storeId));
    resp.setContentType("text/html;charset=UTF-8");
    String result = JSON.toJSONString(list);
    resp.getWriter().write(result);
  }
  
  @RequestMapping({"/downloadFile"})
  public void downloadFile(HttpServletResponse resp, String file, String storeId)
    throws IOException
  {
    logger1.info("进入============================downloadFile");
    resp.setContentType("text/html;charset=UTF-8");
    String[] files = file.split("--");
    String fileName = files[0];
    logger1.info("文件名============================" + fileName);
    String dateStr = files[1];
    logger1.info("日期字符串============================" + dateStr);
    String[] times = dateStr.split("-");
    int year = Integer.parseInt(times[0]);
    int month = Integer.parseInt(times[1]);
    int date = Integer.parseInt(times[2]);
    logger1.info("日期============================" + year + month + date);
    java.sql.Date time = new java.sql.Date(year - 1900, month - 1, date);
    String path = this.fs.getFilePath(fileName, time, Integer.parseInt(storeId));
    path = path.split("/webapps")[1];
    logger1.info("文件路径============================" + path);
    resp.getWriter().write(path);
  }
  
  @RequestMapping({"/deleteFile"})
  public void deleteFile(HttpServletResponse resp, String file, String storeId)
    throws IOException
  {
    resp.setContentType("text/html;charset=UTF-8");
    User user = this.us.getUserByStoreId(Integer.parseInt(storeId));
    Store store = this.us.getStore(user);
    String[] files = file.split("--");
    String fileName = files[0];
    String dateStr = files[1];
    String[] times = dateStr.split("-");
    int year = Integer.parseInt(times[0]);
    int month = Integer.parseInt(times[1]);
    int date = Integer.parseInt(times[2]);
    java.sql.Date time = new java.sql.Date(year - 1900, month - 1, date);
    String path = this.fs.getFilePath(fileName, time, Integer.parseInt(storeId));
    System.out.println(path);
    File filetemp = new File(path);
    if ((filetemp.exists()) && (filetemp.isFile())) {
      filetemp.delete();
    }
    this.fs.deleteFile(fileName, time, Integer.parseInt(storeId));
    this.ss.deleFile(store);
    
    resp.getWriter().write("删除成功!");
  }
}
