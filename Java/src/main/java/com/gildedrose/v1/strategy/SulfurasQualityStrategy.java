package com.gildedrose.v1.strategy;

import com.gildedrose.v1.Item;

public class SulfurasQualityStrategy implements QualityStrategy {

    @Override
    public boolean isSupport(String name) {
        return "Sulfuras, Hand of Ragnaros".equals(name);
    }

    @Override
    public void update(Item item) {
    }
}
