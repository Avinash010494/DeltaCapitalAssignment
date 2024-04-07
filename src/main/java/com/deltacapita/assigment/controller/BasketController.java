package com.deltacapita.assigment.controller;

import com.deltacapita.assigment.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BasketController {


    public static void main(String[] args) {
        BasketService basketService = new BasketService();
        List<String> item = List.of("Apple","Apple","Banana","Banana","Melon","Melon","Melon","Lime","Lime","Lime","Lime");
        System.out.println(basketService.getBasketValue(item));
    }

}
