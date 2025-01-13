package week06.lab01;

import java.util.Scanner;

/**
 * 06주차 실습
 *
 * @author 최홍준
 * @since 2024-10-11
 */

public class Vacuum extends HomeAppliance implements IoTInterface {
    public static Scanner scan = new Scanner(System.in);
    private int level = 1;

    public Vacuum(String haName, int level) {
        super(haName);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void showStatus() {
        if (this.isHaPower()) {
            System.out.println(this.getHaName() + "의 청소 세기 " + this.level + "레벨");
        } else {
            System.out.println(this.getHaName() + "의 전원이 꺼져 있습니다.");
        }
    }

    @Override
    public void menu() {
        System.out.println("청소기를 제어합니다.");
        int choice = 0;
        while (choice != 3) {
            System.out.print("1)전원 2)청소 레벨 3)제어종료\n원하는 메뉴를 선택하세요 : ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    this.setHaPower(!this.isHaPower());
                    this.showStatus();
                }
                case 2 -> {
                    if (this.isHaPower()) {
                        System.out.print("청소 레벨 입력(1~3) : ");
                        int level = scan.nextInt();
                        if (level >= 1 && level <= 3) {
                            this.setLevel(level);
                        } else {
                            this.setLevel(1);
                        }
                    }
                    this.showStatus();
                }
                case 3 -> {
                    System.out.println(this.getHaName() + " 제어 종료!!");
                    return;
                }
                default -> System.out.println("입력 메뉴를 확인하세요.");
            }
        }
    }

    @Override
    public void turnOn() {
        this.setHaPower(true);
    }

    @Override
    public void turnOff() {
        this.setHaPower(false);
    }

    @Override
    public void control() {
        this.menu();
    }
}
