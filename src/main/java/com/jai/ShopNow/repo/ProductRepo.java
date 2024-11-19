package com.jai.ShopNow.repo;

import com.jai.ShopNow.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Remember everytime for repo layer use interface instead of class, Because Spring can dynamically generate implementations at runtime based on the methods defined in these interfaces.
//JpaRepository is a JPA-specific extension of Spring Data's CrudRepository, providing more features like CRUD methods like findAll(),save(), deleteById() findById() and pagination and batch operations.
//using JPA with help of class like jpaRepository which is part of spring JPA library(inbuilt library) will help in accessing database without SQL code.
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> { //Product: It represents the data model,  Integer:This specifies that the primary key of Product is of type Integer.

    //JpaRepository wont consist some methods useful for our application.
    //Like here we want to filter database based on the keyword.
    //So, we have to create a custom method to fulfill the purpose.

    // so to handle the database with custom function we made, we need to use a language similar to SQL.
    // But in JPA, SQL is not supported, so for that we will use JPQL.
    //JPQL (Java Persistence Query Language) is a platform-independent object-oriented query language used to query entities stored in a relational database.
    //For this we use Query annotation, to execute JPQL.

    // Lower and concat are inbuilt methods and here, we are filtering every column.
    // p acts as placeholder here, to hold the data fetched in middle of function.
    // Here instead of class name we need to use data model class name which is Product in this case.
    //Here we are using LOWER keyword because, in DB everthing is in lower case, so to avoid errors because of capital and small letters, we do this
    @Query("SELECT p from Product p WHERE "+
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.descc) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    //Here we are not returning anything because, we are giving this function above functionality and not returning any value
    List<Product> searchProducts(String keyword);


}
