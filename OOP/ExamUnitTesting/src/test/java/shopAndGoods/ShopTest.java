package shopAndGoods;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {

    @Test
    public void getShelvesShouldReturnAllShelves() {
        Map<String, Goods> expectedMap = new LinkedHashMap<>();
        expectedMap.put("Shelves1", null);
        expectedMap.put("Shelves2", null);
        expectedMap.put("Shelves3", null);
        expectedMap.put("Shelves4", null);
        expectedMap.put("Shelves5", null);
        expectedMap.put("Shelves6", null);
        expectedMap.put("Shelves7", null);
        expectedMap.put("Shelves8", null);
        expectedMap.put("Shelves9", null);
        expectedMap.put("Shelves10", null);
        expectedMap.put("Shelves11", null);
        expectedMap.put("Shelves12", null);

        Shop shop = new Shop();
        Assert.assertEquals(expectedMap, shop.getShelves());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addGoodsShouldThrowExWhenShelfDoesNotExist() throws OperationNotSupportedException {
        Goods good = new Goods("TEST", "12345");
        Shop shop = new Shop();
        shop.addGoods("Shelves13", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addGoodsShouldThrowExWhenShelfIsNotNull() throws OperationNotSupportedException {
        Goods good = new Goods("TEST", "12345");
        Goods good2 = new Goods("TESTTT", "666");
        Shop shop = new Shop();
        shop.addGoods("Shelves12", good);
        Assert.assertNotNull(shop.getShelves().get("Shelves12"));
        shop.addGoods("Shelves12", good2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addGoodsShouldThrowExWhenGoodAlreadyInShelf() throws OperationNotSupportedException {
        Goods good = new Goods("TEST", "12345");
        Shop shop = new Shop();
        shop.addGoods("Shelves1", good);
        shop.addGoods("Shelves2", good);
    }

    @Test
    public void addGoodsShouldReturnCorrectOutput() throws OperationNotSupportedException {
        Goods good = new Goods("TEST", "12345");
        Shop shop = new Shop();
        String actual = shop.addGoods("Shelves1", good);
        Assert.assertEquals("Goods: 12345 is placed successfully!", actual);
    }

    @Test
    public void removeGoodsShouldReturnCorrectOutput() throws OperationNotSupportedException {
        Goods good = new Goods("TEST", "666");
        Shop shop = new Shop();
        shop.addGoods("Shelves1", good);
        String actual = shop.removeGoods("Shelves1", good);
        Assert.assertEquals("Goods: 666 is removed successfully!", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeGoodsShouldThrowExWhenShelfNotFound() {
        Shop shop = new Shop();
        Goods good = new Goods("TEST", "12345");
        shop.removeGoods("Shelves13", good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeGoodsShouldThrowExWhenGoodDoesNotExists() {
        Shop shop = new Shop();
        Goods good = new Goods("TEST", "12345");
        shop.removeGoods("Shelves12", good);
    }

    @Test
    public void removeGoodsShouldRemoveCorrectly() throws OperationNotSupportedException {
        Goods good = new Goods("TEST", "12345");
        Shop shop = new Shop();
        shop.addGoods("Shelves12", good);
        Assert.assertEquals("TEST", shop.getShelves().get("Shelves12").getName());
        Assert.assertEquals("12345", shop.getShelves().get("Shelves12").getGoodsCode());
        shop.removeGoods("Shelves12", good);
        Assert.assertNull(shop.getShelves().get("Shelves12"));
    }
}