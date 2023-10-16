package com.gildedrose.v2;

import com.gildedrose.v2.Item;
import com.gildedrose.v2.provider.AgedBrieUpdateProvider;
import com.gildedrose.v2.provider.ConcertUpdateProvider;
import com.gildedrose.v2.provider.DefaultUpdateProvider;
import com.gildedrose.v2.provider.SulfurasUpdateProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0, new DefaultUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].getName());
    }

    @Test
    @DisplayName(value = "판매 가능 일수 남음 - 가치 변경 테스트")
    void 판매_가능_일수_남음_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("foo", 1, 50, new DefaultUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(0, item.getSellIn());
        Assertions.assertEquals(49, item.getQuality());
    }

    @Test
    @DisplayName(value = "판매 가능 일수 없음 - 가치 변경 테스트")
    void 판매_가능_일수_없음_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("foo", 0, 50, new DefaultUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(-1, item.getSellIn());
        Assertions.assertEquals(48, item.getQuality());
    }

    @Test
    @DisplayName(value = "가치 음수 안됨 - 가치 변경 테스트")
    void 가치_음수_안됨_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("foo", 1, 0, new DefaultUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(0, item.getSellIn());
        Assertions.assertEquals(0, item.getQuality());
    }

    // TODO 테스트 깨짐
    //      사유 : quality 가 0 이하가 될때 0 으로 값을 변경하는 코드 추가
    //      결과 : 테스트 코드 변경
    //            Assertions.assertEquals(-1, item.quality); -> Assertions.assertEquals(0, item.quality);
    @Test
    @DisplayName(value = "가치 음수 안됨 - 가치 변경 실패 테스트")
    void 가치_음수_안됨_가치_변경_실패_테스트() {
        Item[] items = new Item[] { new Item("foo", 1, -1, new DefaultUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(0, item.getSellIn());
//        Assertions.assertEquals(-1, item.quality);
        Assertions.assertEquals(0, item.getQuality());
    }

    @Test
    @DisplayName(value = "오래된 브리치즈 판매 가능 일수 남음 - 가치 변경 테스트")
    void 오래된_브리치즈_판매_가능_일수_남음_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 0, new AgedBrieUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(0, item.getSellIn());
        Assertions.assertEquals(1, item.getQuality());
    }

    @Test
    @DisplayName(value = "오래된 브리치즈 판매 가능 일수 없음 - 가치 변경 테스트")
    void 오래된_브리치즈_판매_가능_일수_없음_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0, new AgedBrieUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(-1, item.getSellIn());
        Assertions.assertEquals(2, item.getQuality());
    }

    @Test
    @DisplayName(value = "가치 50 초과 안됨 - 가치 변경 테스트")
    void 가치_50_초과_안됨_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50, new AgedBrieUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(0, item.getSellIn());
        Assertions.assertEquals(50, item.getQuality());
    }

    // TODO 테스트 깨짐
    //      사유 : quality 가 50 초과 될때 50 으로 값을 변경하는 코드 추가
    //      결과 : 테스트 코드 변경
    //            Assertions.assertEquals(51, item.quality); -> Assertions.assertEquals(50, item.quality);
    @Test
    @DisplayName(value = "가치 51 넣음 - 가치 변경 테스트")
    void 가치_51_넣음_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 51, new AgedBrieUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(0, item.getSellIn());
//        Assertions.assertEquals(51, item.quality);
        Assertions.assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName(value = "전설 아이템 - 가치 변경 테스트")
    void 전설_아이템_가치_변경_테스트() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 50, new SulfurasUpdateProvider()) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(1, item.getSellIn());
        Assertions.assertEquals(50, item.getQuality());
    }

    @Test
    @DisplayName(value = "콘서트 10일부터 - 가치 변경 테스트")
    void 콘서트_10일부터_가치_변경_테스트() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0, new ConcertUpdateProvider())
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(9, item.getSellIn());
        Assertions.assertEquals(2, item.getQuality());
    }

    @Test
    @DisplayName(value = "콘서트 5일부터 - 가치 변경 테스트")
    void 콘서트_5일부터_가치_변경_테스트() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 0, new ConcertUpdateProvider())
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(3, item.getSellIn());
        Assertions.assertEquals(3, item.getQuality());
    }

    @Test
    @DisplayName(value = "콘서트 0일 - 가치 변경 테스트")
    void 콘서트_0일_가치_변경_테스트() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0, new ConcertUpdateProvider())
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Item item = items[0];

        Assertions.assertEquals(-1, item.getSellIn());
        Assertions.assertEquals(0, item.getQuality());
    }
}
