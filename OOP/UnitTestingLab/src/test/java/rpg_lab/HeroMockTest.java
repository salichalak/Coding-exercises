package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroMockTest {
    private static final int TARGET_XP = 100;

    @Test
    public void testAttackGainsExperienceWhenTargetIsDead() {
        Weapon weapon = Mockito.mock(Weapon.class);
        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero("Hero", weapon);

        hero.attack(target);
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }
}