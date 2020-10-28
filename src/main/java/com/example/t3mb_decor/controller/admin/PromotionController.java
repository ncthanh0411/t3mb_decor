package com.example.t3mb_decor.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/promotion")
public class PromotionController {

    @ModelAttribute("first")
    public String getActive1(){
        return ".catalog_click";
    }
    @ModelAttribute("second")
    public String getActive2(){
        return ".promotion_click";
    }
    @GetMapping
    public String viewtest(){
        return "content/admin/promotion";
    }
}