package com.jai.ShopNow.service;

import com.jai.ShopNow.model.Product;
import com.jai.ShopNow.repo.ProductRepo;
import com.jai.ShopNow.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;


import com.jai.ShopNow.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//service layer is used to get data from repo layer
public class ProductService {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public Product convertToEntity(ProductDto productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);

    }


    public Product addProduct(Product product, MultipartFile imageFile){
      product.setImageName(imageFile.getOriginalFilename());
      product.setImageType(imageFile.getContentType());
      //while updating the imagedata there is chance IO exception, so we are using try catch to avoid the compilation error
        try {
            product.setImageData(imageFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //We updated the product object with ImageName,ImageType,ImageData in above lines and then saving it in database
        // repo.save() method will update the data if the product already exist in DB it will update the product otherwise it will create new one.
        return repo.save(product);
    }


    //Here as we know repo.save() will update product if it already exists.we can use it directly no need to check its existence in DB.
    //Because if it is not in DB, we won't see that particular product in frontend webpage in first place.
    //So we are not using id here, but if u want to explicitly check we can compare the id we got from front end with all the id's in DB using a for loop.
    public Product updateProduct(int id, Product product, MultipartFile imageFile){
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        //while updating the imageData there is chance IO exception, so we are using try catch to avoid the compilation error
        try {
            product.setImageData(imageFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //We updated the product object with ImageName,ImageType,ImageData in above lines and then saving it in database
        // repo.save() method will update the data if the product already exist in DB it will update the product otherwise it will create new one.
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
    }

}




