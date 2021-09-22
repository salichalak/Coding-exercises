package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void setUp() {
        spaceship = new Spaceship("TEST", 2);
        astronaut = new Astronaut("Michael", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityBelowZero() {
        new Spaceship("TEST", -1);
    }

    @Test
    public void setCapacityWithCorrectValue() {
        Assert.assertEquals(2, spaceship.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void setNameShouldFailWhenNameIsNull() {
        new Spaceship(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void setNameShouldFailWhenNameIsEmpty() {
        new Spaceship("   ", 2);
    }

    @Test
    public void setNameShouldSetNameCorrectly() {
        Assert.assertEquals("TEST", spaceship.getName());
    }

    @Test
    public void removeShouldReturnFalseWhenSuchAstronautNotFound() {
        Assert.assertFalse(spaceship.remove("Nemo"));
    }

    @Test
    public void removeShouldReturnTrueWhenAstronautExists() {
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
        Assert.assertTrue(spaceship.remove("Michael"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFailWhenMaxCapacityReached() {
        spaceship.add(astronaut);
        Astronaut astronaut2 = new Astronaut("George", 25);
        Astronaut astronaut3 = new Astronaut("Elliot", 60);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFailWhenAddingExistingAstronaut() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }
}