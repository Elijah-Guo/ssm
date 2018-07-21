package com.itheima.web;

import com.itheima.entity.UserInfo;
import com.itheima.util.CustomException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/UserViewAction")
@SessionAttributes(value = {"user"}, types = {UserInfo.class})
public class UserViewAction {

    @RequestMapping("/ceshi")
    public String ceshi(Date date) {
        System.out.println(date);
        return "show";
    }

    /**
     * session中存值
     */
    @RequestMapping("/addsession")
    public String addsession(Model model, UserInfo user) {
        model.addAttribute("username", user);
        return "show";
    }

    @RequestMapping("/getsession")
    public String getsession(ModelMap map, UserInfo user) {
        System.out.println(map.get("username"));
        return "show";
    }

    @RequestMapping("/removesession")
    public String removesession(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "show";
    }


    /**
     * 此方法与request.setAttribute方法效果一致(存入的值,一次request访问有效)
     *
     * @return
     */
    @ModelAttribute
    public UserInfo addrequest1() {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setUsername("赵文明");// key username val 赵文明 --> 传输出过来的值
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("北京昌平区");
        return user;
    }

    @RequestMapping("/addrequest")
    public String addrequest(UserInfo user) {
        System.out.println(user);
        return "show";
    }

    /**
     * Restful的基本使用
     *
     * @param id
     * @return
     */
    @RequestMapping("/Restful/{id}")
    public String Restful(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "show";
    }

    /**
     * 利用Restful风格展示添加更新删除方法
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/insertRestful")
    public String insertRestful(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("执行了添加");
        return "show";
    }

    /**
     * @param id
     * @param username
     * @param password
     * @return
     * @ResponseBody的作用：将你的响应结果变成一个字符串
     * @PathVariable的作用:绑定url中的占位符{id}
     */
    @ResponseBody
    @RequestMapping(value = "/updateRestful/{id}", method = RequestMethod.PUT)
    public String updateRestful(@PathVariable("id") Integer id, String username, String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("执行了更新");
        return "show";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRestful/{id}", method = RequestMethod.DELETE)
    public String deleteRestful(@PathVariable("id") Integer id, String username, String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println("执行了删除");
        return "show";
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password) {
        String msg = "登陆失败，请重新登陆!";
        if ("admin".equals(username) && "123456".equals(password)) {
            msg = "登陆成功，管理员你好";
        }
        ModelAndView mv = new ModelAndView();
        //将信息存入ModelAndView中
        mv.addObject("msg", msg);
        mv.setViewName("show");
        return mv;
    }

    /**
     * springmvc的转发和重定向
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/ZZlogin")
    public String ZZlogin(String username, String password) {
        String msg = "登陆失败，请重新登陆!";
        if ("admin".equals(username) && "123456".equals(password)) {
            msg = "登陆成功，管理员你好";
        }
        //需要注意的是，如果用了formward：则路径必须写成实际视图url，不能写逻辑视图。
        return "forward:/WEB-INF/pages/show.jsp";
        //需要注意的是，如果是重定向到jsp页面，则jsp页面不能写在WEB-INF目录中，否则无法找到
        //return "response.sendRedirect(url)";
    }

    /**
     * requestbody的作用:将传来的参数转化为字符串
     *
     * @return
     */
    @RequestMapping("/login1")
    public String login1(@RequestBody String params) {
        System.out.println(params);
        return "show";
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public UserInfo ajax(Integer id) {
        UserInfo user = new UserInfo();
        user.setId(1);
        user.setUsername("孙建国");
        user.setAddress("北京市东城区");
        user.setSex("男");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username", required = false) String username,
                         @RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile, HttpServletRequest request) {
        System.out.println(username+"开始上传");
        //创建文件名字
        String filename = "";
        //获取源文件
        String ycfilename = uploadfile.getOriginalFilename();
        //获取文件名的类型
        String typefilename = ycfilename.substring(ycfilename.lastIndexOf("."), ycfilename.length());
        //UUID创建新文件名
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //拼接新的文件名
        filename = uuid + typefilename;

        //获取上传服务器文件的根路径
        //代码返回的是项目在容器中的实际发布运行的根路径
        String path = request.getSession().getServletContext().getRealPath("/uploadfile");
        //创建文件夹
        File file = new File(path);
        //判断文件夹是否存在
        if (!file.exists()) {
            //不存在，创建
            file.mkdir();
        }
        //创建当日时间
        String s = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //创建二级文件夹，用当天的时间命名
        File file1 = new File(path + "/" + s);
        if (!file1.exists()) {
            //不存在，创建
            file1.mkdir();
        }

        //将上传的文件放入文件夹
        try {
            uploadfile.transferTo(new File(file1, filename));
            System.out.println("文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件上传失败");
        }
        return "show";
    }


    /**
     * 远程上传
     * @param username
     * @param uploadfile
     * @param request
     * @return
     */
    @RequestMapping("/yuancheng")
    public String yuancheng(@RequestParam(value = "username", required = false) String username,
                         @RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile, HttpServletRequest request) {
        System.out.println(username+"开始远程上传");
        // 客户端接收的文件传给服务端
        String url = "http://127.0.0.1:8082/heihei/uploadfile/";
        //创建文件名字
        String filename = "";
        //获取源文件
        String ycfilename = uploadfile.getOriginalFilename();
        //获取文件名的类型
        String typefilename = ycfilename.substring(ycfilename.lastIndexOf("."), ycfilename.length());
        //UUID创建新文件名
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        //拼接新的文件名
        filename = uuid + typefilename;

        //获取上传服务器文件的根路径
        //代码返回的是项目在容器中的实际发布运行的根路径
        String path = request.getSession().getServletContext().getRealPath("/uploadfile");
        //创建文件夹
        File file = new File(path);
        //判断文件夹是否存在
        if (!file.exists()) {
            //不存在，创建
            file.mkdir();
        }
        //创建当日时间
        String s = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //创建二级文件夹，用当天的时间命名
        File file1 = new File(path + "/" + s);
        if (!file1.exists()) {
            //不存在，创建
            file1.mkdir();
        }

        System.out.println("开始上传");
        // 上传服务器
        // 1. 创建通信客户端
        Client client = Client.create();
        // 2. 创建web资源
        // http://127.0.0.1:8082/fileserver/uploads/0015555ADSADAS1A21AD.jpg
        WebResource resource = client.resource(url+filename);
        try {
            // 流式操作
            String result = resource.put(String.class,uploadfile.getBytes());
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }
        return "show";
    }

    /**
     * 报错
     */
    @RequestMapping("/error")
    public String error() throws CustomException {
        throw new CustomException("报了一个错误，不知道什么情况");
    }
}
