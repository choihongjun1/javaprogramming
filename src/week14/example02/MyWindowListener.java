package week14.example02;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener implements WindowListener {
    MainFrame frame;

    MyWindowListener(MainFrame f) {
        this.frame = f;
    }

    @Override
    public void windowOpened(WindowEvent e) {
//        JOptionPane.showMessageDialog(null, "환영합니다.");
        String name = JOptionPane.showInputDialog("닉네임을 입력하세요!");
        if (frame != null)
            frame.setTitle(name + "님 환영합니다.");
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
