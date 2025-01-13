package week15.example01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 컴포넌트, 메뉴, 툴바
 */

public class MainFrame extends JFrame implements ActionListener, ItemListener {
    Container frame = getContentPane();

    String[] fontTypeArr = {"바탕체", "돋움체", "굴림체", "궁서체"};
    JComboBox<String> fontTypeCB = new JComboBox<>(fontTypeArr);
    String fontType = "궁서체";
    Integer[] fontSizeArr = {10, 14, 16, 18, 20, 24, 26};
    JComboBox<Integer> fontSizeCB = new JComboBox<>(fontSizeArr);
    int fontSize = 20;

    JCheckBox boldCheck = new JCheckBox("Bold");
    boolean bold = false;
    JCheckBox italicCheck = new JCheckBox("Italic");
    boolean italic = false;
    JTextField textField = new JTextField(15);
    JLabel label = new JLabel("202411913 최홍준", SwingConstants.CENTER);
    Font font = new Font(fontType, Font.PLAIN, fontSize);

    JPanel northPanel = new JPanel();

    public MainFrame(String title) {
        super(title);
        setLocationRelativeTo(null);
        setLocation(300, 300);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initLayout();
        initListener();
        initMenu();
        initToolbar();
        setVisible(true);
    }

    private void initToolbar() {
        JToolBar toolBar = new JToolBar("글자모양");
        for (String s : fontTypeArr) {
            JButton btn = new JButton(s);
            btn.addActionListener(this);
            toolBar.add(btn);
        }

        toolBar.addSeparator();
        JButton btn1 = new JButton("Small");
        btn1.setActionCommand("10");
        btn1.addActionListener(this);
        toolBar.add(btn1);
        JButton btn2 = new JButton("Large");
        btn2.setActionCommand("24");
        btn2.addActionListener(this);
        toolBar.add(btn2);

        frame.add(toolBar, BorderLayout.SOUTH);
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("글자체");
        for (String s : fontTypeArr) {
            JMenuItem item = new JMenuItem(s);
            item.addActionListener(this);
            menu1.add(item);
        }
        menuBar.add(menu1);
        JMenu menu2 = new JMenu("글자크기");
        for (int i : fontSizeArr) {
            JMenuItem item = new JMenuItem(String.valueOf(i));
            item.addActionListener(this);
            menu2.add(item);
        }
        menu1.add(menu2);
//        menuBar.add(menu2);
        this.setJMenuBar(menuBar);
    }

    private void initLayout() {
        this.fontTypeCB.setSelectedIndex(3);
        this.fontSizeCB.setSelectedIndex(4);
        label.setFont(font);
        frame.add(this.label, BorderLayout.CENTER);

        this.northPanel.add(this.fontTypeCB);
        this.northPanel.add(this.fontSizeCB);
        this.northPanel.add(this.boldCheck);
        this.northPanel.add(this.italicCheck);
        this.northPanel.add(this.textField);
        frame.add(this.northPanel, BorderLayout.NORTH);
    }

    private void initListener() {
        this.fontTypeCB.addActionListener(this);
        this.fontSizeCB.addActionListener(this);
        this.textField.addActionListener(this);
        this.boldCheck.addItemListener(this);
        this.italicCheck.addItemListener(this);
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame("202411913 최홍준");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "바탕체" -> fontType = "바탕체";
            case "굴림체" -> fontType = "굴림체";
            case "돋움체" -> fontType = "돋움체";
            case "궁서체" -> fontType = "궁서체";
            case "10" -> fontSize = 10;
            case "14" -> fontSize = 14;
            case "20" -> fontSize = 20;
            case "24" -> fontSize = 24;
        }

        if (e.getSource() == textField) {
            this.label.setText(textField.getText());
            this.textField.setText("");
            return;
        } else if (e.getSource() == fontTypeCB) {
            int index = this.fontTypeCB.getSelectedIndex();
            fontType = fontTypeArr[index];
        } else if (e.getSource() == fontSizeCB) {
            fontSize = fontSizeArr[fontSizeCB.getSelectedIndex()];
        }
        setLabelFont();
    }

    private void setLabelFont() {
        if (bold && italic) {
            font = new Font(fontType, Font.BOLD | Font.ITALIC, fontSize);
        } else if (bold == true && italic == false) {
            font = new Font(fontType, Font.BOLD, fontSize);
        } else if (bold == false && italic == true) {
            font = new Font(fontType, Font.ITALIC, fontSize);
        } else {
            font = new Font(fontType, Font.PLAIN, fontSize);
        }
        label.setFont(font);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == boldCheck) {
            if (e.getStateChange() == ItemEvent.SELECTED)
                bold = true;
            else
                bold = false;
        } else {
            if (e.getStateChange() == ItemEvent.SELECTED)
                italic = true;
            else
                italic = false;
        }
        setLabelFont();
    }
}
