package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    // sellIn = 0

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

    @Test
    public void conjuredObjectAfterSellInExceededDecreasedTwoTimesMoreThanUsual() {
        Item[] items = new Item[] { new Item("Test Conjured Object", 0, 20)};
        GildedRose app = new GildedRose(items);

        //do
        int lastQuality = items[0].quality;
        Item[] updatedItems = app.updateQuality();
        int actualQuality = updatedItems[0].quality;

        // assert
        assertEquals(actualQuality, lastQuality - 4);
    }

    // quality = 0

    @Test
    public void itemQualityNeverNegative() {
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
    @Test
    public void conjuredItemQualityNeverNegative() {
        // when
        Item[] items = new Item[] { new Item("Test Conjured Object", 0, 0)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        app.updateQuality();

        // assert
        assertTrue(lastQuality >= 0);
    }

    // quality = 50
    @Test
    public void itemsNeverAboveQualityFiftyCaseUsual() {
        // when
        Item[] items = new Item[] { new Item("objectMaxQuality", 0, 50)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        app.updateQuality();

        // assert
        assertTrue(lastQuality <= 50);
    }
    @Test
    public void itemsNeverAboveQualityFiftyCaseUsualWithConjured() {
        // when
        Item[] items = new Item[] { new Item("objectMaxQuality Conjured", 0, 50)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        app.updateQuality();

        // assert
        assertTrue(lastQuality <= 50);
    }

    @Test
    public void itemsNeverAboveQualityFiftyCaseAgedBrie() {
        // when
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        app.updateQuality();

        // assert
        assertTrue(lastQuality <= 50);
    }
    @Test
    public void itemsNeverAboveQualityFiftyCaseConcert() {
        // when
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50)};
        GildedRose app = new GildedRose(items);

        // do
        int lastQuality = items[0].quality;
        app.updateQuality();

        // assert
        assertTrue(lastQuality <= 50);
    }


}
