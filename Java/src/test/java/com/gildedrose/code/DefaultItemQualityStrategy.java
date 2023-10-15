package com.gildedrose.code;

import com.gildedrose.Item;

public class DefaultItemQualityStrategy implements QualityStrategy {

    private static final int MINUS_QUALITY_DOUBLE = 2;

    @Override
    public boolean isSupport(String name) {
        return !"Aged Brie".equals(name) &&
            !"Sulfuras, Hand of Ragnaros".equals(name) &&
            !"Backstage passes to a TAFKAL80ETC concert".equals(name);
    }

    @Override
    public void update(Item item) {
        if(!isGreateThenZeroQuality(item.quality)) {
            item.quality = ZERO;
            return;
        }

        minusSellIn(item);
        minusQuality(item);
    }

    @Override
    public void minusQuality(Item item) {
        if(!isPossibleSell(item.sellIn)) {
            item.quality -= DEFAULT_MINUS_VALUE;
            return;
        }

        item.quality -= MINUS_QUALITY_DOUBLE;

        QualityStrategy.super.minusQuality(item);
    }

    private void minusSellIn(Item item) {
        item.sellIn -= DEFAULT_MINUS_VALUE;
    }
}
