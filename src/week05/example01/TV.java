package week05.example01;

public class TV {
    public boolean power = false;
    public int channel = 7;
    final int MAX_CHANNEL = 10;
    final int MIN_CHANNEL = 0;
    int volume = 0;
    final int MAX_VOLUME = 20;
    final int MIN_VOLUME = 0;

    public TV(boolean p) {
        power = p;
    }

    public TV(boolean p, int c) {
        power = p;
        channel = c;
    }

    public TV(int c) {
        channel = c;
    }

    public TV() {

    }

    public TV(TV tv) {
        this(tv.power, tv.channel);
    }

    public void powerOnOff() {
        power = !power;
        showTV();
    }

    public void channelUp() {
        if (power) {
            ++channel;
            if (channel > MAX_CHANNEL) {
                channel = MIN_CHANNEL;
            }
            showTV();
        }
    }

    public void channelDown() {
        if (power) {
            --channel;
            if (channel < MIN_CHANNEL) {
                channel = MAX_CHANNEL;
            }
            showTV();
        }
    }

    public void volumeUp() {
        if (power) {
            volume++;
            if (volume > MAX_VOLUME) {
                volume = MAX_VOLUME;
            }
        }
        showTV();
    }

    public void volumeDown() {
        if (power) {
            volume--;
            if (volume < MIN_VOLUME) {
                volume = MIN_VOLUME;
            }
        }
        showTV();
    }

    public void showTV() {
        if (power) {
            System.out.println("전원 : " + power);
            System.out.println("채널 : " + channel);
            System.out.println("볼륨 : " + volume);
        } else {
            System.out.println("전원이 꺼져 있습니다.");
        }
    }
}
