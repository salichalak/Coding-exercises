package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTests {
    private Player player;
    private Gun gun;

    @Before
    public void setUp() {
        player = new Player("Sali", 100);
        gun = new Gun("AK-47", 30);
    }

    @Test(expected = NullPointerException.class)
    public void setNameShouldThrowExWhenNull() {
        player = new Player(null, 100);
        Assert.assertNull(player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void setNameShouldThrowExWhenEmpty() {
        player = new Player(" ", 100);
        Assert.assertNull(player.getUsername());
    }

    @Test
    public void testSetNameShouldSetNameCorrectly() {
        Assert.assertEquals("Sali", this.player.getUsername());
        Assert.assertEquals(100, this.player.getHealth());
        Assert.assertEquals("AK-47", this.gun.getName());
        Assert.assertEquals(30, this.gun.getBullets());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHealthShouldThrowExWhenLessOrEqualToZero() {
        player = new Player("Sali", -1);
    }

    @Test
    public void getGunsShouldReturnAllGuns() {
        Gun m4A1 = new Gun("M4A1", 31);

        this.player.addGun(this.gun);
        this.player.addGun(m4A1);

        List<Gun> expected = new ArrayList<>(Arrays.asList(this.gun, m4A1));

        Assert.assertEquals(expected, this.player.getGuns());
    }

    @Test(expected = NullPointerException.class)
    public void addGunShouldThrowExWhenNull() {
        this.player.addGun(null);
    }


    @Test
    public void removeGunShouldRemoveCorrectly() {
        this.player.addGun(this.gun);
        Assert.assertTrue(this.player.removeGun(this.gun));
    }

    @Test
    public void getGunShouldReturnCorrectGun() {
        this.player.addGun(this.gun);

        Assert.assertEquals(this.gun.getName(), this.player.getGun("AK-47").getName());
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamageShouldThrowExWhenPlayerIsDead() {
        player = new Player("Sali", 0);
        this.player.takeDamage(1);
    }

    @Test
    public void takeDamageShouldSetHealthToZeroWhenNegativeAmount() {
        this.player.takeDamage(101);
        Assert.assertEquals(0, this.player.getHealth());
    }

    @Test
    public void takeDamageShouldDecreaseHealthCorrectly() {
        this.player.takeDamage(50);
        Assert.assertEquals(50, this.player.getHealth());
    }
}