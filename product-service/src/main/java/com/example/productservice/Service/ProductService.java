package com.example.productservice.Service;

import com.example.productservice.Model.Product;
import com.example.productservice.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

@Service
public class ProductService implements ProductInterface{

    @Autowired
    private ProductRepository repository;


    @Override
    public Product createProduct(Product product) throws IOException {

        Product nproduct = new Product();
        nproduct.setProductName(product.getProductName());
        nproduct.setQty(product.getQty());
        nproduct.setPrice(product.getPrice());
        nproduct.setImageURL(product.getImageURL());
        return repository.save(nproduct);
    }


    @Override
    public List<Product> getAllProducts() throws DataFormatException, IOException {
        List<Product> products = repository.findAll();

//        return products.stream().map(this::mapToProduct)
//                .collect(Collectors.toList());
        return products;

    }

//    private Product mapToProduct(Product product){
//        Product p = new Product();
//        p.setProductName(product.getProductName());
//        p.setQty(product.getQty());
//        p.setPrice(product.getPrice());
//        try{
//            p.setImage(ImageUtils.decompressImage(product.getImage()));
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        } catch (DataFormatException e) {
//            throw new RuntimeException(e);
//        }
//        return p;
//    }

    @Override
    public Product getById(Long id) {
        return repository.findByProductId(id);
    }

    @Override
    public Product getByName(String pName) {
        Product dbImage = repository.findByProductName(pName);
        return dbImage;
    }


    @Override
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product editProductById(Product newProduct,Long id) throws Exception {
        Product existingProduct = repository.findByProductId(id);
        if(existingProduct != null){
            existingProduct.setProductName(newProduct.getProductName());
            existingProduct.setQty(newProduct.getQty());
            existingProduct.setPrice(newProduct.getPrice());
            existingProduct.setImageURL(newProduct.getImageURL());
            return repository.save(existingProduct);
        }
        else throw new Exception("Product Not Found for Id : " + id);
    }

    @Override
    public void editQuantity(Long id, int qty) {
        Product product = repository.findByProductId(id);
        int pQty = product.getQty();
        product.setQty(pQty - qty);
        repository.save(product);
    }
}
