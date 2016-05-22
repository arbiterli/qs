package com.glority.qualityserver.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glority.qualityserver.model.ProductStatus;
import com.glority.qualityserver.web.service.ProductService;

/**
 * ProductController holds all request about product page.
 * 
 * @author liheping
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BasicController {

    @Autowired
    private ProductService productService;

    /**
     * this method to get the product list page.
     * 
     * @param request
     * @param response
     * @return productlist.jsp
     */
    @RequestMapping("/productlist")
    public String getProductListPage(HttpServletRequest request, HttpServletResponse response) {
        super.setPageTitleAndNavigationLinks(request, PAGE_PRODUCT_LIST);

        List<ProductStatus> products = this.productService.getProductsStatus();

        request.setAttribute("products", products);

        return "products";
    }

    /**
     * this method to return history detail page.
     * 
     * @param request
     * @param response
     * @return product.jsp
     */
    @RequestMapping("/productinfo")
    public String getProductPage(@RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            HttpServletRequest request, HttpServletResponse response) {
        if (productId < 0) {
            return "error";
        }

        if (!setRequestProductInfo(request)) {
            return "error";
        }

        super.setPageTitleAndNavigationLinks(request, PAGE_PRODUCT);

        return "product";
    }

}
