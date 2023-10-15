package com.gildedrose.code;

import com.gildedrose.Item;

public class AgedBrieQualityStrategy implements QualityStrategy {


    @Override
    public boolean isSupport(String name) {
        return "Aged Brie".equals(name);
    }

    @Override
    public void update(Item item) {

    }
}
