package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void afterSellInQualityDecreasedByTwo() {
        // when
        Item[] items = new Item[] { new Item("objectNullQuality", 0, 20)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        Item[] updatedItems = app.updateQuality();
        int actualQuality = updatedItems[0].quality;
        // assert
        assertEquals(actualQuality, lastQuality - 2);

    }

    @Test void conjuredObjectAfterSellInDecreasedTwoTimesMoreThanUsual() {
        Item[] items = new Item[] { new Item("Test Conjured Object", 0, 20)};
        GildedRose app = new GildedRose(items);

        //do
        int lastQuality = items[0].quality;
        Item[] updatedItems = app.updateQuality();
        int actualQuality = updatedItems[0].quality;

        // assert
        assertEquals(actualQuality, lastQuality - 4);
    }
}
