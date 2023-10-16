package com.gildedrose.code;

import com.gildedrose.Item;

public interface QualityStrategy {

    int ZERO = 0;

    int INCREASE_DEFAULT_QUALITY = 1;

    int MAX_QUALITY = 50;

    boolean isSupport(String name);

    void update(Item item);

    default boolean isGreateThenZeroQuality(int quality) {
        return quality > ZERO;
    }

    default boolean isMaximumQuality(int quality) {
        return quality > MAX_QUALITY;
    }

    default boolean isPossibleSell(int sellIn) {
        return sellIn > ZERO;
    }

    default void validate(Item item) {
        if(!isGreateThenZeroQuality(item.quality)) {
            item.quality = ZERO;
            return;
        }

        if(isMaximumQuality(item.quality)) {
            item.quality = MAX_QUALITY;
        }
    }

    default void minusSellIn(Item item) {
        item.sellIn -= INCREASE_DEFAULT_QUALITY;
    }
}
