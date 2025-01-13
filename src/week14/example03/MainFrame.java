package week14.example03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 이벤트 처리
 */

public class MainFrame extends JFrame {
    Container frame = getContentPane();
    String[] imgPath = {"img/Down.png", "img/Left.png", "img/Right.png", "img/Up.png"};
    ImageIcon[] icons;
    JLabel player;
    int imgWidth, imgHeight;
    Point pos = new Point(100, 100);

    public MainFrame(String title) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initLayout();
        this.setVisible(true);
    }

    private void initLayout() {
        this.frame.setLayout(null);
        this.icons = new ImageIcon[imgPath.length];
        for (int i = 0; i < icons.length; i++) {
            this.icons[i] = new ImageIcon(imgPath[i]);
        }
        this.imgWidth = icons[0].getIconWidth();
        this.imgHeight = icons[0].getIconHeight();

        this.player = new JLabel(icons[0]);
        this.player.setSize(imgWidth, imgHeight);
        this.player.setLocation(pos);

        this.frame.add(player);
        this.frame.setBackground(Color.WHITE);

        initKeyListener();
        initMouseListener();
    }

    private void initMouseListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setSize(500, 500);
                frame.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setSize(300, 300);
                frame.setBackground(Color.ORANGE);
            }
        });
    }

    private void initKeyListener() {
        this.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                super.keyTyped(e);
//                switch (e.getKeyChar()) {
//                    case 'd' -> {
//                        pos.y += 10;
//                        player.setIcon(icons[0]);
//                    }
//                    case 'a' -> {
//                        pos.x -= 10;
//                        player.setIcon(icons[1]);
//                    }
//                    case 'f' -> {
//                        pos.x += 10;
//                        player.setIcon(icons[2]);
//                    }
//                    case 's' -> {
//                        pos.y -= 10;
//                        player.setIcon(icons[3]);
//                    }
//                }
//                player.setLocation(pos);
//            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN -> {
                        pos.y += 10;
                        player.setIcon(icons[0]);
                    }
                    case KeyEvent.VK_LEFT -> {
                        pos.x -= 10;
                        player.setIcon(icons[1]);
                    }
                    case KeyEvent.VK_RIGHT -> {
                        pos.x += 10;
                        player.setIcon(icons[2]);
                    }
                    case KeyEvent.VK_UP -> {
                        pos.y -= 10;
                        player.setIcon(icons[3]);
                    }
                }

                switch (e.getKeyChar()) {
                    case 'd' -> {
                        pos.y += 10;
                        player.setIcon(icons[0]);
                    }
                    case 'a' -> {
                        pos.x -= 10;
                        player.setIcon(icons[1]);
                    }
                    case 'f' -> {
                        pos.x += 10;
                        player.setIcon(icons[2]);
                    }
                    case 's' -> {
                        pos.y -= 10;
                        player.setIcon(icons[3]);
                    }
                }
                player.setLocation(pos);
            }
        });
    }

    public static void main(String[] args) {
        new MainFrame("202411913 최홍준");
    }
}
