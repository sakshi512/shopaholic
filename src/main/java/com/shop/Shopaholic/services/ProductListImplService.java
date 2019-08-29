package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductListImplService implements ProductsService {

    //Save the uploaded file to this folder
   // private static String UPLOADED_FOLDER = "/Users/anamsami/Desktop/Project/Shopaholic/src/main/resources/static/images/";

    private static String UPLOADED_FOLDER = System.getProperty("user.home")+ "/ShopaholicProductImages/";


    @Autowired
    ResourceLoader resourceLoader;

    ProductRepository productRepository;

    @Autowired
    public ProductListImplService(ProductRepository productRepository) {
         this.productRepository = productRepository;
    }

    @Override
    public List<ProductsEntity> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(ProductsEntity productsEntity)
    {
        LocalDate now = LocalDate.now();
        productsEntity.setProductCreationDate(now);
        productRepository.save(productsEntity);

    }

    @Override
    public void saveImageFile(ProductsEntity productsEntity , MultipartFile file) throws Exception
    {

        String fileName = productsEntity.getProductId()+".jpg";

        byte[] bytes = file.getBytes();


        Path dir = Paths.get(UPLOADED_FOLDER);

        if (!Files.exists(dir))
        {
            Files.createDirectories(dir);

        }

        Path path = Paths.get(dir + "/" + fileName);

        Files.write(path, bytes);



        productsEntity.setProductImage(fileName);



        productRepository.updateImage(fileName,productsEntity.getProductId());

    }

    public Optional<ProductsEntity> findProductbyId(int productId)
    {
        return productRepository.findById(productId);
    }
}
