package zombie;

import java.util.Random;

public class Boss extends Zombie {
	
	private Random ran = new Random();
	
	private int shield;
	private String name;
	public void setShield(int value) {
		shield = value;
	}
	public int getShield() {
		return shield;
	}
	
	
	public Boss(int pos, int hp, int max, int shield) {
		super("ZombieKing",pos, hp, max);
		this.shield = shield;
	}

	public void attack(Unit hero) {
		int power = (ran.nextInt(maxDamage) + 1);
		int critical = ran.nextInt(4) + 1;
		if (critical == 1) {
			power *= 2;
			System.err.println("좀비킹의 ");
			System.err.println("CriticalDmage : "+power);
			System.out.println(hero);
		} else {
			System.out.println("Damage" + power);
			System.out.println(hero);
		}
		hero.setHp(hero.getHp() - power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
	}
}