package week06.lab01;

/**
 * 06주차 실습
 *
 * @author 최홍준
 * @since 2024-10-11
 */

public abstract class HomeAppliance {
    protected String haName;
    protected boolean haPower = false;

    public HomeAppliance(String haName) {
        this.haName = haName;
    }

    public String getHaName() {
        return haName;
    }

    public boolean isHaPower() {
        return haPower;
    }

    public void setHaName(String haName) {
        this.haName = haName;
    }

    public void setHaPower(boolean haPower) {
        this.haPower = haPower;
    }

    public abstract void showStatus();

    public abstract void menu();
}
