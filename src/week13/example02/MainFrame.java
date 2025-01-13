package week13.example02;

import javax.swing.*;
import java.awt.*;

/**
 * 스윙
 */

public class MainFrame extends JFrame {
    Container frame = getContentPane();
    JPanel northPanel, centerPanel;

    public MainFrame(String title) {
        super(title);
//        this.setSize(500,500);
//        this.setLocation(500,500);
//        this.setLocationRelativeTo(null);

        Toolkit kit = getToolkit();
        var size = kit.getScreenSize();
        this.setSize(size.width / 2, size.height / 2);
        this.setLocation(size.width / 4, size.height / 4);

        var img = kit.getImage("img/char.png");
        this.setIconImage(img);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLayout();
        this.setVisible(true);
    }

    private void initLayout() {
        initNorthPanel();
        initCenterPanel();
    }

    private void initNorthPanel() {
        this.northPanel = new JPanel();
        this.northPanel.setLayout(new GridLayout(1, 3, 30, 10));
        this.northPanel.setBackground(Color.ORANGE);
        JButton red = new JButton("RED");
        red.addActionListener(e -> centerPanel.setBackground(Color.RED));
        JButton green = new JButton("GREEN");
        green.addActionListener(e -> centerPanel.setBackground(Color.GREEN));
        JButton blue = new JButton("BLUE");
        blue.addActionListener(e -> centerPanel.setBackground(Color.BLUE));
        this.northPanel.add(red);
        this.northPanel.add(green);
        this.northPanel.add(blue);
        frame.add(this.northPanel, BorderLayout.NORTH);
    }

    private void initCenterPanel() {
        this.centerPanel = new JPanel();
        this.centerPanel.setBackground(Color.RED);
        frame.add(this.centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("202411913 최홍준");
    }
}
