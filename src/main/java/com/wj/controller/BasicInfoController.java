package com.wj.controller;

import com.wj.pojo.BasicInfo.Depart;
import com.wj.pojo.BasicInfo.Sit;
import com.wj.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/basic/")
public class BasicInfoController {
    @Autowired
    private BasicInfoService basicInfoServiceImpl;

    /**
     * 所有院系名称查询
     * @param model
     * @return
     */
    @RequestMapping(value = "alldepart.do")
    public String allDepart(Model model){
        List<Depart> departs = basicInfoServiceImpl.selAllDepart();
        model.addAttribute("depart",departs);
        return "page/admin/base_depart";
    }

    /**
     * 添加院系信息
     * @param depart
     * @return
     */
    @RequestMapping(value = "adddepart.do")
    public String addDepart(Depart depart){
        try {
            basicInfoServiceImpl.insDepart(depart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:alldepart.do";
    }

    /**
     * 管理员添加院系时，下拉框显示
     * @return
     */
    @RequestMapping(value = "depart.do")
    @ResponseBody
    public List<Depart> depart(){
        List<Depart> departs = basicInfoServiceImpl.selAllDepart();
        return  departs;
    }

    /**
     * 管理员添加职称时，下拉框显示
     * @return
     */
    @RequestMapping(value = "sit.do")
    @ResponseBody
    public List<Sit> sit(){
        List<Sit> sits = basicInfoServiceImpl.selAllSit();
        return sits;
    }

    /**
     * 查询所有职称信息
     * @param model
     * @return
     */
    @RequestMapping(value = "allsit.do")
    public String allsit(Model model){
        List<Sit> sits = basicInfoServiceImpl.selAllSit();
        model.addAttribute("sit",sits);
        return "page/admin/base_sit";
    }

    /**
     * 添加职称
     * @param sit
     * @return
     */
    @RequestMapping(value = "addsit.do")
    public String addSit(Sit sit){
        basicInfoServiceImpl.insSit(sit);
        return  "redirect:allsit.do";
    }

}
