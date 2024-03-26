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

	private int damage(int power) {
		
		int critical = ran.nextInt(10) + 1;
		if (critical == 1) {
			power *= 3;
			System.err.println("검에서 매화를 피워낸다");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.err.println("매화참!: " + power);
		} else {
			System.out.println("하아앗!");
			System.out.println("Damage" + power);
		}
		return power;
	}

	private void attackBoss(Boss boss) {
		power = ran.nextInt(maxDamage) + 1;
		int damage = damage(power);
		if (boss.getShield() > 0) {
			int shield = boss.getShield() - damage;
			if (shield >= 0) {
				boss.setShield(boss.getShield() - damage);
			} else {
				boss.setShield(0);
				boss.setHp(boss.getHp() - shield);
			}
			System.out.printf(boss + "[%d/%d]\n", boss.getShield(), boss.getMaxShield());
		} else {
			boss.setHp(boss.getHp() - damage);
		}

		if (boss.getHp() <= 0) {
			boss.setHp(0);
		}
		System.out.println(boss);
	}

	private void attackZombie(Unit enemy) {
		power = ran.nextInt(maxDamage) + 1;
		int damage = damage(power);
		enemy.setHp(enemy.getHp() - damage);
		if (enemy.getHp() <= 0) {
			enemy.setHp(0);
		}
		System.out.println(enemy);
	}

	public void recovery() {
		if (count > 0) {
			if (getHp() + 100 < getMaxHp())
				setHp(getHp() + 100);
			else
				setHp(getMaxHp());
			System.out.println("지이잉");
			System.out.println("+ hp 100");
			System.out.println(super.toString());
			count -= 1;
		} else if (count == 0) {
			System.out.println("모두 사용했습니다.");
		}

	}

}
