package com.gildedrose.code;

import com.gildedrose.Item;

public interface QualityStrategy {

    int ZERO = 0;

    int DEFAULT_MINUS_VALUE = 1;

    int MAX_QUALITY = 50;

    boolean isSupport(String name);

    void update(Item item);

    default boolean isGreateThenZeroQuality(int quality) {
        return quality > ZERO;
    }

    default boolean isPossibleSell(int sellIn) {
        return sellIn > ZERO;
    }

    default void minusQuality(Item item) {
        if(item.quality == MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }
}
