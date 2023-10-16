package com.gildedrose.v2.provider;

public class DefaultUpdateProvider implements UpdateProvider {

    private static final int DECREASE_DEFAULT_QUALITY = -1;

    private static final int DECREASE_DOUBLE_QUALITY = -2;

    private static final int INCREASE_SELL_IN = 1;

    @Override
    public int generateQuality(int sellIn) {
        if(!isPossibleSell(sellIn)) {
            return DECREASE_DOUBLE_QUALITY;
        }

        return DECREASE_DEFAULT_QUALITY;
    }

    @Override
    public int getSellIn() {
        return INCREASE_SELL_IN;
    }
}
