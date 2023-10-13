package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }
  @Test
  @DisplayName("Test quality decrement for regular item")
  void testQualityDecrementForRegularItem() {
    // Créez un article régulier avec une qualité initiale de 10 et une date de vente de 5 jours.
    Item regularItem = new Item("Regular Item", 5, 10);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 1.
    assertEquals(9, regularItem.quality, "Quality should decrement by 1");
  }
  @Test
  @DisplayName("Test quality decrement for regular item branche 2 ")
  void testQualityDecrementForRegularItembranche2() {
    // Créez un article régulier avec une qualité initiale de 10 et une date de vente de 5 jours.
    Item regularItem = new Item("Sulfuras, Hand of Ragnaros", 5, 10);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 1.
    assertEquals(10, regularItem.quality, "Quality should be the same");

  }
  @Test
  @DisplayName("Test quality increment for Aged Brie")
  void testQualityIncrementForAgedBrie() {
    // Créez un article "Aged Brie" avec une qualité initiale de 40 et une date de vente de 5 jours.
    Item agedBrie = new Item("Aged Brie", 5, 40);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {agedBrie});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été incrémentée de 1.
    assertEquals(41, agedBrie.quality, "Quality should increment by 1");
  }
  @Test
  @DisplayName("Test quality increment for Backstage")
  void testQualityIncrementBackstage() {
    // Créez un article "Aged Brie" avec une qualité initiale de 40 et une date de vente de 5 jours.
    Item agedBrie = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {agedBrie});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été incrémentée de 1.
    assertEquals(42, agedBrie.quality, "Quality should increment by 2");
  }
  @Test
  @DisplayName("Test quality increment for Backstage 2 ")
  void testQualityIncrementBackstage2() {
    // Créez un article "Aged Brie" avec une qualité initiale de 40 et une date de vente de 5 jours.
    Item agedBrie = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {agedBrie});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été incrémentée de 1.
    assertEquals(43, agedBrie.quality, "Quality should increment by 3");
  }
  @Test
  @DisplayName("Test quality decrement for regular item")
  void testSellinDecrement() {
    // Créez un article régulier avec une qualité initiale de 10 et une date de vente de 5 jours.
    Item regularItem = new Item("Regular", 5, 10);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 1.
    assertEquals(4, regularItem.sellIn, "Sellin should decrement by 1");
  }
  @Test
  @DisplayName("Test quality decrement for regular item")
  void testQualityDec() {
    // Créez un article régulier avec une qualité initiale de 10 et une date de vente de 5 jours.
    Item regularItem = new Item("Regular", -4, 10);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 1.
    assertEquals(8, regularItem.quality, "Quality should decrement by 2");
  }
  @Test
  @DisplayName("Test quality decrement for regular item")
  void testQualityDecBackstage() {
    // Créez un article régulier avec une qualité initiale de 10 et une date de vente de 5 jours.
    Item regularItem = new Item("Backstage passes to a TAFKAL80ETC concert", -4, 10);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 1.
    assertEquals(0, regularItem.quality, "Quality should be 0");
  }
  @Test
  @DisplayName("Test quality increment for regular item")
  void testQualityIncAgie() {
    // Créez un article régulier avec une qualité initiale de 10 et une date de vente de 5 jours.
    Item regularItem = new Item("Aged Brie", -4, 10);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 1.
    assertEquals(12, regularItem.quality, "Quality should inc by 2");
  }

  @Test
  @DisplayName("Test Item toString method")
  void testItemToString() {
    Item item = new Item("Backstage passes", 3, 25);
    String expectedString = "Backstage passes, 3, 25";
    assertEquals(expectedString, item.toString(), "toString should return the expected string");
  }
  @Test
  @DisplayName("Test quality increment for Aged Brie when sellIn is zero")
  void testQualityIncrementForAgedBrieWhenSellInIsZero() {
    Item agedBrie = new Item("Aged Brie", 0, 40);
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();
    assertEquals(42, agedBrie.quality, "Quality should increment by 2");
  }
  @Test
  @DisplayName("Test quality becomes zero for Backstage when sellIn is zero")
  void testQualityZeroForBackstageWhenSellInIsZero() {
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(0, backstage.quality, "Quality should be zero");
  }
  @Test
  @DisplayName("Test quality increment for Aged Brie when sellIn is negative")
  void testQualityIncrementForAgedBrieWhenSellInIsNegative() {
    Item agedBrie = new Item("Aged Brie", -1, 40);
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();
    assertEquals(42, agedBrie.quality, "Quality should increment by 2");
  }
  @Test
  @DisplayName("")
  void testAgedBriequality50(){
    Item agedBrie = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();
    assertEquals(50, agedBrie.quality, "Quality should be the same");
  }
  @Test
  @DisplayName("")
  void testBackstageSellIn(){
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
    GildedRose app =new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(41, backstage.quality, "Quality should increment by 1");
  }
  @Test
  @DisplayName("")
  void testBackstageSellIn2(){
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app =new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(50, backstage.quality, "Quality should increment by 1");
  }
  @Test
  @DisplayName("")
  void testBackstageSellIn3(){
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48);
    GildedRose app =new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(50, backstage.quality, "Quality should increment by 1");
  }
  @Test
  @DisplayName("")
  void testBackstageSellIn4(){
    Item backstage = new Item("Sulfuras, Hand of Ragnaros", -1, 40);
    GildedRose app =new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(40, backstage.quality, "Quality should decrement by 1");
  }

  ///////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////Mutation////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////
  @Test
  @DisplayName("Test quality check for items with quality > 0")
  void testQualityGreaterThanZero() {
    // Créez un article avec une qualité initiale supérieure à zéro.
    Item itemWithZeroQuality = new Item("Regular Item", 5, 0);
    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {itemWithZeroQuality});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();
    // Vérifiez que la qualité de l'article reste supérieure à zéro.
    assertEquals(0, itemWithZeroQuality.quality, "Quality should be 0");
  }
  @Test
  @DisplayName("Test quality check for items with quality > 0")
  void testQualitySellInEqual6() {
    // Créez un article avec une qualité initiale supérieure à zéro.
    Item Back = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 40);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] {Back});

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();
    // Vérifiez que la qualité de l'article reste supérieure à zéro.
    assertEquals(42, Back.quality, "Quality should increment by 2 ");
  }
  @Test
  @DisplayName("Test quality decrement when sellIn is zero")
  void testQualityDecrementWhenSellInIsZero() {
    // Créez un article avec une date de vente de 0.
    Item item = new Item("Regular Item", 0, 0);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] { item });

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 1 lorsque sellIn est à zéro.
    assertEquals(0, item.quality, "Quality should decrement by 1");
  }
  @Test
  @DisplayName("Mutation test for quality decrement when sellIn is zero")
  void mutationTestQualityDecrementWhenSellInIsZero() {
    // Créez un article avec une date de vente de 0.
    Item item = new Item("Regular Item", 1, 40);

    // Créez une instance de GildedRose avec l'article.
    GildedRose app = new GildedRose(new Item[] { item });

    // Appelez updateQuality pour mettre à jour la qualité de l'article.
    app.updateQuality();

    // Vérifiez que la qualité de l'article a été décrémentée de 2 (correction du test).
    assertEquals(39, item.quality, "Quality should decrement by 2");
  }
}
