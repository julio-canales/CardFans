package com.revature.cardfans.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cardfans.dao.ProductDao;
import com.revature.cardfans.models.Product;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    // annotation is optional
    @Autowired
    public ProductServiceImpl(ProductDao u) {
        productDao = u;

    }

    @Override
    public List<Product> retrieveProducts() {

        return productDao.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer productId) {

        return productDao.findById(productId);
    }

}
