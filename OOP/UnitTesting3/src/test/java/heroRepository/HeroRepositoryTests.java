package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Sali", 10);
    }

    @Test(expected = NullPointerException.class)
    public void createHeroWithNull() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createAlreadyExistingHero() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);
    }

    @Test(expected = NullPointerException.class)
    public void removeWithNullName() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void removeWithEmptyName() {
        Assert.assertFalse(heroRepository.remove("  "));
    }

    @Test
    public void createSuccessfulHero() {
        Assert.assertEquals(0, heroRepository.getCount());
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
        Hero created = this.heroRepository.getHero("Sali");
        Assert.assertEquals(created.getName(), this.hero.getName());
        Assert.assertEquals(created.getLevel(), this.hero.getLevel());
    }

    @Test
    public void removeSuccessfully() {
        this.heroRepository.create(this.hero);
        Assert.assertEquals(1, heroRepository.getCount());
        this.heroRepository.remove("Sali");
        Assert.assertEquals(0, heroRepository.getCount());
        Hero removed = this.heroRepository.getHero("Sali");
        Assert.assertNull(removed);
    }

    @Test
    public void getHeroWithHighestLevelShouldReturnCorrectHero() {
        this.heroRepository.create(this.hero);
        Hero hero2 = new Hero("George", 36);
        Hero hero3 = new Hero("Michael", 100);
        this.heroRepository.create(hero2);
        this.heroRepository.create(hero3);
        Assert.assertEquals(3, heroRepository.getHeroes().size());
        Hero highestHero = this.heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(highestHero.getName(), hero3.getName());
        Assert.assertEquals(highestHero.getLevel(), hero3.getLevel());
    }
}