
package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItemQuality(item);
    }
  }

  private void updateItemQuality(Item item) {
    if (item.name.equals("Aged Brie")) {
      increaseQuality(item);
    } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      increaseQuality(item);
      if (item.sellIn < 11) {
        increaseQuality(item);
      }
      if (item.sellIn < 6) {
        increaseQuality(item);
      }
    } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      decreaseQuality(item,1);
    }

    decreaseSellIn(item);

    if (item.sellIn < 0) {
      if (item.name.equals("Aged Brie")) {
        increaseQuality(item);
      } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        item.quality = 0;
      } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        decreaseQuality(item,1);
      }
    }
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality++;
    }
  }

  private void decreaseSellIn(Item item) {
    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      item.sellIn--;
    }
  }


  private void decreaseQuality(Item item, Integer pas) {
    if (item.quality > 0) {
      item.quality = item.quality - pas; // Diminue la qualité, mais garde la qualité minimale à 0
    }
  }
}
