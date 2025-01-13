package week06.lab01;

import java.util.Scanner;

/**
 * 06주차 실습
 *
 * @author 최홍준
 * @since 2024-10-11
 */

public class Boiler extends HomeAppliance implements IoTInterface {
    public static Scanner scan = new Scanner(System.in);
    private int temperature = 10;

    public Boiler(String haName, int temperature) {
        super(haName);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public void showStatus() {
        if (this.isHaPower()) {
            System.out.println(this.getHaName() + "의 보일러온도 " + this.temperature + "도");
        } else {
            System.out.println(this.getHaName() + "의 전원이 꺼져 있습니다.");
        }
    }

    @Override
    public void menu() {
        System.out.println("보일러를 제어합니다.");
        int choice = 0;
        while (choice != 3) {
            System.out.print("1)전원 2)난방온도 3)제어종료\n원하는 메뉴를 선택하세요 : ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    this.setHaPower(!this.isHaPower());
                    this.showStatus();
                }
                case 2 -> {
                    if (this.isHaPower()) {
                        System.out.print("난방온도 입력 : ");
                        setTemperature(scan.nextInt());
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
