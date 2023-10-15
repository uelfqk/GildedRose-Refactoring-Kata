package com.gildedrose.code.test;

import com.gildedrose.Item;
import com.gildedrose.code.DefaultItemQualityStrategy;
import com.gildedrose.code.QualityStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultItemQualityStrategyTest {

    @Test
    @DisplayName(value = "판매 가능 일수 남음 - 가치 변경 테스트")
    void 판매_가능_일수_남음_가치_변경_테스트() {
        Item item = new Item("foo", 1, 50);

        QualityStrategy strategy = new DefaultItemQualityStrategy();

        strategy.update(item);

        Assertions.assertEquals(0, item.sellIn);
        Assertions.assertEquals(49, item.quality);
    }

    @Test
    @DisplayName(value = "판매 가능 일수 없음 - 가치 변경 테스트")
    void 판매_가능_일수_없음_가치_변경_테스트() {
        Item item = new Item("foo", 0, 50);

        QualityStrategy strategy = new DefaultItemQualityStrategy();

        strategy.update(item);

        Assertions.assertEquals(-1, item.sellIn);
        Assertions.assertEquals(48, item.quality);
    }
//
//    @Test
//    @DisplayName(value = "가치 음수 안됨 - 가치 변경 테스트")
//    void 가치_음수_안됨_가치_변경_테스트() {
//        Item[] items = new Item[] { new Item("foo", 1, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//
//        Item item = items[0];
//
//        Assertions.assertEquals(0, item.sellIn);
//        Assertions.assertEquals(0, item.quality);
//    }
//
//    @Test
//    @DisplayName(value = "가치 음수 안됨 - 가치 변경 실패 테스트")
//    void 가치_음수_안됨_가치_변경_실패_테스트() {
//        Item[] items = new Item[] { new Item("foo", 1, -1) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//
//        Item item = items[0];
//
//        Assertions.assertEquals(0, item.sellIn);
//        Assertions.assertEquals(-1, item.quality);
//    }
}
