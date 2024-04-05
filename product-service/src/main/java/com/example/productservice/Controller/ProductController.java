package com.example.productservice.Controller;

import com.example.productservice.Model.Product;
import com.example.productservice.Service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

    @Autowired
    private ProductInterface service;


    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) throws IOException {
        service.createProduct(product);
        return new ResponseEntity<>("Product Created...!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct() throws DataFormatException, IOException {
        List<Product> products = service.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/product-name/{pName}")
    public Product getByProductName(@PathVariable String pName){
        Product product = service.getByName(pName);
        return product;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        service.deleteProductById(id);
        return new ResponseEntity<>("Product Deleted...!",HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editProduct(@RequestBody Product product,@PathVariable Long id) throws Exception {
        service.editProductById(product,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/edit-qty")
    public void reduceQuantity(@PathVariable("id") Long id, @RequestParam("qty") int qty) {
        service.editQuantity(id, qty);
    }

}
