package com.example.productservice.Service;

import com.example.productservice.Model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

public interface ProductInterface {

    public Product createProduct(Product product) throws IOException;

//    public String createProductImage(MultipartFile img, String pName, int pQty, double price) throws IOException;

    public List<Product> getAllProducts() throws DataFormatException, IOException;

    public Product getById(Long id);

    public Product getByName(String pName);

    public void deleteProductById(Long id);

    public Product editProductById(Product newProduct,Long id) throws Exception;

    public void editQuantity(Long id, int qty);
}
