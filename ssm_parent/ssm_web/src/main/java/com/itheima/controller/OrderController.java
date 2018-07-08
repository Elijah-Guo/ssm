package com.itheima.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    //注意：可以双重注入，需要哪个在注入哪个.因为都在context容器中,随便用
    @Autowired
    private ProductService productService;

    /**
     * 根据ID查询订单
     * @return
     */
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Long id){
        ModelAndView mv = new ModelAndView();

        Order order=orderService.findOrderByID(id);

        mv.addObject("order",order);

        mv.setViewName("order-update");
        return mv;
    }


    @RequestMapping("/delete")
    public String delete(Long[] ids){

        /*对应ID删除订单*/
        orderService.delete(ids);

        return "redirect:/order/findByPageHelper";
    }

    /**
     * 分页助手分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findByPageHelper")
    public ModelAndView findByPageHelper(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize
    ){

        ModelAndView mv = new ModelAndView();

        PageInfo<Order> pageInfo = orderService.findByPageHelper(pageNum, pageSize);

        mv.addObject("pageInfo",pageInfo);

        mv.setViewName("order-list");

        return mv;
    }


    /**
     * 添加
     * @param order
     * @return
     */
    @RequestMapping("/save")
    public String save(Order order){

        orderService.save(order);

        return "redirect:/order/findByPageHelper";
    }


    /**
     * 获取所有的产品，获得产品的名字
     * @return
     */
    @RequestMapping("/insertUI")
    public ModelAndView insertUI(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();

        mv.addObject("productList",productList);

        mv.setViewName("order-add");
        return mv;
    }


    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();

        List<Order> orderList=orderService.findAll();

        mv.addObject("orderList",orderList);

        mv.setViewName("order-list");

        return mv;
    }
}
