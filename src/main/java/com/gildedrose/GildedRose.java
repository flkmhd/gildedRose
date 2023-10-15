package com.gildedrose;

class GildedRose {
  Item[] items; // Tableau d'objets Item

  public GildedRose(Item[] items) {
    this.items = items; // Initialise le tableau d'objets Item dans le constructeur
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItemQuality(item); // Appelle la méthode updateItemQuality pour chaque élément dans le tableau
    }
  }

  private void updateItemQuality(Item item) {
    if (item.name.equals("Aged Brie")) {
      increaseQuality(item); // Augmente la qualité de l'objet Aged Brie
    } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      increaseQuality(item); // Augmente la qualité de l'objet Backstage Passes
      if (item.sellIn < 11) {
        increaseQuality(item); // Augmente à nouveau la qualité si la date de vente est inférieure à 11
      }
      if (item.sellIn < 6) {
        increaseQuality(item); // Augmente à nouveau la qualité si la date de vente est inférieure à 6
      }
    } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      decreaseQuality(item); // Diminue la qualité pour tous les autres objets, sauf Sulfuras
    }

    decreaseSellIn(item); // Diminue la date de vente pour tous les objets, sauf Sulfuras

    if (item.sellIn < 0) {
      if (item.name.equals("Aged Brie")) {
        increaseQuality(item); // Si la date de vente est passée pour Aged Brie, augmente la qualité
      } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        item.quality = 0; // Si la date de vente est passée pour Backstage Passes, la qualité tombe à 0
      } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        decreaseQuality(item); // Diminue la qualité pour tous les autres objets si la date de vente est passée
      }
    }
  }

  private void decreaseSellIn(Item item) {
    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      item.sellIn--; // Diminue la date de vente pour tous les objets, sauf Sulfuras
    }
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality--; // Diminue la qualité, mais garde la qualité minimale à 0
    }
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality++; // Augmente la qualité, mais garde la qualité maximale à 50
    }
  }
}
