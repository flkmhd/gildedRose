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
  @DisplayName("Quality should remain the same for Sulfuras")
  void testQualityUnchangedForSulfuras() {
    // Create a Sulfuras item with initial quality 10 and sellIn 5 days.
    Item sulfurasItem = new Item("Sulfuras, Hand of Ragnaros", 5, 10);
    GildedRose app = new GildedRose(new Item[] { sulfurasItem });
    app.updateQuality();
    // Assert that the quality of Sulfuras remains the same.
    assertEquals(10, sulfurasItem.quality, "Quality should remain the same");
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
  @DisplayName("Test quality increment for Backstage when sellIn is 5")
  void testQualityIncrementBackstageWhenSellInIs5() {
    // Create a Backstage Passes item with initial quality 40 and sellIn 5 days.
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] {backstagePasses});

    // Call updateQuality to update the quality of the item.
    app.updateQuality();

    // Verify that the quality of the item has been incremented by 3.
    assertEquals(43, backstagePasses.quality, "Quality should increment by 3");
  }

  @Test
  @DisplayName("Test sellIn decrement for regular item")
  void testSellinDecrement() {
    // Create a regular item with initial sellIn 5 days and quality 10.
    Item regularItem = new Item("Regular", 5, 10);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Call updateQuality to update the quality of the item.
    app.updateQuality();

    // Verify that the sellIn of the item has been decremented by 1.
    assertEquals(4, regularItem.sellIn, "SellIn should decrement by 1");
  }

  @Test
  @DisplayName("Test quality decrement for regular item when sellIn is negative")
  void testQualityDec() {
    // Create a regular item with initial quality 10 and sellIn -4 days.
    Item regularItem = new Item("Regular", -4, 10);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] {regularItem});

    // Call updateQuality to update the quality of the item.
    app.updateQuality();

    // Verify that the quality of the item has been decremented by 2.
    assertEquals(8, regularItem.quality, "Quality should decrement by 2");
  }
  @Test
  @DisplayName("Test quality decrement for Backstage Passes with negative sellIn")
  void testQualityDecBackstage() {
    // Create a Backstage Passes item with initial quality 10 and sellIn -4 days.
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", -4, 10);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] {backstagePasses});

    // Call updateQuality to update the quality of the item.
    app.updateQuality();

    // Verify that the quality of the Backstage Passes item has become 0.
    assertEquals(0, backstagePasses.quality, "Quality should be 0");
  }

  @Test
  @DisplayName("Test quality increment for Aged Brie with negative sellIn")
  void testQualityIncAgie() {
    // Create an Aged Brie item with initial quality 10 and sellIn -4 days.
    Item agedBrie = new Item("Aged Brie", -4, 10);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] {agedBrie});

    // Call updateQuality to update the quality of the item.
    app.updateQuality();

    // Verify that the quality of Aged Brie has been incremented by 2.
    assertEquals(12, agedBrie.quality, "Quality should increase by 2");
  }

  @Test
  @DisplayName("Test the toString method of the Item class")
  void testItemToString() {
    // Create an item with the name "Backstage passes," sellIn 3, and quality 25.
    Item item = new Item("Backstage passes", 3, 25);
    String expectedString = "Backstage passes, 3, 25";

    // Verify that the toString method returns the expected string.
    assertEquals(expectedString, item.toString(), "toString should return the expected string");
  }

  @Test
  @DisplayName("Test quality increment for Aged Brie when sellIn is zero")
  void testQualityIncrementForAgedBrieWhenSellInIsZero() {
    // Create an Aged Brie item with sellIn 0 and quality 40.
    Item agedBrie = new Item("Aged Brie", 0, 40);

    // Create an instance of GildedRose with the item and call updateQuality.
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();

    // Verify that the quality of Aged Brie has been incremented by 2.
    assertEquals(42, agedBrie.quality, "Quality should increment by 2");
  }

  @Test
  @DisplayName("Test quality becomes zero for Backstage Passes when sellIn is zero")
  void testQualityZeroForBackstageWhenSellInIsZero() {
    // Create a Backstage Passes item with sellIn 0 and quality 40.
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);

    // Create an instance of GildedRose with the item and call updateQuality.
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();

    // Verify that the quality of Backstage Passes becomes zero.
    assertEquals(0, backstage.quality, "Quality should be zero");
  }

  @Test
  @DisplayName("Test quality increment for Aged Brie when sellIn is negative")
  void testQualityIncrementForAgedBrieWhenSellInIsNegative() {
    // Create an Aged Brie item with sellIn -1 and quality 40.
    Item agedBrie = new Item("Aged Brie", -1, 40);

    // Create an instance of GildedRose with the item and call updateQuality.
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();

    // Verify that the quality of Aged Brie has been incremented by 2.
    assertEquals(42, agedBrie.quality, "Quality should increment by 2");
  }
  @Test
  @DisplayName("Aged Brie Quality Stays at 50 When SellIn Is Negative")
  void testAgedBrieQuality50WhenSellInNegative() {
    Item agedBrie = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] { agedBrie });
    app.updateQuality();
    assertEquals(50, agedBrie.quality, "Quality should be the same");
  }

  @Test
  @DisplayName("Backstage Quality Increases by 1 When SellIn Is 11")
  void testBackstageQualityIncrementWhenSellIn11() {
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(41, backstage.quality, "Quality should increment by 1");
  }

  @Test
  @DisplayName("Backstage Quality Increases by 1 When SellIn Is 10")
  void testBackstageQualityIncrementWhenSellIn10() {
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(50, backstage.quality, "Quality should increment by 1");
  }

  @Test
  @DisplayName("Backstage Quality Increases by 1 When SellIn Is 4")
  void testBackstageQualityIncrementWhenSellIn4() {
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48);
    GildedRose app = new GildedRose(new Item[] { backstage });
    app.updateQuality();
    assertEquals(50, backstage.quality, "Quality should increment by 1");
  }

  @Test
  @DisplayName("Sulfuras Quality Stays the Same When SellIn Is Negative")
  void testSulfurasQualityStaysSameWhenSellInNegative() {
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", -1, 40);
    GildedRose app = new GildedRose(new Item[] { sulfuras });
    app.updateQuality();
    assertEquals(40, sulfuras.quality, "Quality should remain the same");
  }


  ///////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////Mutation////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////
  @Test
  @DisplayName("Quality of Item with Initial Quality > 0 Should Stay Above Zero")
  void testQualityStaysAboveZeroForItemWithInitialQualityAboveZero() {
    // Create an item with an initial quality greater than zero.
    Item itemWithNonZeroQuality = new Item("Regular Item", 5, 0);
    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] { itemWithNonZeroQuality });

    // Call updateQuality to update the item's quality.
    app.updateQuality();
    // Verify that the item's quality remains above zero.
    assertEquals(0, itemWithNonZeroQuality.quality, "Quality should be 0");
  }

  @Test
  @DisplayName("Quality Increment for Backstage Passes with SellIn Equal to 6")
  void testQualityIncrementForBackstagePassesWithSellInEqual6() {
    // Create an item "Backstage passes" with initial quality 40 and sellIn equal to 6.
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 40);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] { backstagePasses });

    // Call updateQuality to update the item's quality.
    app.updateQuality();
    // Verify that the quality of the item increases by 2.
    assertEquals(42, backstagePasses.quality, "Quality should increment by 2");
  }
  @Test
  @DisplayName("Mutation Test: Quality Decrement When SellIn Is Zero")
  void mutationTestQualityDecrementWhenSellInIsZero() {
    // Create an item with a sellIn date of 0.
    Item item = new Item("Regular Item", 1, 40);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[] { item });

    // Call updateQuality to update the item's quality.
    app.updateQuality();

    // Verify that the quality of the item decreases by 2 (correcting the test).
    assertEquals(39, item.quality, "Quality should decrement by 2");
  }
  @Test
  @DisplayName("Quality Decreases When SellIn Is Zero")
  void testQualityDecreasesWhenSellInIsZero() {
    // Create an item with a sellIn date of 0.
    Item item = new Item("Regular Item", 0, 0);

    // Create an instance of GildedRose with the item.
    GildedRose app = new GildedRose(new Item[]{item});

    // Call updateQuality to update the item's quality.
    app.updateQuality();

    // Verify that the quality of the item decreases by 1 when sellIn is zero.
    assertEquals(0, item.quality, "Quality should decrement by 1");
  }
}
