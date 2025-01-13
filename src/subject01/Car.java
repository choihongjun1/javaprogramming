package subject01;

/**
 * 과제1
 * 차량 클래스
 *
 * @author 최홍준
 * @since 2024-10-10
 */

public class Car {
    private String carNumber; // 차량번호
    private String carModel; // 차량종류
    private String phoneNumber; // 전화번호

    public Car(String carNumber, String carModel, String phoneNumber) {
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.phoneNumber = phoneNumber;
    }

    /**
     * 전화번호 반환
     *
     * @return 전화번호
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 차량종류 반환
     *
     * @return 차량종류
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * 차량번호 반환
     *
     * @return 차량번호
     */
    public String getCarNumber() {
        return carNumber;
    }
}
