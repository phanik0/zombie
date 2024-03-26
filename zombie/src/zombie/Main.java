package zombie;

import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Random r = new Random();

    Hero hero = new Hero("Hero", 1, 200, 20, 2);
    Zombie zom = new Zombie("Zombie",5, 100, 10);
    Boss boss = new Boss(9, 300, 20, 100);



    int pos = 1;
    hero.setPos(pos);
    while (true) {
      System.out.println("���� ��ġ = " + pos);

      System.out.print("������ �̵��ϱ�(1),�����ϱ�(2) ");

      int move = s.nextInt();

      if (move == 1) {
        pos = pos + 1;
        hero.setPos(pos);

        if (hero.getPos() == 5) {

          System.out.print("���� �������ϴ�. ���ݸ��� �ٲ�ϴ�. ");

          while (true) {

            System.out.print("�����ϱ�(1),���Ǹ��ñ�(2): ");
            int d = s.nextInt();

            if (d == 1) {
              zom.attack(hero); // ������ �̹��� ���ݷ� ����


              hero.attack(zom); // ���� �̹��� ���ݷ� ����

            }

            else if (d == 2) {
              hero.recovery();
            }
            if (hero.getHp() <= 0) {
              System.out.println("Hero�� �׾����ϴ�. ���ӿ��� �����ϴ�.�� ");
              break;
            }

            if (zom.getHp() <= 0) {
              System.out.println("����/������ �̰���ϴ�. �̵��� �� �ֽ��ϴ�");
              break;
            }
          }

        }
        if (hero.getPos() == 9) {

          System.out.print("������ �������ϴ�. ���ݸ��� �ٲ�ϴ�. ");
          while (true) {

            System.out.print("�����ϱ�(1),���Ǹ��ñ�(2): ");
            int d = s.nextInt();

            if (d == 1) {

              boss.attack(hero); // ������ �̹��� ���ݷ� ����

              hero.attack(boss); // ���� �̹��� ���ݷ� ����

            }

            if (d == 2) {
              hero.recovery();
            }

            if (hero.getHp() <= 0) {
              System.out.println("Hero�� �׾����ϴ�. ���ӿ��� �����ϴ�.�� ");
              break;

            }
            if (boss.getHp() <= 0) {
              System.out.println("������ �̰���ϴ�.");

            }

          }
          if (hero.getHp() <= 0) {
            break;
            }
        }
        if (hero.getPos() == 10) {
          System.out.println("���ӿ��� �¸��߽��ϴ�. �����մϴ�.");
          break;
        }

      } else if (move == 2) {
        break;
      }

    }
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}
