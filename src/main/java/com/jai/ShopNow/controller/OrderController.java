package com.jai.ShopNow.controller;

import com.jai.ShopNow.model.Orderr;
import com.jai.ShopNow.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    public OrderService oservice;

    @PostMapping("/AddOrder")
    public ResponseEntity<?> AddOder(@RequestBody Orderr order){
       try{
           System.out.print(order);
           Orderr order1 =  oservice.addOrder(order);
           return new ResponseEntity<>(order1, HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

}
