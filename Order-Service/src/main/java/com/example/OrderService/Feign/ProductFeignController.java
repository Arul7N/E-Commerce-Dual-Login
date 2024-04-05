package com.example.OrderService.Feign;

import com.example.OrderService.Dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url = "http://localhost:8080/product")
public interface ProductFeignController {



    @GetMapping("/product-name/{pName}")
    ProductDto getByProductName(@PathVariable String pName);

    @PutMapping("/{id}/edit-qty")
    void reduceQuantity(@PathVariable("id") Long id, @RequestParam("qty") int qty);
}
