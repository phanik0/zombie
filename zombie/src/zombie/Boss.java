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
			System.out.println("������ �ʻ�� �ߵ� 2���� ���ݷ�");
			int power = 2 * (ran.nextInt(maxDamage) + 1);
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("������ " + power + "�� ���ݷ����� ���� :" + " ���� Hero hp : " + hero.getHp());
		} else {
			System.out.println("������ �Ϲݰ��� ");
			int power = ran.nextInt(maxDamage) + 1;
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("������ " + power + "�� ���ݷ����� ���� :" + " ���� Hero hp : " + hero.getHp());
		}
	}
}