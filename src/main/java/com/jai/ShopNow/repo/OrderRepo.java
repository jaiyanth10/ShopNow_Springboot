package com.jai.ShopNow.repo;

import com.jai.ShopNow.model.Orderr;
import com.jai.ShopNow.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface OrderRepo extends JpaRepository<Orderr, Integer> {

}