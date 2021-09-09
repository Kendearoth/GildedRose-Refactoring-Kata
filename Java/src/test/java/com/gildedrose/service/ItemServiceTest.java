package com.gildedrose.service;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemServiceTest {

    private static ItemService itemService;

    @BeforeAll
    public static void init() {
        itemService = new ItemService();
    }

    @Test
    public void isConjuredTest() {
        // when
        Item item = new Item("object Conjured", 0, 20);

        // do
        boolean result = itemService.isConjured(item);

        // assert
        assertTrue(result);
    }

    @Test
    public void isAgedBrieTest() {
        // when
        Item item = new Item("object Aged Brie", 0, 20);

        // do
        boolean result = itemService.isAgedBrie(item);

        // assert
        assertTrue(result);
    }

    @Test
    public void isConcertTest() {
        // when
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        // do
        boolean result = itemService.isConcert(item);

        // assert
        assertTrue(result);
    }

    @Test
    public void isSulfurasTest() {
        // when
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 20);

        // do
        boolean result = itemService.isSulfuras(item);

        // assert
        assertTrue(result);
    }
}
