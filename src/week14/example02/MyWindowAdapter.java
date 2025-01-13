package week14.example02;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {
    MainFrame frame;

    MyWindowAdapter(MainFrame f) {
        this.frame = f;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        String name = JOptionPane.showInputDialog("닉네임을 입력하세요!");
        if (frame != null)
            frame.setTitle(name + "님 환영합니다.");
    }
}
