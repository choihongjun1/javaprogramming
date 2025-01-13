package week05.example01;

public class Vehicle {
    public String color;
    public int speed;
    public int mileage;
    public char gearStatus;
    public TV tv;

    public Vehicle(Vehicle car) {
        this(car.color, car.speed, car.mileage, car.gearStatus, new TV(car.tv));
//        this.color = car.color;
//        this.speed = car.speed;
//        this.mileage = car.mileage;
//        this.gearStatus = car.gearStatus;
    }

    public void accelerate(int speed) {
        if ((this.gearStatus != 'P') && (this.gearStatus != 'N')) {
            this.speed += speed;
            this.mileage += speed;
        } else {
            System.out.println("현재 기어상태는 " + this.gearStatus + " 상태입니다.");
        }
    }

    public void breaker(int speed) {
        if ((this.gearStatus != 'P') && (this.gearStatus != 'N')) {
            this.speed -= speed;
            this.mileage += speed;
        } else {
            System.out.println("현재 기어상태는 " + this.gearStatus + " 상태입니다.");
        }
    }

    public void changeGear(char gearStatus) {
        this.gearStatus = gearStatus;
        this.speed = switch (this.gearStatus) {
            case 'P', 'N' -> 0;
            case '1' -> 20;
            case '2' -> 30;
            default -> this.speed;
        };
    }

    public Vehicle(String color, int speed, int mileage, char gearStatus) {
        this(color, speed, mileage, gearStatus, null);
//        this.color = color;
//        this.speed = speed;
//        this.mileage = mileage;
//        this.gearStatus = gearStatus;
//        System.out.println("this : " + this);
    }

    public Vehicle(String color, int speed, int mileage, char gearStatus, TV tv) {
        this.color = color;
        this.speed = speed;
        this.mileage = mileage;
        this.gearStatus = gearStatus;
        this.tv = tv;
    }

    public Vehicle() {
        this("검은색", 0, 0, 'P');
//        this.color = "검은색";
//        this.speed = 0;
//        this.mileage = 0;
//        this.gearStatus = 'P';
    }

    public Vehicle(String color, int mileage) {
        this(color, 0, 0, 'P');
//        this.color = color;
//        this.speed = 0;
//        this.mileage = mileage;
//        this.gearStatus = 'P';
    }

    public void showStatus() {
        System.out.println("차량색상 : " + this.color);
        System.out.println("차량속도 : " + this.speed);
        System.out.println("주행거리 : " + this.mileage);
        System.out.println("기어상태 : " + this.gearStatus);
        System.out.println("-".repeat(20));
        String status = switch (this.gearStatus) {
            case 'P' -> "주차중";
            case 'N' -> "중립모드";
            case '0' -> "주행중";
            case '1' -> "1단 저속 운행중";
            case '2' -> "2단 저속 운행중";
            default -> "기어상태 확인요함";
        };
        System.out.println(status);
        System.out.println("-".repeat(20));
        if (tv != null)
            tv.showTV();
    }
}
