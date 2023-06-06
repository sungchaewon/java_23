import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SchoolPartTimeJobFrame {
    private JPanel panel;
    private JButton backButton;
    private JTextArea textArea;
    private JButton calculatorButton;
    private MainFrame mainFrame; // MainFrame
    private HourlyWageCalculator calculator;

    public SchoolPartTimeJobFrame(MainFrame mainFrame) {
        panel = new JPanel();
        panel.setLayout(null);

        Font font = new Font("SansSerif", Font.BOLD, 24); // font Style
        Font calfont = new Font("SansSerif", Font.ITALIC, 24);

        JLabel titleLabel = new JLabel("우리 학교 주변 모집 중인 아르바이트! (출처: 알바천국)"); //PartTimeJob introduce
        titleLabel.setBounds(170, 10, 700,30);
        titleLabel.setForeground(Color.PINK);
        titleLabel.setFont(font);
        panel.add(titleLabel);

        JLabel calculateLabel = new JLabel("세후 시급 계산기"); //Calculator introduce
        calculateLabel.setBounds(1010, 10, 400,30);
        calculateLabel.setForeground(Color.ORANGE); //color orange
        calculateLabel.setFont(calfont);
        panel.add(calculateLabel);

        //Add a square box - scroll
        JPanel squarePanel = new JPanel(new BorderLayout());
        squarePanel.setBounds(100, 50, 700, 500);
        squarePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(squarePanel);

        //Add a square box 2
        JPanel squarePanel2 = new JPanel(new BorderLayout());
        squarePanel2.setBounds(100, 560, 700, 230);
        squarePanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(squarePanel2);

        // Create button to go to calculator when pressed
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


        //Create a panel to display a scrollable list
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());

        //Use GridBagConstraints to specify the location and size of the component.
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 2, 5, 2);

        //Creating a list of PartTimeJobs
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

        // Create a text field
        textArea = new JTextArea();
        squarePanel2.add(textArea, BorderLayout.CENTER);

        textArea.setForeground(Color.DARK_GRAY);
        textArea.setBackground(Color.lightGray);
        textArea.setFont(font);

        //Insert a list of bytes
        for (int i = 0; i < jobTitles.length; i++) {
            String jobTitle = jobTitles[i];
            JButton jobButton = new JButton(jobTitle);
            jobButton.setPreferredSize(new Dimension(500, 50));

            // Use the anchor of GridBagConstraints for vertical alignment.
            constraints.anchor = GridBagConstraints.NORTH;
            listPanel.add(jobButton, constraints);

            constraints.gridy++;

            final int index = i; // Saves the index as a final variable for use inside the ActionListener.

            jobButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Displays information about the button in a text field.
                    textArea.setText(" 알바 정보: " + jobTexts[index]);
                }
            });
        }


        // Makes the list scrollable.
        JScrollPane scrollPane = new JScrollPane(listPanel);
        squarePanel.add(scrollPane, BorderLayout.CENTER);

        scrollPane.setBounds(4, 4, 400, 192);

        // Add backButton
        backButton = new JButton("뒤로 가기");
        backButton.setBounds(1400, 730, 100,80);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showFunctionSelectionFrame();
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}