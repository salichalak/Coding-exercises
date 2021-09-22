package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputerManagerTests {
    private Computer computer;
    private ComputerManager computerManager;

    @Before
    public void initialize() {
        this.computer = new Computer("Asus", "Rog", 1600);
        this.computerManager = new ComputerManager();
    }

    @Test
    public void getComputerShouldReturnCorrectComputer() {
        Assert.assertEquals(0, this.computerManager.getCount());
        Assert.assertEquals(0, this.computerManager.getComputers().size());

        this.computerManager.addComputer(this.computer);
        Computer expected = this.computer;
        Computer actual = this.computerManager.getComputer("Asus", "Rog");
        Assert.assertEquals(expected, actual);

        String price = "" + computerManager.getComputer("Asus", "Rog").getPrice();
        Assert.assertEquals("1600.0", price);

        Assert.assertEquals("Asus", this.computerManager.getComputer("Asus", "Rog").getManufacturer());
        Assert.assertEquals("Rog", this.computerManager.getComputer("Asus", "Rog").getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerShouldThrowExWhenAddingExistingComputer() {
        this.computerManager.addComputer(this.computer);
        this.computerManager.addComputer(this.computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerShouldThrowExWhenTheComputerIsNotFound() {
        this.computerManager.getComputer("HP", "Pavilion");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerShouldThrowExWhenNull() {
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputersByManufacturerShouldThrowExWhenNull() {
        this.computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void getComputersByManufacturerShouldReturnCorrectly() {
        this.computerManager.addComputer(this.computer);
        Computer hp = new Computer("HP", "Pavilion", 2000);
        this.computerManager.addComputer(hp);
        Computer asus = new Computer("Asus", "213", 900);
        this.computerManager.addComputer(asus);

        List<Computer> expected = new ArrayList<>(Arrays.asList(this.computer, asus));
        List<Computer> actual = this.computerManager.getComputersByManufacturer("Asus");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeComputerShouldRemoveCorrectly() {
        this.computerManager.addComputer(this.computer);
        this.computerManager.removeComputer("Asus", "Rog");
        Assert.assertEquals(0, this.computerManager.getCount());
    }
}