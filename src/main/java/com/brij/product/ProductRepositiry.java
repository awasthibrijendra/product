package com.brij.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface ProductRepositiry extends CrudRepository<Product, String> {

}
