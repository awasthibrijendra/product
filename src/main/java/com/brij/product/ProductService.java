package com.brij.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.*;

@Service
public class ProductService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    ProductRepositiry repo;
    private static Set<Product> products = new HashSet<Product>();
    static
    {
        for(int i=1; i<= 10; i++){
            Product p = new Product();
            p.setSku("sku"+i);
            p.setPrice(i*10.1);
            products.add(p);
        }
    }

    public ArrayList<Product> findAll(){
            return (ArrayList<Product>) repo.findAll();
    }

    public void init(){
       Set<Product> products1 = new HashSet<Product>();
        for(int i=1; i<= 10; i++){
            Product p = new Product();
            p.setSku("sku"+i);
            p.setPrice(i*10.1);
            products1.add(p);
        }

         repo.saveAll(products1);
    }
    @Transactional
    public Optional<Product> findBySku(String sku){
        logger.info("ProductService.findBySku:"+sku);

        return products.stream().filter(p -> p.getSku().equalsIgnoreCase(sku)).findFirst();
    }

}
