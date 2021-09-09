package com.gildedrose.service;

import com.gildedrose.model.Item;

public class ItemService {

    private static final String CONJURED_LABEL = "Conjured";
    private static final String AGED_BRIE_LABEL = "Aged Brie";
    private static final String CONCERT_LABEL = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_LABEL = "Sulfuras, Hand of Ragnaros";

    public boolean isConjured(Item i) {
       return i.name.contains(CONJURED_LABEL);
    }

    public boolean isAgedBrie(Item i) {
        return i.name.contains(AGED_BRIE_LABEL);
    }

    public boolean isConcert(Item i) {
        return i.name.contains(CONCERT_LABEL);
    }

    public boolean isSulfuras(Item i) {
        return i.name.contains(SULFURAS_LABEL);
    }

}
