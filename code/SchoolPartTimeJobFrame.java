import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SchoolPartTimeJobFrame {
    private JPanel panel;
    private JButton backButton;
    private JTextArea textArea;
    private JButton calculatorButton; // 계산기 버튼 추가
    private MainFrame mainFrame; // MainFrame과의 연결 추가
    private HourlyWageCalculator calculator;

    public SchoolPartTimeJobFrame(MainFrame mainFrame) {
        panel = new JPanel();
        panel.setLayout(null);

        Font font = new Font("SansSerif", Font.BOLD, 24); // 16은 원하는 글자 크기입니다.
        Font calfont = new Font("SansSerif", Font.ITALIC, 24);

        JLabel titleLabel = new JLabel("우리 학교 주변 모집 중인 아르바이트!!");
        titleLabel.setBounds(250, 10, 400,30);
        titleLabel.setForeground(Color.PINK);
        titleLabel.setFont(font);
        panel.add(titleLabel);

        JLabel calculateLabel = new JLabel("세후 시급 계산기");
        calculateLabel.setBounds(1010, 10, 400,30);
        calculateLabel.setForeground(Color.ORANGE);
        calculateLabel.setFont(calfont);
        panel.add(calculateLabel);

        // 정사각형으로 칸 추가
        JPanel squarePanel = new JPanel(new BorderLayout());
        squarePanel.setBounds(100, 50, 700, 500);
        squarePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(squarePanel);

        // 정사각형으로 칸 추가 2
        JPanel squarePanel2 = new JPanel(new BorderLayout());
        squarePanel2.setBounds(100, 560, 700, 230);
        squarePanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(squarePanel2);

        // 계산기 버튼 생성
        calculatorButton = new JButton(new ImageIcon("..//images//calculate.png"));
        calculatorButton.setBounds(810, 50, 570, 750);
        panel.add(calculatorButton);

        calculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculator == null) {
                    calculator = new HourlyWageCalculator();
                }
                calculator.setVisible(true);
            }
        });


        // 스크롤 가능한 목록을 표시할 패널 생성
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());

        // GridBagConstraints를 사용하여 컴포넌트의 위치와 크기를 지정합니다.
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 2, 5, 2);

        // 알바 목록 생성
        String[] jobTitles = {"GS25 청파제일점", "설빙 숙대점", "엘마레", "나폴리키친", "아마스빈 숙대점", "노랑통닭 숙대점", "공차 숙명여대점", "우주라이크 커피", "컴포즈커피 숙명여대점", "GS 서울역 1호점"};
        String[] jobTexts = {
                "GS25 청파제일점\n 근무요일: 토,일\n 급여: 시급 11,000원\n 근무기간: 6개월~1년\n 근무시간: 22:00~06:00\n 모집인원: 1명\n 전화번호: 010-34*7-1**4",
                "설빙\n 근무요일: 요일 협의\n 급여: 시급 10,000원\n 근무기간: 3개월~6개월\n 근무시간: 시간협의\n 모집인원: 1명\n 전화번호: 010-65*7-12**",
                "엘마레\n 근무요일: 토,일\n 급여: 시급 10,000원\n 근무기간: 1년 이상\n 근무시간: 18:00~22:00(협의 가능)\n 모집인원: 1명\n 전화번호: 010-22*7-56*9",
                "나폴리키친 \n 근무요일: 토,일\n 급여: 시급 10,000원\n 근무기간: 3개월~6개월\n 근무시간: 11:00~16:00\n 모집인원: 10명 미만\n 전화번호: 010-04*2-6**2",
                "아마스빈 \n 근무요일: 토,일\n 급여: 시급 9,620원\n 근무기간: 3개월~6개월(협의 가능)\n 근무시간: 16:00~22:00(휴게시간 30분)\n 모집인원: 10명 미만 \n 전화번호: 010-87*7-8**9",
                "노랑통닭 홀 알바(단기 알바)\n 근무요일: 6월 10일~ 6월 11일\n 급여: 시급 10,000원\n 근무기간: 2일\n 근무시간: 18:00~23:00\n 모집인원: 1명 \n 전화번호: 010-66*4-3**7",
                "공차 \n 근무요일: 요일 협의\n 급여: 시급 9,620원\n 근무기간: 3개월~6개월\n 근무시간: 시간협의\n 모집인원: 10명 미만\n 전화번호: 010-78*7-1*54",
                "우주라이크커피 \n 근무요일: 월,화,수,목,금(협의 가능)\n 급여: 시급 10,000원\n 근무기간: 3개월~6개월\n 근무시간: 12:00~15:00\n 모집인원: 1명\n 전화번호: 010-80*3-5**9",
                "컴포즈\n 근무요일: 토,일\n 급여: 시급 10,000원\n 근무기간: 3개월~6개월\n 근무시간: 시간협의(5시간씩 총 10시간 근무)\n 모집인원: 2명\n 전화번호: 010-26*7-8**2",
                "GS 서울역 1호점\n 근무요일: 주 2일\n 급여: 시급 10000원\n 근무기간: 1년 이상\n 근무시간: 17:00~00:00\n 모집인원: 1명\n 전화번호: 010-86*7-1**9"};

        textArea = new JTextArea();
        squarePanel2.add(textArea, BorderLayout.CENTER);

        textArea.setForeground(Color.DARK_GRAY);
        textArea.setBackground(Color.lightGray);
        textArea.setFont(font);

        // 알바 목록 생성
        for (int i = 0; i < jobTitles.length; i++) {
            String jobTitle = jobTitles[i];
            JButton jobButton = new JButton(jobTitle);
            jobButton.setPreferredSize(new Dimension(500, 50));

            // 세로 정렬을 위해 GridBagConstraints의 anchor를 사용합니다.
            constraints.anchor = GridBagConstraints.NORTH;
            listPanel.add(jobButton, constraints);

            constraints.gridy++;

            final int index = i; // 인덱스를 final 변수로 저장하여 ActionListener 내부에서 사용할 수 있도록 합니다.

            jobButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 버튼에 대한 정보를 텍스트 필드에 표시합니다.
                    textArea.setText(" 알바 정보: " + jobTexts[index]);

                    // 여기에서 해당 버튼에 대한 추가적인 작업을 수행할 수 있습니다.
                    // 예: 버튼을 눌렀을 때 해당 알바에 지원하기, 상세 정보 보기 등
                }
            });
        }


        // 목록을 스크롤 가능하게 만듭니다.
        JScrollPane scrollPane = new JScrollPane(listPanel);
        squarePanel.add(scrollPane, BorderLayout.CENTER);

        scrollPane.setBounds(4, 4, 400, 192);

        // backButton 추가
        backButton = new JButton("뒤로 가기");
        backButton.setBounds(1400, 730, 100,80);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showFunctionSelectionFrame();
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        // 텍스트 필드 생성

    }

    public JPanel getPanel() {
        return panel;
    }
}
