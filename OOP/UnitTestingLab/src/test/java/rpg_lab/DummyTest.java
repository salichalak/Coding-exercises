package rpg_lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int AXE_ATTACK = 20;
    private static final int AXE_DURABILITY = 20;
    private static final int DUMMY_HEALTH = 30;
    private static final int DUMMY_XP = 30;
    private static final int DUMMY_HEALTH_AFTER_ATTACK = DUMMY_HEALTH - AXE_ATTACK;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void initializeObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        this.axe.attack(this.dummy);
        Assert.assertEquals(DUMMY_HEALTH_AFTER_ATTACK, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionWhenAttacked() {
        this.dummy.takeAttack(AXE_ATTACK);
        this.dummy.takeAttack(AXE_ATTACK);
        this.dummy.takeAttack(AXE_ATTACK);
    }

    @Test
    public void testDeadDummyCanGiveXP() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
        Assert.assertEquals(DUMMY_XP, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCannotGiveXP() {
        this.axe.attack(this.dummy);
        dummy.giveExperience();
    }
}