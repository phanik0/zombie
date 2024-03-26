package zombie;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private final int SIZE = 10;
	private final int HERO = 1;
	private final int ZOMBIE = 2;
	private final int BOSS = 3;
	private Hero hero;
	private Zombie zombie;
	private Boss boss;

	private int pos;
	private int[] map;

	private Game() {

	}

	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	}

	private int inputNumber(String message) {
		int number = 0;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("���ڸ� �Է����ּ���");
		}
		return number;
	}

	private String inputString(String message) {
		System.out.println(message);
		return scan.next();
	}

	private void setGame() {
		String name = inputString("�̸��� �Է����ּ���");
		hero = new Hero(name, 1, 200, 20, 2);
		zombie = new Zombie("Zombie", 5, 100, 10);
		boss = new Boss(9, 300, 20, 100);
		pos = 0;
		map = new int[SIZE];
		map[hero.getPos()] = HERO;
		map[zombie.getPos()] = ZOMBIE;
		map[boss.getPos()] = BOSS;

	}

	private void printMap() {
		for (int i = 0; i < SIZE; i++) {
			if (map[i] == hero.getPos())
				System.out.print("��_");
			else if (map[i] == zombie.getPos())
				System.out.print("��_");
			else if (map[i] == boss.getPos())
				System.out.print("B_");
			else
				System.out.print("__");
		}
	}

	private void moveHero() {
		int position = hero.getPos();
		map[position] = 0;
		position++;

		if (position == zombie.getPos()) {
			fightZombie();
		} else if (position == boss.getPos()) {
			fightBoss();
		}
		map[position] = HERO;
		hero.setPos(position);

	}

	private void fightZombie() {
		System.err.println("DANGER ALERT");
		System.out.println("���..����");
		while (true) {
			int sel = scan.nextInt();

			if (sel == 1) {
				hero.attack(zombie); // ���� �̹��� ���ݷ� ����
				zombie.attack(hero); // ������ �̹��� ���ݷ� ����
			}

			else if (sel == 2) {
				hero.recovery();
			}
			if (hero.getHp() <= 0) {
				System.out.println(" YOU DEAD ");
				break;
			}

			if (zombie.getHp() <= 0) {
				System.out.println("STAGE CLEAR");
				break;
			}
		}
	}

	private void fightBoss() {

	}

	private void playGame() {
		printMap();
		int move = inputNumber("(1)�̵��ϱ�, (2)����");
		if (move == 1)
			moveHero();
	}

	public void run() {
		setGame();
		while (true) {
			playGame();
		}
//		Main.main(null);
	}
}