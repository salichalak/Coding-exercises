package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWithNameIsNull() {
        Aquarium aquarium = new Aquarium(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWithNameIsEmpty() {
        Aquarium aquarium = new Aquarium("     ", 1);
    }

    @Test
    public void testSetNameShouldSetCorrectName() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        Assert.assertEquals("Atlantis", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWithNegativeValue() {
        Aquarium aquarium = new Aquarium("Atlantis", -5);
    }

    @Test
    public void testSetCapacityShouldSetCorrectCapacity() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        Assert.assertEquals(1, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishShouldFailWhenMaxCapacityIsReached() {
        Aquarium aquarium = new Aquarium("Atlantis", 0);
        Fish fish = new Fish("TEST");
        aquarium.add(fish);
    }

    @Test
    public void testAddFishShouldAddCorrectlyWhenCapacityIsNotFull() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        Fish fish = new Fish("TEST");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test
    public void testRemoveFishShouldDecreaseTheCount() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        Fish fish = new Fish("TEST");
        aquarium.add(fish);
        aquarium.remove("TEST");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldFailWithFishToRemoveNull() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        aquarium.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldFailWhenTheFishIsNotFound() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        aquarium.sellFish("NoNameFish");
    }

    @Test
    public void testSellFishShouldSetFishAsSold() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        Fish fish = new Fish("TEST");
        aquarium.add(fish);
        aquarium.sellFish("TEST");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void testGetInfoShouldReturnCorrectInfo() {
        Aquarium aquarium = new Aquarium("Atlantis", 1);
        aquarium.add(new Fish("TEST"));
        String expected = "Fish available at Atlantis: TEST";
        Assert.assertEquals(expected, aquarium.report());
    }
}