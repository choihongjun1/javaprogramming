package week06.lab01;

import java.util.Scanner;

/**
 * 06주차 실습
 *
 * @author 최홍준
 * @since 2024-10-11
 */

public class TV extends HomeAppliance {
    static Scanner scan = new Scanner(System.in);

    private int channel = 10;

    public TV(String haName, int channel) {
        super(haName);
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void showStatus() {
        if (this.isHaPower()) {
            System.out.println(this.getHaName() + "의 채널" + channel + "번 시청중");
        } else {
            System.out.println(this.getHaName() + "의 전원이 꺼져 있습니다.");
        }
    }

    @Override
    public void menu() {
        System.out.println("TV를 제어합니다.");
        int choice = 0;
        while (choice != 3) {
            System.out.print("1)전원 2)채널 3)제어종료\n원하는 메뉴를 선택하세요 : ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    this.setHaPower(!this.isHaPower());
                    this.showStatus();
                }
                case 2 -> {
                    if (this.isHaPower()) {
                        System.out.print("채널 입력 : ");
                        this.setChannel(scan.nextInt());
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
}
