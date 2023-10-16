package com.gildedrose.code;

import com.gildedrose.Item;

public class SulfurasQualityStrategy implements QualityStrategy {

    @Override
    public boolean isSupport(String name) {
        return "Sulfuras, Hand of Ragnaros".equals(name);
    }

    @Override
    public void update(Item item) {
    }
}
