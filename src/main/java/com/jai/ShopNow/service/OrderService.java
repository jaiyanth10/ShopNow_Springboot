package com.jai.ShopNow.service;

import com.jai.ShopNow.model.Orderr;
import com.jai.ShopNow.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    public OrderRepo Orepo;
    public Orderr addOrder(Orderr order){
        return Orepo.save(order);
    }
}
