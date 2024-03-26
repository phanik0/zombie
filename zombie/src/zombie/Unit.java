package zombie;

import java.util.Random;

abstract public class Unit {
	private int pos;
	private int hp;
	private final int MAX_HP;
	private String name;
	int maxDamage;
	Random ran;

	public Unit(String name, int pos, int hp, int maxDamage) {
		this.name = name;
		this.pos = pos;
		this.hp = hp;
		MAX_HP = hp;
		this.maxDamage = maxDamage;
		ran = new Random();
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}

	public int getHp() {
		return hp;
	}
	public int getMaxHp() {
		return MAX_HP;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void move() {
		if (pos <= 10)
			pos++;
		System.out.println("오른쪽으로 이동. 현재 위치 : " + pos);
	}

	abstract void attack(Unit unit);
	@Override
	public String toString() {
		return String.format("%s [%d/%d]",name,hp,MAX_HP);
	}
}
