package com.gildedrose.v1.strategy;

import com.gildedrose.v1.Item;

public class AgedBrieQualityStrategy implements QualityStrategy {

    private static final int INCREASE_DOUBLE_QUALITY = 2;

    @Override
    public boolean isSupport(String name) {
        return "Aged Brie".equals(name);
    }

    @Override
    public void update(Item item) {
        plusQuality(item);
        minusSellIn(item);
        validate(item);
    }

    private void plusQuality(Item item) {
        if(!isPossibleSell(item.sellIn)) {
            item.quality += INCREASE_DOUBLE_QUALITY;
            return;
        }

        item.quality += INCREASE_DEFAULT_QUALITY;
    }
}
