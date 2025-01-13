package subject01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 과제1
 * 주차장 클래스
 *
 * @author 최홍준
 * @since 2024-10-10
 */

public class ParkingLot {
    public String fileName;
    public static Scanner scan = new Scanner(System.in);

    public int rows = 0; // 주차장 행 크기
    public int cols = 0; // 주차장 열 크기
    public Car[][] parkingLotList; // 2차원 차량객체 배열

    public ParkingLot(String fileName) {
        this.fileName = fileName;
        setUp(); // 객체 배열 초기화
    }

    /**
     * 객체 배열 초기화
     */
    public void setUp() {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            rows = scanner.nextInt();
            cols = scanner.nextInt();
            parkingLotList = new Car[rows][cols];

            while (scanner.hasNext()) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                String carNumber = scanner.next();
                String carModel = scanner.next();
                String phoneNumber = scanner.next();
                parkingLotList[row][col] = new Car(carNumber, carModel, phoneNumber);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    /**
     * 메뉴
     */
    public void menu() {
        int obtion = 0; // 선택 메뉴
        while (obtion != 6) {
            status(); // 주차장 상태
            System.out.println("1. 차량 주차 2. 차량 출차 3. 차량 검색 4. 주차장 정보 출력 5. 주차 위치 추천 6. 종료");
            System.out.print("메뉴를 선택하세요 : ");
            obtion = scan.nextInt();
            switch (obtion) {
                case 1 -> carParking();
                case 2 -> carExit();
                case 3 -> carSearch();
                case 4 -> info();
                case 5 -> parkingSpot();
                case 6 -> System.out.println("종료");
                default -> System.out.println("존재하지 않는 메뉴입니다.");
            }
            System.out.println("-".repeat(40));
        }
    }

    /**
     * 주차장 상태
     */
    public void status() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { // 모든 위치 조사
                if (parkingLotList[i][j] != null) { // 빈자리가 아니면
                    System.out.print("■");
                } else { // 빈자리이면
                    System.out.print("□");
                }
            }
            System.out.println();
        }
    }

    /**
     * 만석 확인
     *
     * @return 만석 여부
     */
    public boolean full() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { // 모든 위치 조사
                if (parkingLotList[i][j] == null) {
                    return false; // 빈자리있으면 거짓
                }
            }
        }
        return true; // 빈자리 없으면 참
    }

    /**
     * 주차
     */
    public void carParking() {
        if (!full()) { // 빈자리가 있으면
            label:
            while (true) {
                System.out.print("주차할 위치를 입력해주세요 : ");
                int row = scan.nextInt();
                int col = scan.nextInt();
                if ((row < rows) && (row >= 0) && (col < cols) && (col >= 0)) { // 입력 받은 범위가 유효한 범위이면
                    if (parkingLotList[row][col] == null) { // 빈 자리이면
                        System.out.print("차량번호를 입력하세요 : ");
                        String carNumber = scan.next();

                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < cols; j++) { // 모든 위치 조사
                                if (parkingLotList[i][j] != null) { // 주차된 차량이 있고
                                    if (parkingLotList[i][j].getCarNumber().equals(carNumber)) { // 입력받은 차량번호와 주차된 차량의 차량번호가 일치하면
                                        System.out.println("이미 주차된 차량입니다.");
                                        break label;
                                    }
                                }
                            }
                        }

                        System.out.print("차량종류를 입력하세요 : ");
                        String carModel = scan.next();
                        System.out.print("전화번호를 입력하세요 : ");
                        String phoneNumber = scan.next();

                        parkingLotList[row][col] = new Car(carNumber, carModel, phoneNumber); // row col 위치에 객체 생성
                        System.out.println("주차 완료");
                        break;
                    } else { // 빈자리가 아니면
                        System.out.println("빈 자리가 아닙니다.");
                    }
                } else { // 유효한 범위가 아니면
                    System.out.println("존재하지 않는 위치입니다.");
                }
            }
        } else { // 빈자리가 없으면
            System.out.println("빈 자리가 없습니다.");
        }
    }

    /**
     * 출차
     */
    public void carExit() {
        System.out.print("출차할 차량번호를 입력해주세요 : ");
        String carNumber = scan.next();
        boolean b = false; // 출차 여부
        label:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { // 모든 위치 조사
                if (parkingLotList[i][j] != null) { // 빈자리가 아니고
                    if (parkingLotList[i][j].getCarNumber().equals(carNumber)) { // 입력받은 차량번호와 주차된 차량의 차량번호가 같으면
                        parkingLotList[i][j] = null; // 빈자리로 만들기
                        System.out.println("출차 완료");
                        b = true;
                        break label;
                    }
                }
            }
        }
        if (!b) // 출차하지 못했으면
            System.out.println("차량번호가 일치하는 차가 없습니다.");
    }

    /**
     * 차량 검색
     */
    public void carSearch() {
        System.out.print("차량번호 또는 전화번호를 입력하세요 : ");
        String str = scan.next();
        boolean b = false; // 차량 존재 여부
        int row = 0;
        int col = 0;

        label:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { // 모든 위치 조사
                if (parkingLotList[i][j] != null) { // 빈자리가 아니고
                    if ((parkingLotList[i][j].getCarNumber().equals(str)) || (parkingLotList[i][j].getPhoneNumber().equals(str))) { // 입력받은 정보가 차량번호 또는 전화번호와 같으면
                        b = true;
                        row = i; // 행 위치 저장
                        col = j; // 열 위치 저장
                        break label;
                    }
                }
            }
        }

        if (b) { // 차량이 존재하면
            System.out.println("차량 위치 : " + row + " " + col);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (parkingLotList[i][j] != null) { // 빈자리가 아니고
                        if ((parkingLotList[i][j].getCarNumber().equals(str)) || (parkingLotList[i][j].getPhoneNumber().equals(str))) { // 입력받은 정보와 차량번호 또는 전화번호가 같으면
                            System.out.print("★");
                        } else { // 입력받은 정보와 차량번호와 전화번호가 다르면
                            System.out.print("□");
                        }
                    } else { // 빈자리이면
                        System.out.print("□");
                    }
                }
                System.out.println();
            }
        } else { // 차량이 존재하지 않으면
            System.out.println("정보와 일치하는 차량이 없습니다.");
        }
    }

    /**
     * 주차장 정보
     */
    public void info() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) { // 모든 위치 조사
                if (parkingLotList[i][j] != null) { // 빈자리가 아니면
                    System.out.println("차량위치 : " + i + " " + j);
                    System.out.println("차량번호 : " + parkingLotList[i][j].getCarNumber());
                    System.out.println("차량종류 : " + parkingLotList[i][j].getCarModel());
                    System.out.println("전화번호 : " + parkingLotList[i][j].getPhoneNumber());
                    System.out.println();
                }
            }
        }
    }

    /**
     * 주차 위치 추천
     */
    public void parkingSpot() {
        if (!full()) { // 빈자리가 있으면
            int min = rows + cols; // 최소 거리
            int size = (rows < cols) ? rows : cols; // 최소 거리인 위치 행, 열 정보 저장하는 배열 크기, 행 수와 열 수 중 작은 값이 최대 크기
            int[] minRow = new int[size]; // 최소 거리인 위치 행 정보 저장
            int[] minCol = new int[size]; // 최소 거리인 위치 열 정보 저장
            for (int i = 0; i < size; i++) { // 모든 원소 -1로 초기화
                minRow[i] = -1;
                minCol[i] = -1;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) { // 모든 위치 조사
                    if (parkingLotList[i][j] == null) { // 빈자리이고
                        if (i + j < min) { // 현재 위치의 거리가 최소 거리보다 작으면
                            min = i + j; // 최소 거리 수정
                            for (int k = 0; k < size; k++) { // 행, 열 정보 배열 모든 원소 -1로 초기화
                                minRow[k] = -1;
                                minCol[k] = -1;
                            }
                            minRow[0] = i; // 첫 번째 원소에 행 정보 저장
                            minCol[0] = j; // 첫 번째 원소에 열 정보 저장
                        } else if (i + j == min) { // 현재 위치의 거리가 최소 거리와 같으면
                            for (int k = 0; k < size; k++) { // 행, 열 정보 배열에 행, 열 정보 저장
                                if (minRow[k] == -1) {
                                    minRow[k] = i;
                                    minCol[k] = j;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("추천 위치");
            for (int i = 0; i < size; i++) {
                if (minRow[i] != -1) { // 행, 열 정보가 저장된 곳이면
                    System.out.println(minRow[i] + " " + minCol[i]);
                }
            }
        } else { // 빈자리가 없으면
            System.out.println("빈 자리가 없습니다.");
        }
    }
}
