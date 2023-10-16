package com.gildedrose.v1.strategy;

import com.gildedrose.v1.Item;

public class DefaultItemQualityStrategy implements QualityStrategy {

    private static final int DECREASE_DOUBLE_QUALITY = 2;

    @Override
    public boolean isSupport(String name) {
        return !"Aged Brie".equals(name) &&
            !"Sulfuras, Hand of Ragnaros".equals(name) &&
            !"Backstage passes to a TAFKAL80ETC concert".equals(name);
    }

    @Override
    public void update(Item item) {
        minusQuality(item);
        minusSellIn(item);
        validate(item);
    }

    private void minusQuality(Item item) {
        if(!isPossibleSell(item.sellIn)) {
            item.quality -= DECREASE_DOUBLE_QUALITY;
            return;
        }

        item.quality -= INCREASE_DEFAULT_QUALITY;
    }
}
