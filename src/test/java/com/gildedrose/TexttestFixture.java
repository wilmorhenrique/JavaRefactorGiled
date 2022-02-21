package com.gildedrose;

// https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexttestFixture {
    @Test
    void testGildedRose() {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(result);
        out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        for (int i = 0; i < days; i++) {
            out.println("-------- day " + i + " --------");
            out.println("name, sellIn, quality");
            for (Item item : items) {
                out.println(item);
            }
            out.println();
            app.updateQuality();
        }
        assertEquals(result.toString(), getResult());
    }


    String getResult() {
        return "OMGHAI!\r\n" +
            "-------- day 0 --------\r\n" +
            "name, sellIn, quality\r\n" +
            "+5 Dexterity Vest, 10, 20\r\n" +
            "Aged Brie, 2, 0\r\n" +
            "Elixir of the Mongoose, 5, 7\r\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\r\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\r\n" +
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\r\n" +
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\r\n" +
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\r\n" +
            "Conjured Mana Cake, 3, 6\r\n" +
            "\r\n" +
            "-------- day 1 --------\r\n" +
            "name, sellIn, quality\r\n" +
            "+5 Dexterity Vest, 9, 19\r\n" +
            "Aged Brie, 1, 1\r\n" +
            "Elixir of the Mongoose, 4, 6\r\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\r\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\r\n" +
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\r\n" +
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\r\n" +
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\r\n" +
            "Conjured Mana Cake, 2, 5\r\n\r\n";
    }


}
