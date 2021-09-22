package bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {
    private BankVault bankVault;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
    }

    @Test
    public void getVaultCellsShouldReturnCells() throws OperationNotSupportedException {
        Map<String, Item> expectedMap = new LinkedHashMap<>();

        expectedMap.put("A1", null);
        expectedMap.put("A2", null);
        expectedMap.put("A3", null);
        expectedMap.put("A4", null);
        expectedMap.put("B1", null);
        expectedMap.put("B2", null);
        expectedMap.put("B3", null);
        expectedMap.put("B4", null);
        expectedMap.put("C1", null);
        expectedMap.put("C2", null);
        expectedMap.put("C3", null);
        expectedMap.put("C4", null);

        Map<String, Item> actualMap = this.bankVault.getVaultCells();
        Assert.assertEquals(expectedMap, actualMap);

        Item item = new Item("Test", "2");
        this.bankVault.addItem("C4", item);
        boolean isTheSameOwner = this.bankVault.getVaultCells().get("C4").getOwner().equals("Test");

        Assert.assertTrue(isTheSameOwner);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addToNonExistingCellShouldThrowEx() throws OperationNotSupportedException {
        Item item = new Item("Demo", "123");
        this.bankVault.addItem("C5", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemToTakenCellShouldThrowEx() throws OperationNotSupportedException {
        Item item1 = new Item("Demo", "1");
        Item item2 = new Item("Test", "2");
        this.bankVault.addItem("C4", item1);
        this.bankVault.addItem("C4", item2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addExistingItemShouldThrowEx() throws OperationNotSupportedException {
        Item item = new Item("Demo", "1");
        this.bankVault.addItem("C4", item);
        this.bankVault.addItem("C3", item);
    }

    @Test
    public void addItemShouldAddSuccessfully() throws OperationNotSupportedException {
        Item item = new Item("George", "666");
        String expected = "Item:666 saved successfully!";
        String actual = this.bankVault.addItem("C2", item);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemFromNonExistingCellShouldThrowEx() {
        Item item = new Item("George", "666");
        this.bankVault.removeItem("C5", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistingItemFromCellShouldThrowEx() throws OperationNotSupportedException {
        Item item1 = new Item("Test_Name", "666");
        this.bankVault.addItem("C4", item1);
        Item item2 = new Item("Test_Name", "666");
        this.bankVault.removeItem("C4", item2);
    }

    @Test
    public void removeItemShouldRemoveCorrectly() throws OperationNotSupportedException {
        Item item = new Item("Demo", "1");
        this.bankVault.addItem("C4", item);
        String expected = "Remove item:1 successfully!";
        String actual = this.bankVault.removeItem("C4", item);
        Assert.assertEquals(expected, actual);
        Assert.assertNull(this.bankVault.getVaultCells().get("C4"));
    }
}