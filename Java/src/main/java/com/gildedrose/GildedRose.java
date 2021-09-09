package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemService;

class GildedRose {


    Item[] items;

    private ItemService itemService;

    public GildedRose(Item[] items) {

        this.items = items;
        this.itemService = new ItemService();
    }

    public Item[] updateQuality() {
        for (int i = 0; i < items.length; i++) {
            // General cases
            if (!itemService.isAgedBrie(items[i])
                    && !itemService.isConcert(items[i])) {
                if (items[i].quality > 0) {
                    if (!itemService.isSulfuras(items[i])) {
                        items[i].quality = items[i].quality - 1;
                        if (itemService.isConjured(items[i])) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (itemService.isConcert(items[i])) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!itemService.isSulfuras(items[i])) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!itemService.isAgedBrie(items[i])) {
                    if (!itemService.isConcert(items[i])) {
                        if (items[i].quality > 0) {
                            if (!itemService.isSulfuras(items[i])) {
                                items[i].quality = items[i].quality - 1;
                                if (itemService.isConjured(items[i])) {
                                    items[i].quality = items[i].quality - 1;
                                }
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }


        }
        return items;
    }
}
