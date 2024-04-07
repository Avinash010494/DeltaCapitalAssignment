package com.deltacapita.assigment.service;

import com.deltacapita.assigment.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BasketService {

    static List<Item> itemList;

    static {
        Item apple = new Item("Apple",35,"No Offer");
        Item banana = new Item("Banana",20,"No Offer");
        Item melon = new Item("Melon",50,"buy one get one free");
        Item lime = new Item("Lime",15,"three for the price of two");
        itemList = List.of(apple,banana,melon,lime);
    }

    public int getBasketValue(List<String> basket){
        Map<String,Integer> countItems= new HashMap<>();
        for(String items:basket){
            countItems.put(items,countItems.getOrDefault(items,0)+1);
        }
        int basketValue = 0;

        for(Map.Entry<String,Integer> items:countItems.entrySet()){
            basketValue += getDiscountPrice(items.getKey(), items.getValue());
        }

        return basketValue;
    }

    public int getDiscountPrice(String item,int itemCount){
        int price = 0;
        Optional<Item> basket = itemList.stream().filter(item1 -> item1.getItemName().equals(item)).findAny();
        if(basket.isPresent()) {
            Item basketItem = basket.get();
            switch (basketItem.getOffer()) {
                case "No Offer":
                    price = basketItem.getPrice() * itemCount;
                    break;
                case "buy one get one free":
                    int melonOffer = itemCount / 2;
                    int melonRem = itemCount % 2;
                    price = melonOffer * basketItem.getPrice() + melonRem * basketItem.getPrice();
                    break;
                case "three for the price of two":
                    int limeOffer = itemCount / 3;
                    int limeRem = itemCount % 3;
                    price = limeOffer * basketItem.getPrice() * 2 + limeRem * basketItem.getPrice();
                    break;
                default:
                    price = basketItem.getPrice() * itemCount;
                    break;
            }
        }else{
            throw new IllegalArgumentException();
        }
        return price;
    }

}
