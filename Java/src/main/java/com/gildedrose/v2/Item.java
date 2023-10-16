package com.gildedrose.v2;

import com.gildedrose.v2.provider.UpdateProvider;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    private UpdateProvider provider;

    public Item(String name, int sellIn, int quality, UpdateProvider provider) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.provider = provider;
    }

    public void updateQuality() {
        this.quality += provider.generateQuality(sellIn);
        overDay();
        validate();
    }

    private void overDay() {
        this.sellIn -= provider.getSellIn();
    }

    private void validate() {
        if(!isQualityGrateThenMinimum()) {
            this.quality = 0;
        }

        if(isQualityGrateThenMaximum()) {
            this.quality = 50;
        }
    }

    private boolean isQualityGrateThenMinimum() {
        return quality > 0;
    }

    private boolean isQualityGrateThenMaximum() {
        return quality > 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Item{" +
            "name='" + name + '\'' +
            ", sellIn=" + sellIn +
            ", quality=" + quality +
            '}';
    }
}
