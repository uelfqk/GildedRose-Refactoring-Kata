package com.gildedrose.code;

import com.gildedrose.Item;

public class AgedBrieQualityStrategy implements QualityStrategy {

    private static final int DECREASE_DOUBLE_QUALITY = 2;

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
            item.quality += DECREASE_DOUBLE_QUALITY;
            return;
        }

        item.quality += INCREASE_DEFAULT_QUALITY;
    }
}
