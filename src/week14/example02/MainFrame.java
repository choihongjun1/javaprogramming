package week14.example02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 이벤트 처리
 */

public class MainFrame extends JFrame implements WindowListener {
    public MainFrame(String title) {
        super(title);
        this.setSize(500, 500);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initLayout();
        this.setVisible(true);
    }

    private void initLayout() {
//        this.addWindowListener(new MyWindowListener(this));
//        this.addWindowListener(new MyWindowAdapter(this));
//        this.addWindowListener(new MyWindowAdapter2());
        this.addWindowListener(this);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new MainFrame("202411913 최홍준");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        String name = JOptionPane.showInputDialog("닉네임을 입력하세요!");
        setTitle(name + "님 환영합니다.");
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

    public class MyWindowAdapter2 extends WindowAdapter {
        @Override
        public void windowOpened(WindowEvent e) {
            String name = JOptionPane.showInputDialog("닉네임을 입력하세요!");
            setTitle(name + "님 환영합니다.");
        }
    }
}
