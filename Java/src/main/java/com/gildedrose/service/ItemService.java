package com.gildedrose.service;

import com.gildedrose.model.Item;

public class ItemService {

    public static final String CONJURED_LABEL = "Conjured";

    public boolean isConjured(Item i) {
       return i.name.contains(CONJURED_LABEL);
    }

}
