package week14.example01;

import javax.swing.*;
import java.awt.*;

/**
 * 레이아웃
 */

public class MainFrame2 extends JFrame {
    Container frame = getContentPane();
    JPanel westPanel, centerPanel;
    JLabel imgChar = new JLabel();
    ImageIcon img = new ImageIcon("img/char.png");
    int xpos = 150, ypos = 150;
    int delta = 10;

    public MainFrame2(String title) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initLayout();
        this.setVisible(true);
    }

    private void initLayout() {
        initWestPanel();
        initCenterPanel();
    }

    private void initCenterPanel() {
        this.centerPanel = new JPanel(null);
//        this.centerPanel.setLayout(null);
        this.imgChar.setIcon(img);
        this.imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight());
        this.centerPanel.add(imgChar);
        frame.add(centerPanel, BorderLayout.CENTER);
    }

    private void initWestPanel() {
        this.westPanel = new JPanel(new GridLayout(4, 1, 20, 20));
        JButton btn1 = new JButton("동");
        btn1.addActionListener(e -> {
            if (xpos <= (centerPanel.getWidth() - imgChar.getWidth() - delta)) {
                xpos += delta;
                imgChar.setLocation(xpos, ypos);
            }
        });
        JButton btn2 = new JButton("서");
        btn2.addActionListener(e -> {
            if (xpos >= delta) {
                xpos -= delta;
                imgChar.setLocation(xpos, ypos);
            }
        });
        JButton btn3 = new JButton("남");
        btn3.addActionListener(e -> {
            if (ypos <= (centerPanel.getHeight() - imgChar.getHeight() - delta)) {
                ypos += delta;
                imgChar.setLocation(xpos, ypos);
            }
        });
        JButton btn4 = new JButton("북");
        btn4.addActionListener(e -> {
            if (ypos >= delta) {
                ypos -= delta;
                imgChar.setLocation(xpos, ypos);
            }
        });
        westPanel.add(btn1);
        westPanel.add(btn2);
        westPanel.add(btn3);
        westPanel.add(btn4);
        frame.add(westPanel, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        new MainFrame2("202411913 최홍준");
    }
}
