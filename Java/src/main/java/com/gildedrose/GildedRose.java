package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemService;

class GildedRose {


    Item[] items;

    private final ItemService itemService;

    public GildedRose(Item[] items) {

        this.items = items;
        this.itemService = new ItemService();
    }

    public Item[] updateQuality() {
        for (Item item : items) {
            // General cases
            if (!itemService.isAgedBrie(item) && !itemService.isConcert(item)) {
                // it's either common item or Sulfuras
                updateItemQualityWhenNotAgedBrieAndConcert(item);
            // case specific
            } else {
                if (item.quality < 50) {
                    item.quality += 1;
                    // if item is a concert
                    if (itemService.isConcert(item)) {
                        updateQualityWhenItemIsConcert(item);
                    }
                }
            }
            // if it's not sulfuras then decrementation of sellIn
            if (!itemService.isSulfuras(item)) {
                item.sellIn -= 1;
            }

            // if sellIn negative
            if (item.sellIn < 0) {
                updateNegativeItemQuality(item);
            }
        }
        return items;
    }

    public void updateNegativeItemQuality(Item item) {
        if (!itemService.isAgedBrie(item)) {
            if (!itemService.isConcert(item)) {
                updateItemQualityWhenNotAgedBrieAndConcert(item);
            } else {
                item.quality = 0;
            }
        } else {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }
    }

    public void updateItemQualityWhenNotAgedBrieAndConcert(Item item) {
        if (item.quality > 0) {
            if (!itemService.isSulfuras(item)) {
                item.quality -= 1;
                if (itemService.isConjured(item)) {
                    item.quality -= 1;
                }
            }
        }
    }

    public void updateQualityWhenItemIsConcert(Item item) {
        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }
    }
}


