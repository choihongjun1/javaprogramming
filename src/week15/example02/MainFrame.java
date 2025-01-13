package week15.example02;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class MainFrame extends JFrame {
    VocManager vocManager;

    Container frame = getContentPane();
    JPanel northPanel;
    boolean flag = true;

    JTable table;
    DefaultTableModel model;
    String[] header = {"영단어", "뜻"};

    public MainFrame(String title, String filename) {
        super(title);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initLayout();
        this.setVisible(true);
        initVocManager(filename);
    }

    private void initVocManager(String filename) {
        this.vocManager = new VocManager("최홍준");
        String msg = this.vocManager.run(filename);
        JOptionPane.showMessageDialog(this, msg);
        initTableData();
    }

    private void initTableData() {
        if (vocManager != null && !vocManager.voc.isEmpty()) {
            List<Word> list = null;
            if (flag) {
                list = vocManager.voc.stream()
                        .sorted((o1, o2) -> o1.eng.compareTo(o2.eng))
                        .toList();
            } else {
                list = vocManager.voc.stream()
                        .sorted((o1, o2) -> o1.eng.compareTo(o2.eng) * -1)
                        .toList();
            }
            for (Word w : list) {
                model.addRow(new String[]{w.eng, w.kor});
            }
        }
    }

    private void initLayout() {
        initNorthPanel();
        initTable();
    }

    private void initTable() {
        this.model = new DefaultTableModel(header, 0);
        this.table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void initNorthPanel() {
        this.northPanel = new JPanel();

        this.northPanel.add(new JLabel("검색할 단어 "));
        JTextField text = new JTextField(10);
        text.addActionListener(e -> {
            if (vocManager != null) {
                Word w = vocManager.searchWord(text.getText());
                if (w != null) {
                    removeTableData();
                    model.addRow(new String[]{w.eng, w.kor});
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "단어를 찾을 수 없습니다.");
                }
            }
            text.setText("");
        });
        this.northPanel.add(text);

        JButton btn = new JButton("검색");
        btn.addActionListener(e -> {
            if (vocManager != null) {
                var list = vocManager.searchWord2(text.getText());
                if (!list.isEmpty()) {
                    removeTableData();
                    for (Word w : list)
                        model.addRow(new String[]{w.eng, w.kor});
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "단어를 찾을 수 없습니다.");
                }
            }
            text.setText("");
        });
        this.northPanel.add(btn);

        JRadioButton asc = new JRadioButton("Asc");
        asc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    flag = true;
                    removeTableData();
                    initTableData();
                }
            }
        });
        asc.setSelected(true);

        JRadioButton desc = new JRadioButton("Desc");
        desc.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                flag = false;
                removeTableData();
                initTableData();
            }
        });
        this.northPanel.add(asc);
        this.northPanel.add(desc);

        ButtonGroup group = new ButtonGroup();
        group.add(asc);
        group.add(desc);

        frame.add(northPanel, BorderLayout.NORTH);
    }

    private void removeTableData() {
        if (model != null && model.getRowCount() > 0) {
            model = new DefaultTableModel(header, 0);
            table.setModel(model);
        }
    }

    public static void main(String[] args) {
        new MainFrame("202411913 최홍준", "files/words.txt");
    }
}
