package week06.example02;

import java.util.Scanner;

public class Home {
    private HomeAppliance[] appliances;
    private final int capacity;
    private int count = 0;

    public Home(int capacity) {
        this.capacity = capacity;
        if (this.capacity > 0)
            appliances = new HomeAppliance[this.capacity];
    }

    public void buyHA(HomeAppliance ha) {
        if (this.count < this.capacity) {
            appliances[count++] = ha;
        } else {
            System.out.println("더이상 공간 없음");
        }
    }

    public void scanIoTDevice() {
        System.out.println("원격 제어 가능 제품 리스트");
        for (int i = 0; i < count; i++) {
            if (appliances[i] instanceof IoTInterface)
                System.out.println((i + 1) + ") " + appliances[i].getHaName());
        }
    }

    public void open() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("제어할 가전제품을 선택하세요!!");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ")" + appliances[i].getHaName());
            }
            System.out.print("제품을 선택해 주세요 : ");
            int index = scan.nextInt();
            if (index >= 1 && index <= count) {
                appliances[index - 1].menu();
            } else {
                System.out.println("가전제품 제어를 종료합니다.");
                break;
            }
        }
    }
}
