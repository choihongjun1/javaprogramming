package subject02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 과제2
 * 프레임 클래스
 *
 * @author 최홍준
 * @since 2024-12-13
 */

public class MainFrame extends JFrame {
    String name; // 사용자 이름
    Container frame = getContentPane(); // 컨텐트패인
    JPanel northPanel, centerPanel; // 상단패널, 중앙패널
    JPanel menuPanel; // 메뉴 패널
    CardLayout cardLayout = new CardLayout();
    JLabel northLabel; // 상단 레이블

    VocManager2 manager;
    int n; // 주관식 문제수
    int n2; // 객관식 문제수
    int nn; // 객관식 보기수

    // 생성자
    public MainFrame(String name) {
        super(name + "의 단어장"); // 타이틀
        this.name = name;
        manager = new VocManager2(name);
        String msg = manager.run("files/quiz.txt"); // 단어장 생성
        n = manager.n;
        n2 = manager.n2;
        nn = manager.nn;
        this.setSize(750, 500); // 창크기
        this.setLocationRelativeTo(null); // 창 중앙정렬
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 창 닫으면 종료
        initLayout(); // 초기 레이아웃
        this.setVisible(true); // 창 보이기
        JOptionPane.showMessageDialog(this, msg); // 메세지 출력창
    }

    /**
     * 초기 레이아웃
     */
    private void initLayout() {
        initMenuPanel(); // 메뉴 패널 레이아웃
        initNorthPanel(); // 상단 패널 레이아웃
        initCenterPanel(); // 중앙 패널 레이아웃
    }

    /**
     * 메뉴패널 레이아웃
     */
    private void initMenuPanel() {
        menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // 패널 생성

        // 메뉴 버튼
        JButton btn1 = new JButton("주관식 퀴즈");
        JButton btn2 = new JButton("객관식 퀴즈");
        JButton btn3 = new JButton("오답노트");
        JButton btn4 = new JButton("단어검색");
        JButton btn5 = new JButton("종료");

        // 메뉴 버튼 클릭하면
        btn1.addActionListener(e -> quiz1());
        btn2.addActionListener(e -> quiz2());
        btn3.addActionListener(e -> wrongAnswer());
        btn4.addActionListener(e -> searchWord());
        btn5.addActionListener(e -> System.exit(0)); // 종료

        // 패널에 버튼 붙이기
        menuPanel.add(btn1);
        menuPanel.add(btn2);
        menuPanel.add(btn3);
        menuPanel.add(btn4);
        menuPanel.add(btn5);
    }

    /**
     * 상단패널 레이아웃
     */
    private void initNorthPanel() {
        northPanel = new JPanel(); // 패널 생성

        northLabel = new JLabel(name + "의 영단어 퀴즈"); // 상단 레이블 생성
        northPanel.add(northLabel); // 패널에 레이블 붙이기

        this.frame.add(northPanel, BorderLayout.NORTH); // 프레임에 패널 붙이기
    }

    /**
     * 중앙패널 레이아웃
     */
    private void initCenterPanel() {
        centerPanel = new JPanel(cardLayout); // 패널 생성

        centerPanel.add(menuPanel, "menu"); // 패널에 메뉴패널 카드 추가

        this.frame.add(centerPanel, BorderLayout.CENTER); // 프레임에 패널 붙이기
    }

    /**
     * 주관식 퀴즈
     */
    private void quiz1() {
        northLabel.setText("주관식 퀴즈"); // 상단 패널 텍스트 변경
        List<Integer> list = new ArrayList<>(); // 정답수 카운트 리스트

        List<Word> qList = manager.getQList(); // 문제 리스트

        long startTime = System.nanoTime(); // 시작 시간
        for (int i = 0; i < n; i++) {
            Word w = qList.get(i); // 정답 객체
            List<Word> oList = manager.getOList(w); // 정답 리스트

            JPanel card = new JPanel(null); // 문제패널 카드 생성

            JLabel la = new JLabel((i + 1) + ". \"" + w.kor + "\" 단어의 뜻을 가진 영어단어는 무엇일까요?"); // 레이블 생성
            la.setLocation(200, 50);
            la.setSize(400, 20);

            JButton btn; // 다음 문제 이동 버튼
            if (i != n - 1) {
                btn = new JButton("다음");
            } else { // 마지막 문제이면
                btn = new JButton("메뉴");
            }
            btn.setLocation(300, 180);
            btn.setSize(100, 30);
            // 버튼 클릭 시
            if (i != n - 1) {
                btn.addActionListener(e -> cardLayout.next(centerPanel)); // 다음문제 카드
            } else { // 마지막 문제이면
                btn.addActionListener(e -> {
                    cardLayout.show(centerPanel, "menu"); // 메뉴패널 카드 보이기
                    northLabel.setText(name + "의 영단어 퀴즈"); // 상단 레이블 텍스트 변경
                });
            }
            btn.setVisible(false); // 버튼 보이지 않게

            JTextField tf = new JTextField(20); // 정답 입력창
            tf.setLocation(250, 80);
            tf.setSize(200, 20);
            // 답 입력 후 엔터 누를 시
            if (i != n - 1) {
                tf.addActionListener(e -> {
                    if (manager != null) {
                        btn.setVisible(true); // 버튼 보이기
                        tf.setEditable(false); // 편집 불가
                        if (oList.contains(new Word(tf.getText(), ""))) { // 입력한 답이 정답리스트에 있으면
                            JLabel label = new JLabel("정답입니다."); // 레이블 생성
                            label.setLocation(200, 120);
                            label.setSize(300, 20);
                            card.add(label); // 문제패널 카드에 붙이기
                            list.add(1); // 정답수 증가
                        } else { // 오답이면
                            if (oList.size() == 1) {
                                JLabel label = new JLabel("틀렸습니다. 정답은 " + w.eng + "입니다."); // 레이블 생성
                                label.setLocation(200, 120);
                                label.setSize(300, 20);
                                card.add(label); // 문제패널 카드에 붙이기
                                w.wrongCount++; // 단어 오답횟수 증가
                            } else { // 한글 뜻 중복 단어 있으면
                                String str = "틀렸습니다. 정답은 ";
                                for (int j = 0; j < oList.size(); j++) {
                                    Word ww = oList.get(j);
                                    if (j != oList.size() - 1) {
                                        str += ww.eng + " 또는 ";
                                    } else {
                                        str += ww.eng;
                                    }
                                    ww.wrongCount++; // 단어 오답횟수 증가
                                }
                                str += "입니다.";
                                JLabel label = new JLabel(str); // 레이블 생성
                                label.setLocation(200, 120);
                                label.setSize(2000, 20);
                                card.add(label); // 문제패널 카드에 붙이기
                            }
                        }
                        card.revalidate(); // 레이아웃 갱신
                        card.repaint(); // 다시 그리기
                    }
                });
            } else { // 마지막 문제이면
                tf.addActionListener(e -> {
                    if (manager != null) {
                        btn.setVisible(true); // 버튼 보이기
                        tf.setEditable(false); // 편집 불가
                        if (oList.contains(new Word(tf.getText(), ""))) { // 입력한 답이 정답리스트에 있으면
                            JLabel label = new JLabel("정답입니다."); // 레이블 생성
                            label.setLocation(200, 120);
                            label.setSize(300, 20);
                            card.add(label); // 문제패널 카드에 붙이기
                            list.add(1); // 정답수 증가
                        } else { // 오답이면
                            if (oList.size() == 1) {
                                JLabel label = new JLabel("틀렸습니다. 정답은 " + w.eng + "입니다."); // 레이블 생성
                                label.setLocation(200, 120);
                                label.setSize(300, 20);
                                card.add(label); // 문제패널 카드에 붙이기
                                w.wrongCount++; // 단어 오답횟수 증가
                            } else { // 한글 뜻 중복 단어 있으면
                                String str = "틀렸습니다. 정답은 ";
                                for (int j = 0; j < oList.size(); j++) {
                                    Word ww = oList.get(j);
                                    if (j != oList.size() - 1) {
                                        str += ww.eng + " 또는 ";
                                    } else {
                                        str += ww.eng;
                                    }
                                    ww.wrongCount++; // 단어 오답횟수 증가
                                }
                                str += "입니다.";
                                JLabel label = new JLabel(str); // 레이블 생성
                                label.setLocation(200, 120);
                                label.setSize(2000, 20);
                                card.add(label); // // 문제패널 카드에 붙이기
                            }
                        }
                        long endTime = System.nanoTime(); // 끝시간
                        long t = (endTime - startTime) / 1000000000; // 걸린시간
                        JLabel label = new JLabel(name + "님 " + n + "문제 중 " + list.size() + "개 맞추셨고, 총 " + t + "초 소요되었습니다."); // 레이블 생성
                        label.setLocation(200, 150);
                        label.setSize(400, 20);
                        card.add(label); // 문제패널 카드에 붙이기
                        card.revalidate(); // 레이아웃 갱신
                        card.repaint(); // 다시 그리기
                    }
                });
            }
            // 문제패널에 붙이기
            card.add(la);
            card.add(tf);
            card.add(btn);

            centerPanel.add(card, String.valueOf(i + 1)); // 중앙 패널에 문제패널 카드 붙이기
        }
        cardLayout.show(centerPanel, "1"); // 첫 문제 보이기
    }

    /**
     * 객관식퀴즈
     */
    private void quiz2() {
        List<Integer> list = new ArrayList<>(); // 정답수 카운트 리스트

        northLabel.setText("객관식 퀴즈"); // 상단 레이블 텍스트 변경

        List<Word> qList = manager.getQList2(); // 문제 리스트

        long startTime = System.nanoTime(); // 시작시간
        for (int i = 0; i < n2; i++) {
            Word w = qList.get(i); // 정답 객체
            w.appearCount++; // 단어 출현횟수 증가

            List<Word> optionList = manager.getOptionList(w); // 보기 리스트

            Collections.shuffle(optionList); // 섞기
            int oNum = optionList.indexOf(w) + 1; // 정답번호

            JPanel card = new JPanel(null); // 문제패널 카드 생성

            JLabel la = new JLabel((i + 1) + ". \"" + w.eng + "\"의 뜻은 무엇일까요?"); // 레이블 생성
            la.setLocation(250, 50);
            la.setSize(400, 20);
            card.add(la); // 문제패널 카드에 붙이기

            // 다음문제 이동 버튼
            JButton btn;
            if (i != n2 - 1) {
                btn = new JButton("다음");
            } else { // 마지막 문제이면
                btn = new JButton("메뉴");
            }
            btn.setLocation(250, 250);
            btn.setSize(100, 30);
            // 버튼 클릭 시
            if (i != n2 - 1) {
                btn.addActionListener(e -> cardLayout.next(centerPanel)); // 다음 문제
            } else { // 마지막 문제이면
                btn.addActionListener(e -> {
                    cardLayout.show(centerPanel, "menu"); // 메뉴패널 카드 보이기
                    northLabel.setText(name + "의 영단어 퀴즈"); // 상단 레이블 텍스트 변경
                });
            }
            btn.setVisible(false); // 버튼 보이지 않게
            card.add(btn); // 문제패널 카드에 붙이기

            JPanel p = new JPanel(new GridLayout(nn, 1)); // 보기 패널 생성
            ButtonGroup group = new ButtonGroup(); // 버튼 그룹 생성
            JRadioButton[] rbtns = new JRadioButton[nn]; // 라디오버튼 배열
            for (int j = 0; j < nn; j++) {
                JRadioButton rbtn = new JRadioButton((j + 1) + ". " + optionList.get(j).kor); // 문제 출력 라디오버튼
                group.add(rbtn); // 그룹에 라디오버튼 추가
                rbtns[j] = rbtn; // 배열에 라디오버튼 추가
                // 버튼 클릭 시
                if (i != n2 - 1) { // 마지막 문제 아니면
                    rbtn.addItemListener(e -> {
                        for (int k = 0; k < nn; k++) {
                            rbtns[k].setEnabled(false); // 모든 라디오 버튼 비활성화
                        }
                        btn.setVisible(true); // 다음문제 이동 버튼 보이기
                        if (e.getStateChange() == ItemEvent.SELECTED) { // 선택되면
                            if (Integer.parseInt(rbtn.getText().substring(0, 1)) == oNum) { // 정답이면
                                JLabel label = new JLabel("정답입니다."); // 레이블 생성
                                label.setLocation(250, 200);
                                label.setSize(300, 20);
                                card.add(label); // 문제패널 카드에 붙이기
                                list.add(1); // 정답수 증가
                            } else { // 오답이면
                                JLabel label = new JLabel("틀렸습니다. 정답은 " + oNum + "번 입니다."); // 레이블 생성
                                label.setLocation(250, 200);
                                label.setSize(300, 20);
                                card.add(label); // 문제패널 카드에 붙이기
                                w.wrongCount++; // 단어 오답횟수 증가
                            }
                            card.revalidate(); // 레이아웃 갱신
                            card.repaint(); // 다시 그리기
                        }
                    });
                } else { // 마지막 문제이면
                    rbtn.addItemListener(e -> {
                        for (int k = 0; k < nn; k++) {
                            rbtns[k].setEnabled(false); // 모든 라디오 버튼 비활성화
                        }
                        btn.setVisible(true); // 다음문제 이동 버튼 보이기
                        if (e.getStateChange() == ItemEvent.SELECTED) { // 선택되면
                            if (Integer.parseInt(rbtn.getText().substring(0, 1)) == oNum) { // 정답이면
                                JLabel label = new JLabel("정답입니다."); // 레이블 생성
                                label.setLocation(250, 200);
                                label.setSize(300, 20);
                                card.add(label); // 문제패널 카드에 붙이기
                                list.add(1); // 정답수 증가
                            } else { // 오답이면
                                JLabel label = new JLabel("틀렸습니다. 정답은 " + oNum + "번 입니다."); // 레이블 생성
                                label.setLocation(250, 200);
                                label.setSize(300, 20);
                                card.add(label); // 문제패널 카드에 붙이기
                                w.wrongCount++; // 단어 오답횟수 증가
                            }
                            long endTime = System.nanoTime(); // 끝시간
                            long t = (endTime - startTime) / 1000000000; // 걸린시간
                            JLabel label = new JLabel(name + "님 " + n + "문제 중 " + list.size() + "개 맞추셨고, 총 " + t + "초 소요되었습니다."); // 레이블 생성
                            label.setLocation(250, 220);
                            label.setSize(400, 20);
                            card.add(label); // 문제패널 카드에 붙이기
                            card.revalidate(); // 레이아웃 갱신
                            card.repaint(); // 다시 그리기
                        }
                    });
                }
                p.add(rbtn); // 보기패널에 라디오버튼 붙이기
            }
            p.setLocation(250, 80);
            p.setSize(1000, 100);
            card.add(p); // 문제패널 카드에 보기패널 붙이기

            centerPanel.add(card, String.valueOf(i + n + 1)); // 중앙패널에 문제패널 카드 붙이기
        }
        cardLayout.show(centerPanel, String.valueOf(n + 1)); // 첫문제 보이기
    }

    /**
     * 오답노트
     */
    private void wrongAnswer() {
        northLabel.setText("오답노트"); // 상단 레이블 텍스트 변경

        JPanel card = new JPanel(null); // 오답노트 패널 카드 생성

        JTextArea textArea = new JTextArea(manager.wrongAnswer()); // 오답노트 출력 텍스트 에어리어 생성
        textArea.setEditable(false); // 편집 불가

        JScrollPane scrollPane = new JScrollPane(textArea); // 스크롤패인 생성
        scrollPane.setLocation(70, 20);
        scrollPane.setSize(600, 350);
        card.add(scrollPane); // 오답노트 패널 카드에 스크롤패인 붙이기

        JButton btn = new JButton("메뉴"); // 메뉴 이동 버튼
        // 버튼 클릭 시
        btn.addActionListener(e -> {
            northLabel.setText(name + "의 영단어 퀴즈"); // 상단 레이블 텍스트 변경
            cardLayout.show(centerPanel, "menu"); // 메뉴 패널 카드로 보이기
        });
        btn.setLocation(330, 380);
        btn.setSize(60, 30);
        card.add(btn); // 오답노트 패널 카드에 메뉴 이동 버튼 추가

        centerPanel.add(card, "wrongAnswer"); // 중앙 패널에 오답노트 패널 카드 붙이기
        cardLayout.show(centerPanel, "wrongAnswer"); // 오답노트 패널 카드 보이기
    }

    /**
     * 단어검색
     */
    private void searchWord() {
        northLabel.setText("단어검색"); // 상단 레이블 텍스트 변경

        JPanel card = new JPanel(null); // 단어검색 패널 카드 생성

        JTextField tf = new JTextField(20); // 검색 텍스트 필드 생성
        tf.setLocation(250, 30);
        tf.setSize(200, 30);
        card.add(tf); // 단어검색 패널 카드에 검색 텍스트 필드 붙이기

        JTextArea ta = new JTextArea(); // 검색결과 텍스트 에어리어 생성
        ta.setEditable(false); // 편집불가

        JButton sbtn = new JButton("검색"); // 검색 버튼 생성
        sbtn.setLocation(470, 30);
        sbtn.setSize(60, 30);
        // 버튼 클릭 시
        sbtn.addActionListener(e -> {
            String str = manager.searchWord(tf.getText()); // 단어검색
            ta.setText(str); // 텍스트 에어리어에 검색결과 보이기
        });
        card.add(sbtn); // 단어검색 패널 카드에 검색 버튼 붙이기

        JScrollPane scrollPane = new JScrollPane(ta); // 스크롤패인 생성
        scrollPane.setLocation(150, 80);
        scrollPane.setSize(400, 200);
        card.add(scrollPane); // 단어검색 패널 카드에 스크롤패인 붙이기

        JButton btn = new JButton("메뉴"); // 메뉴 이동 버튼 생성
        btn.setLocation(330, 300);
        btn.setSize(60, 30);
        // 버튼 클릭 시
        btn.addActionListener(e -> {
            northLabel.setText(name + "의 영단어 퀴즈"); // 상단 레이블 텍스트 변경
            cardLayout.show(centerPanel, "menu"); // 메뉴 패널 카드 보이기
        });
        card.add(btn); // 단어검색 패널 카드에 메뉴 이동 버튼 붙이기

        centerPanel.add(card, "searchWord"); // 중앙 패널에 단어검색 패널 카드 붙이기

        cardLayout.show(centerPanel, "searchWord"); // 단어검색 패널 카드 보이기
    }
}