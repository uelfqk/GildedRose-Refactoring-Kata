package com.gildedrose.v2.provider;

public interface UpdateProvider {

    int ZERO = 0;

    int generateQuality(int sellIn);

    int getSellIn();

    default boolean isPossibleSell(int sellIn) {
        return sellIn > ZERO;
    }
}
