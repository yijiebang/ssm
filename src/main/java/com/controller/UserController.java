package com.controller;

import com.bean.Users;
import com.service.UsersService;
import com.util.exportFileUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UsersService userService;

    /*接收数据新增后，再跳转到listUsers查询页面*/
    @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
    public ModelAndView addUsers(Users users) {
        ModelAndView mav = new ModelAndView();
        userService.insert(users);
        mav.setViewName("redirect:listUsers");
        return mav;
    }

    /**
     * 根据编号，进行删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteUsersByBid")
    public ModelAndView deleteUsersByBid(int id) {
        ModelAndView mav = new ModelAndView();
        userService.delete(id);
        mav.setViewName("redirect:listUsers");
        return mav;
    }

    /**
     * 通过占位符获取编号查询详情，转到修改页面
     *
     * @param id
     * @param
     * @return
     */
    @RequestMapping("/updatepage/{id}")
    public ModelAndView updatepage(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView();
        model.addObject("users", userService.selectByPrimaryKey(id));
        model.setViewName("updatepage");
        return model;
    }

    /**
     * 传入对象，进行修改
     *
     * @param b
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(Users b) {
        ModelAndView mav = new ModelAndView();
        userService.update(b);
        mav.setViewName("redirect:listUsers");
        return mav;
    }


    /**
     * 设置listUsers查询所有
     *
     * @return
     */
    @RequestMapping("/listUsers")
    public ModelAndView listUsers() {
        ModelAndView mav = new ModelAndView();
        Users u = new Users();
        List<Users> bb = userService.list();
        mav.addObject("bb", bb);
        mav.setViewName("index");
        log.info("/listUsers");
        return mav;
    }


    //上传图片
    @RequestMapping(value = "/savePicture", method = RequestMethod.POST)
    public String savePic(@RequestParam(value = "image", required = false) MultipartFile image, HttpServletRequest request, Model model) {
        //获取图片在服务器上的存储位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        System.out.println("文件保存的路径" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {

            System.out.println("图片目录不存在，创建图片路径" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称
        String originalFileName = image.getOriginalFilename();
        System.out.println("原始文件的名称" + originalFileName);

        //获取文件的类型，以“.”作为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型" + type);

        //设置文件的新名字
        String fileName = System.currentTimeMillis() + "." + type;
        System.out.println("文件新名称" + fileName);


        //在指定的路径下面创建一个新的文件
        File targerFile = new File(path, fileName);


        //将文件保存到服务器的指定位置
        try {

            image.transferTo(targerFile);
            model.addAttribute("msg", "保存图片成功");
            Users u = new Users();
            u.setEmail("/upload/" + fileName);
            userService.insert(u);

            // return "redirect:listUsers";
        } catch (IllegalStateException | IOException e) {
            System.out.println("文件保存错误");
            e.printStackTrace();
        }


        return "redirect:listUsers";

    }

    /**
     * 文件下载
     *
     * @param fpath
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/downPhotoById")
    public ResponseEntity<byte[]> download(String fpath, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/");
        File file = new File(path + fpath);
        HttpHeaders headers = new HttpHeaders();
        String fileName = new String(file.getName().getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }


    /**
     * 导出Excel
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void export(HttpServletResponse response) throws Exception{
        //从数据库获取需要导出的数据
        List<Users> entityList = new ArrayList<Users>();
        entityList=userService.list();
        //导出操作
        exportFileUtil.exportExcel(entityList,"用户信息","第一页",Users.class,"Users.xls",response);
    }

    /**
     * Excel导入
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("importExcel")
    public ModelAndView importExcel(@RequestParam("textFile") MultipartFile file,HttpServletRequest request) throws Exception{
        ModelAndView mav = new ModelAndView();

        //String filePath = "F:\\故乡南.xls";
        System.out.println(file);//用来检查前端是否把文件传过来
        //解析excel，
        List<Users> personList = exportFileUtil.importExcel(file, 1, 1,Users.class);
        //也可以使用FileUtil.importExcel(filePath,1,1,FileEntity.class) 导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库
        for (Users users:personList){
            System.out.println(users.getUsername());
            users.setId(null);
            userService.insert(users);
        }
        mav.setViewName("redirect:listUsers");
        return mav;
    }

}  