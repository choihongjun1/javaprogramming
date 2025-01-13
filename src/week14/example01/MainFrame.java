package week14.example01;

import javax.swing.*;
import java.awt.*;

/**
 * 레이아웃
 */

public class MainFrame extends JFrame {
    Container frame = getContentPane();
    JPanel northPanel, centerPanel;
    Color[] colors = {Color.RED, Color.GRAY, Color.GREEN, Color.ORANGE, Color.CYAN};

    CardLayout cardLayout = new CardLayout();

    public MainFrame(String title) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initLayout();
        this.setVisible(true);
    }

    private void initLayout() {
        initNorthPanel();
        initCenterPanel();
    }

    private void initCenterPanel() {
        this.centerPanel = new JPanel(cardLayout);
        for (int i = 0; i < colors.length; i++) {
            JPanel card = new JPanel();
            card.setBackground(colors[i]);
            this.centerPanel.add(card, String.valueOf(i));
        }
        cardLayout.show(centerPanel, "2");
        frame.add(centerPanel, BorderLayout.CENTER);
    }

    private void initNorthPanel() {
        this.northPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        JButton btn1 = new JButton("<<");
        btn1.addActionListener(e -> cardLayout.previous(centerPanel));
        JButton btn2 = new JButton("Home");
        btn2.addActionListener(e -> cardLayout.show(centerPanel, "2"));
        JButton btn3 = new JButton(">>");
        btn3.addActionListener(e -> cardLayout.next(centerPanel));
        this.northPanel.add(btn1);
        this.northPanel.add(btn2);
        this.northPanel.add(btn3);
        frame.add(northPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new MainFrame("202411913 최홍준");
    }
}
