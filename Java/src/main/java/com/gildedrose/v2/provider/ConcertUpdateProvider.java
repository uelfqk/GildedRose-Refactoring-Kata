package com.gildedrose.v2.provider;

public class ConcertUpdateProvider implements UpdateProvider {

    private static final int BEFORE_SELL_IN_ELEVEN_DAYS = 11;

    private static final int BEFORE_SELL_IN_SIX_DAYS = 6;

    private static final int PLUS_DOUBLE_QUALITY = 2;

    private static final int PLUS_TRIPLE_QUALITY = 3;

    private static final int INCREASE_DEFAULT_QUALITY = 1;

    private static final int INCREASE_SELL_IN = 1;

    @Override
    public int generateQuality(int sellIn) {
        if(!isPossibleSell(sellIn)) {
            return ZERO;
        }

        return getPlusQuality(sellIn);
    }

    private int getPlusQuality(int sellIn) {
        if(isBeforeSellInElevenDays(sellIn)) {
            return PLUS_DOUBLE_QUALITY;
        }

        if(isBeforeSellInSixDays(sellIn)) {
            return PLUS_TRIPLE_QUALITY;
        }

        return INCREASE_DEFAULT_QUALITY;
    }

    private boolean isBeforeSellInSixDays(int sellIn) {
        return sellIn < BEFORE_SELL_IN_SIX_DAYS;
    }

    private boolean isBeforeSellInElevenDays(int sellIn) {
        return sellIn < BEFORE_SELL_IN_ELEVEN_DAYS && sellIn > BEFORE_SELL_IN_SIX_DAYS;
    }

    @Override
    public int getSellIn() {
        return INCREASE_SELL_IN;
    }
}
