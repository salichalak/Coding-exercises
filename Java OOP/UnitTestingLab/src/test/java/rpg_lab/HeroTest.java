package rpg_lab;


import org.junit.Assert;
import org.junit.Test;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTest {
    private static final int TARGET_XP = 69;
    private static final int ATTACK_POINTS = 69;

    @Test
    public void testAttackGainsExperienceWhenTargetIsDead() {
        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return ATTACK_POINTS;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Hero hero = new Hero("Hero", fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals(TARGET_XP, hero.getExperience());
    }
}