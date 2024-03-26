package zombie;

import java.util.Random;

public class Boss extends Zombie {

	private Random ran = new Random();

	private int shield;
	private final int MAX_SHIELD;
	private String name;

	public Boss(int pos, int hp, int max, int shield) {
		super("ZombieKing", pos, hp, max);
		this.shield = shield;
		MAX_SHIELD = shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public int getMaxShield() {
		return MAX_SHIELD;
	}


	public void attack(Unit hero) {
		int power = (ran.nextInt(maxDamage) + 1);
		int critical = ran.nextInt(4) + 1;
		if (critical == 1) {
			power *= 2;
			hero.setHp(hero.getHp() - power);
			if (hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.err.println("Å°¾Æ¾Æ¾Æ¾Ì¾Æ¾Æ¾Æ¾Æ¾Ì!!!!");
			System.err.println("CriticalDmage : " + power);
			System.out.println(hero);
		} else {
			hero.setHp(hero.getHp() - power);
			if (hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("¿ì¿ö¾î¾ô!");
			System.out.println("Damage" + power);
			System.out.println(hero);
		}

	}
}