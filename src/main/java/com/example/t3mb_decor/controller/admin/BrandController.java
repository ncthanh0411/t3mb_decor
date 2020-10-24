package com.example.t3mb_decor.controller.admin;

import com.example.t3mb_decor.model.Brand;
import com.example.t3mb_decor.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("brand")
@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @ModelAttribute("first")
    public String getActive1(){
        return ".catalog_click";
    }
    @ModelAttribute("second")
    public String getActive2(){
        return ".brand_click";
    }

    @ModelAttribute("listBrands")
    public List<Brand> getList(){
        List<Brand> listBrand =  brandService.getAllBrand();
        return listBrand;
    }

    @GetMapping
    public String viewAllBrand(Model model){
        model.addAttribute("brand", new Brand());
        return "content/admin/brand";
    }
    @GetMapping("delete/{id}")
    public String deleteBrand(@PathVariable("id") long id){
        brandService.deleteBrand(id);
        return "redirect:/brand";
    }

    @PostMapping("add")
    public String saveBrand(@ModelAttribute("brand") Brand brand){

        if(brand.getId() != 0) {
            brandService.updateBrand(brand);
            return "redirect:/brand/update/" + brand.getId() ;
        }
        brandService.saveBrand(brand);
        return "redirect:" ;
    }
    @GetMapping("update/{id}")
    public String viewUpdateBrand(@PathVariable("id") long id, Model model){
        Brand brandUpdate = brandService.getBrand(id);
        model.addAttribute("brand", brandUpdate);
        return "content/admin/brand";
    }
}
