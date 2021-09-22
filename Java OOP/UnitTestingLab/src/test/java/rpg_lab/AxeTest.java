package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int AXE_DURABILITY_AFTER_ATTACK = AXE_DURABILITY - 1;
    private static final int DUMMY_HEALTH = 30;
    private static final int DUMMY_XP = 30;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void initializeObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void testWeaponsLosesDurabilityAfterAttack() {
        this.axe.attack(this.dummy);
        Assert.assertEquals(AXE_DURABILITY_AFTER_ATTACK, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testBrokenWeaponCantAttack() {
        this.axe = new Axe(AXE_ATTACK, 0);
        axe.attack(dummy);
    }
}