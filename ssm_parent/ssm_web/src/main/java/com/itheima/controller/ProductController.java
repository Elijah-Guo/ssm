package com.itheima.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController{


    @Autowired
    private ProductService productService;

    @RequestMapping("/findByPageHelper")
    public ModelAndView findByPageHelper(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
    ){

        PageInfo<Product> pageInfo=productService.findByPageHelper(pageNum,pageSize);

        ModelAndView mv = new ModelAndView();

        mv.addObject("pageInfo",pageInfo);

        mv.setViewName("product-list-pagehelper");

        return mv;
    }

    //页面不再拼接接收参数，而采用映射参数名，设置默认值传参数
    @RequestMapping("/findByPage")
    public ModelAndView findByPage(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        ModelAndView mv = new ModelAndView();

        PageBean<Product> beanList = productService.findByPage(pageNum, pageSize);

        mv.addObject("beanList",beanList);

        mv.setViewName("product-list-page");


        return mv;
    }

    @RequestMapping("/delete")
    public String delete(Long[] ids){

        productService.delete(ids);

        return "redirect:/product/findAll";
    }

    @RequestMapping("/update")
    public String update(Product product){

        productService.updateProduct(product);

        return "redirect:/product/findAll";
    }

    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Long id){

        ModelAndView mv = new ModelAndView();
        Product product=productService.findProductById(id);


        mv.addObject("product",product);

        mv.setViewName("product-update");

        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product){

        productService.save(product);

        return "redirect:/product/findAll";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("1");
        List<Product> productList=productService.findAll();
        System.out.println(productList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList",productList);

        mv.setViewName("product-list");

        return mv;
    }

}
