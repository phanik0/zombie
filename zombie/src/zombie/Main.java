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
      System.out.println("현재 위치 = " + pos);

      System.out.print("앞으로 이동하기(1),종료하기(2) ");

      int move = s.nextInt();

      if (move == 1) {
        pos = pos + 1;
        hero.setPos(pos);

        if (hero.getPos() == 5) {

          System.out.print("좀비를 만났습니다. 공격모드로 바뀝니다. ");

          while (true) {

            System.out.print("공격하기(1),포션마시기(2): ");
            int d = s.nextInt();

            if (d == 1) {
              zom.attack(hero); // 좀비의 이번턴 공격력 저장


              hero.attack(zom); // 나의 이번턴 공격력 저장

            }

            else if (d == 2) {
              hero.recovery();
            }
            if (hero.getHp() <= 0) {
              System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.” ");
              break;
            }

            if (zom.getHp() <= 0) {
              System.out.println("좀비/보스를 이겼습니다. 이동할 수 있습니다");
              break;
            }
          }

        }
        if (hero.getPos() == 9) {

          System.out.print("보스를 만났습니다. 공격모드로 바뀝니다. ");
          while (true) {

            System.out.print("공격하기(1),포션마시기(2): ");
            int d = s.nextInt();

            if (d == 1) {

              boss.attack(hero); // 보스의 이번턴 공격력 저장

              hero.attack(boss); // 나의 이번턴 공격력 저장

            }

            if (d == 2) {
              hero.recovery();
            }

            if (hero.getHp() <= 0) {
              System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.” ");
              break;

            }
            if (boss.getHp() <= 0) {
              System.out.println("보스를 이겼습니다.");

            }

          }
          if (hero.getHp() <= 0) {
            break;
            }
        }
        if (hero.getPos() == 10) {
          System.out.println("게임에서 승리했습니다. 종료합니다.");
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
