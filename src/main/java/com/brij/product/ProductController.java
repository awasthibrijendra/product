package com.brij.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Set;

@RestController
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService service;

    @GetMapping("/")
    public String home(){
        return "product home";
    }

    @GetMapping("/products")
    public ArrayList<Product> getAll(){
        return service.findAll();
    }

    @GetMapping("/init")
    public void init(){
        service.init();
    }

    @GetMapping("/products/{sku}")
    public ResponseEntity<Product> findBySku(@PathVariable String sku){
        logger.info("ProductController.findBySku:"+sku);
        new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        return service.findBySku(sku).map(s -> ResponseEntity.ok(s)).orElse(new ResponseEntity<Product>(HttpStatus.NO_CONTENT));
    }
}
