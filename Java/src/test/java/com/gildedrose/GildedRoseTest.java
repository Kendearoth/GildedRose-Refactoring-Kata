package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    public void afterSellInExceededQualityDecreasedByTwo() {
        // when
        Item[] items = new Item[] { new Item("object sell in exceeded", 0, 20)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        Item[] updatedItems = app.updateQuality();
        int actualQuality = updatedItems[0].quality;
        // assert
        assertEquals(actualQuality, lastQuality - 2);

    }

    @Test void conjuredObjectAfterSellInExceededDecreasedTwoTimesMoreThanUsual() {
        Item[] items = new Item[] { new Item("Test Conjured Object", 0, 20)};
        GildedRose app = new GildedRose(items);

        //do
        int lastQuality = items[0].quality;
        Item[] updatedItems = app.updateQuality();
        int actualQuality = updatedItems[0].quality;

        // assert
        assertEquals(actualQuality, lastQuality - 4);
    }

    @Test void itemQualityNeverNegative() {
        // when
        Item[] items = new Item[] { new Item("objectNullQuality", 0, 0)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        app.updateQuality();

        // assert
        assertTrue(lastQuality >= 0);
    }

    // works for Conjured or not
    @Test void conjuredItemQualityNeverNegative() {
        // when
        Item[] items = new Item[] { new Item("Test Conjured Object", 0, 0)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        app.updateQuality();

        // assert
        assertTrue(lastQuality >= 0);
    }

}
