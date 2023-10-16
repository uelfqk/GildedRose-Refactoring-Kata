package com.gildedrose.v1.strategy;

import com.gildedrose.v1.Item;

public class ConcertQualityStrategy implements QualityStrategy {

    private static final int BEFORE_SELL_IN_ELEVEN_DAYS = 11;

    private static final int BEFORE_SELL_IN_SIX_DAYS = 6;

    private static final int PLUS_DOUBLE_QUALITY = 2;

    private static final int PLUS_TRIPLE_QUALITY = 3;

    @Override
    public boolean isSupport(String name) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(name);
    }

    @Override
    public void update(Item item) {
        plusQuality(item);
        minusSellIn(item);
        validate(item);
    }

    private void plusQuality(Item item) {
        if(!isPossibleSell(item.sellIn)) {
            item.quality = 0;
            return;
        }

        item.quality += getPlusQuality(item.sellIn);
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
}
