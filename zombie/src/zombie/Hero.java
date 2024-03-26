package zombie;

public class Hero extends Unit {
	int power;
	int count;

	public Hero(String name, int pos, int hp, int max, int count) {
		super(name, pos, hp, max);
		this.count = count;
	}

	@Override
	public void attack(Unit enemy) {

		if (enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			attackBoss(boss);
		} else {
			attackZombie(enemy);
		}
	}
	private void attackBoss(Boss boss) {
		power = ran.nextInt(maxDamage) + 1;
		if (boss.getShield() > 0) {
			int r = boss.getShield() - power;
			if (r >= 0) {
				boss.setShield(boss.getShield() - power);
			} else {
				boss.setShield(0);
				boss.setHp(boss.getHp() - r);
			}
		} else {
			boss.setHp(boss.getHp() - power);
		}

		if (boss.getHp() <= 0) {
			boss.setHp(0);
		}
		System.out.println("흐아앗!");
		System.out.println("Damage : " + power);
		System.out.println(boss);
	}
	private void attackZombie(Unit enemy) {
		power = ran.nextInt(maxDamage) + 1;
		enemy.setHp(enemy.getHp() - power);
		if (enemy.getHp() <= 0) {
			enemy.setHp(0);
		}
		System.out.println("하아앗!");
		System.out.println("Damage : " + power);

		System.out.println(enemy);
	}
	public void recovery() {
		if (count > 0) {
			setHp(getHp() + 100);
			System.out.println("체력 회복해서" + getHp() + "이 되었습니다");
			count -= 1;
		} else if (count == 0) {
			System.out.println("모두 사용했습니다.");
		}

	}

	

}
