package zombie;

public class Zombie extends Unit {
	int power;

	public Zombie(String name, int pos, int hp, int max) {
		super(name, pos, hp, max);
	}

	public void attack(Unit hero) {
		power = ran.nextInt(maxDamage) + 1;

		hero.setHp(hero.getHp() - power);
		if (hero.getHp() <= 0) {
			hero.setHp(0);
		}

		System.out.println("¿ì¾î¾ô!");
		System.out.println("Damage : " + power);
		System.out.println(hero);
	}

}