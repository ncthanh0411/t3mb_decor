package com.example.t3mb_decor.repository;

import com.example.t3mb_decor.model.Category;
import com.example.t3mb_decor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByOrderByIdDesc();

    @Query(value = "SELECT * FROM products WHERE subcate_id= :id",nativeQuery = true)
    List<Product> findBySubId(@Param("id") long id);


}
