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

		int a = ran.nextInt(4) + 1;
		if (a == 1) {
			System.out.println("보스의 필살기 발동 2배의 공격력");
			int power = 2 * (ran.nextInt(maxDamage) + 1);
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("보스가 " + power + "의 공격력으로 공격 :" + " 현재 Hero hp : " + hero.getHp());
		} else {
			System.out.println("보스의 일반공격 ");
			int power = ran.nextInt(maxDamage) + 1;
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("보스가 " + power + "의 공격력으로 공격 :" + " 현재 Hero hp : " + hero.getHp());
		}
	}
}