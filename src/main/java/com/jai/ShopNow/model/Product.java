package com.jai.ShopNow.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data // this annotation is provided by lombok which shorthand for @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor. It gives the Product class all these capabilities without writing any of the methods manually.
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
@Entity//Tells JPA that this class should be converted to table
public class Product {

   @Id //denotes primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY) // this will auto generate the primary keys in data base
   private int id;
   private String name;
   private String descc;
   private String brand;
   private BigDecimal price;
   private String category;

   //This annotation is provided by jackson library which is responsible for converting object to JSON and vice-versa b/w frontend and backend
   //This annotation will format the date into mentioned pattern and data type
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy") //MM should be capital otherwise mm will be considered as minutes
   private Date releaseDate; //the names like releaseDate will be stored as release_Date, because of naming convention

   private boolean available;
   private int quantity;
   //Image data
   private String imageName;
   private String imageType;

   //byte array to store image in bytes
   @Lob
   //Large Object, this annotation denotes that image data will store large amount of data
   //It can be applied to both byte[] and String types.
   //we are using a byte array as data type for imageData variable.
   //array creation in java : String fruits [] = new String[4]; 4 denotes size of array
   private byte[] imageData;

}
