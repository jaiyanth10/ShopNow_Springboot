package com.jai.ShopNow.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@Data
// this annotation is provided by lombok which shorthand for @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor. It gives the Product class all these capabilities without writing any of the methods manually.
@NoArgsConstructor
//A no-argument constructor is essential for JPA to instantiate entity classes.
//Lombok @NoArgsConstructor saves you from writing boilerplate code, automatically providing a no-args constructor to satisfy JPA’s requirements.
//Without Lombok, you must add the no-args constructor yourself to ensure JPA compatibility.
@AllArgsConstructor
// This will automatically create a constructor for this class like below which helps in initialization
// public Product(Long id, String name, double price) {
//    this.id = id;
//    this.name = name;
//    this.price = price;
//}
@Entity
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal totalPrice;

    @CreationTimestamp  // Automatically sets the creation timestamp no need  to include in frontend API call
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date orderDate;

    // Store product IDs as a list
    @ElementCollection // will create seperate table with both id's as columns named order_products
    //@Join column specifies the column in the order_products table that links back to the main Order entity.
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_id")//below integer list of product id's will be stored with column name product_id
    private List<Integer> productIds;
}
