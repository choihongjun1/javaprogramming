package week04.example01;

public class TV {
    public boolean power = false;
    public int channel = 7;
    final int MAX_CHANNEL = 10;
    final int MIN_CHANNEL = 0;
    int volume = 0;
    final int MAX_VOLUME = 20;
    final int MIN_VOLUME = 0;

    public void powerOnOff() {
        power = !power;
        showState();
    }

    public void channelUp() {
        if (power) {
            ++channel;
            if (channel > MAX_CHANNEL) {
                channel = MIN_CHANNEL;
            }
            showState();
        }
    }

    public void channelDown() {
        if (power) {
            --channel;
            if (channel < MIN_CHANNEL) {
                channel = MAX_CHANNEL;
            }
            showState();
        }
    }

    public void volumeUp() {
        if (power) {
            volume++;
            if (volume > MAX_VOLUME) {
                volume = MAX_VOLUME;
            }
        }
        showState();
    }

    public void volumeDown() {
        if (power) {
            volume--;
            if (volume < MIN_VOLUME) {
                volume = MIN_VOLUME;
            }
        }
        showState();
    }

    public void showState() {
        if (power) {
            System.out.println("채널 : " + channel);
            System.out.println("볼륨 : " + volume);
        } else {
            System.out.println("전원이 꺼져 있습니다.");
        }
    }
}
