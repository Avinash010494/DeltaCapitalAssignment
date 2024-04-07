package com.deltacapita.assigment.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.opentest4j.AssertionFailedError;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {

    BasketService basketService;


    @Before
    public void setUp(){
        basketService = new BasketService();
    }

    @Test
    public void getBasketValueTest(){
        List<String> item = List.of("Apple","Apple","Banana","Banana","Melon","Melon","Melon","Lime","Lime","Lime","Lime");
        int basketValue = basketService.getBasketValue(item);
        assertTrue(basketValue == 255);
    }

    @Test
    public void getBasketValueEmptyListTest(){
        List<String> item = Collections.emptyList();
        int basketValue = basketService.getBasketValue(item);
        assertTrue(basketValue == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBasketValueIncorrectInputTest(){
        List<String> item = List.of("Pineapple");
        int basketValue = basketService.getBasketValue(item);
        assertTrue(basketValue == 0);
    }

    @Test(expected = AssertionFailedError.class)
    public void getBasketValueNegativeTest(){
        List<String> item = List.of("Apple","Apple","Banana","Banana","Melon","Melon","Melon","Lime","Lime","Lime","Lime");
        int basketValue = basketService.getBasketValue(item);
        assertTrue(basketValue == 260);
    }

}
