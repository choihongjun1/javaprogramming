package week07.example02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 익명객체
 */

public class MyFrame extends JFrame {
    JButton btn1 = new JButton("이름");
    JButton btn2 = new JButton("학번");

    public MyFrame(String title) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(btn1);
        this.add(btn2);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MyFrame.this, "홍길동");
            }
        };
        btn1.addActionListener(listener);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MyFrame.this, "20000");
            }
        });
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame("학번 이름");
    }
}
