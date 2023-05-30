import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HourlyWageCalculator extends JFrame {
    public JTextField hourlyRateField; // 시급 입력 필드
    public JTextField hoursWorkedField; // 총 근무 시간 입력 필드
    public JButton eraseButton; // 초기화 버튼
    public JButton[] numberButtons; // 숫자 버튼 배열
    public StringBuilder inputStringBuilder; // 입력된 숫자를 저장하는 문자열
    public boolean hourlyRateInputMode; // 시급 입력 모드 여부
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    public HourlyWageCalculator() {
        setTitle("시급 계산기"); // 프레임 제목 설정
        setSize(600, 600); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정

        setLayout(new BorderLayout()); // BorderLayout 설정
        p1.setLayout(new GridLayout(2, 2)); // 입력 받는 값 GridLayout 설정
        p2.setLayout(new GridLayout(4, 3)); // 버튼 GridLayout 설정
        p3.setLayout(new GridLayout(2, 1)); // 안내 문구 GridLayout 설정

        JLabel hourlyRateLabel = new JLabel("시급 (원): "); // 시급 라벨 생성
        JLabel hoursWorkedLabel = new JLabel("총 근무 시간: "); // 총 근무 시간 라벨 생성
        JLabel taxRateLabel = new JLabel("세금: 3.3%"); // 세금 라벨 생성
        JLabel taxRateLabel2 = new JLabel("*시급을 입력하신 후 입력창을 클릭하고 Enter키를 누르시면 총 근무 시간을 입력하실 수 있습니다."); // 안내 문구 라벨 생성

        hourlyRateField = new JTextField(); // 시급 입력 필드 생성
        hoursWorkedField = new JTextField(); // 총 근무시간 입력 필드 생성
        inputStringBuilder = new StringBuilder(); // 입력된 숫자를 저장하는 문자열 생성
        hourlyRateInputMode = true; // 시급 입력 모드 초기화

        eraseButton = new JButton("초기화"); // 초기화 버튼 생성
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseInput();
            }
        });

        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++) {
            final int number = i;
            numberButtons[i] = new JButton(Integer.toString(i)); // 숫자 버튼 생성
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addNumber(number);
                }
            });
        }

        JButton calculateButton = new JButton("계산하기"); // 계산하기 버튼 생성
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWage();
            }
        });

        p1.add(hourlyRateLabel); // 시급 라벨 추가
        p1.add(hourlyRateField); // 시급 입력 필드 추가

        p1.add(hoursWorkedLabel); // 총 근무시간 라벨 추가
        p1.add(hoursWorkedField); // 시급 입력 필드 추가

        for (int i = 7; i <= 9; i++) {
            p2.add(numberButtons[i]); // 숫자 버튼 추가(7~9)
        }

        for (int i = 4; i <= 6; i++) {
            p2.add(numberButtons[i]); // 숫자 버튼 추가(4~6)
        }

        for (int i = 1; i <= 3; i++) {
            p2.add(numberButtons[i]); // 숫자 버튼 추가(1~3)
        }

        p2.add(eraseButton); // 초기화 버튼 추가
        p2.add(numberButtons[0]); // 숫자 0 버튼 추가
        p2.add(calculateButton); // 계산하기 버튼 추가

        p3.add(taxRateLabel); // 세율 문구 추가
        p3.add(taxRateLabel2); // 계산기 안내 문구 추가
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        hourlyRateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    hourlyRateField.setEnabled(false);
                    hoursWorkedField.setEnabled(true);
                    hoursWorkedField.requestFocus(); // 다음 텍스트 필드로 포커스 이동
                    hourlyRateInputMode = false;
                }
            }
        });

        hoursWorkedField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    hourlyRateField.setEnabled(true);
                    hourlyRateField.requestFocus(); // 시급 텍스트 필드로 포커스 이동
                    hourlyRateInputMode = true;
                }
            }
        });

        // 시급과 총 근무 시간 텍스트 필드의 세로 크기 조정
        hourlyRateField.setPreferredSize(new Dimension(hourlyRateField.getPreferredSize().width, 50));
        hoursWorkedField.setPreferredSize(new Dimension(hoursWorkedField.getPreferredSize().width, 50));

        setVisible(true);
    }

    public void calculateWage() {
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());
        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
        double wage = hourlyRate * hoursWorked;
        double taxRate = 3.3;
        double taxAmount = wage * (taxRate / 100);
        double netWage = wage - taxAmount;

        JOptionPane.showMessageDialog(this, "월급: " + wage + "원" + "\n세금 (3.3%): " + taxAmount + "원" + "\n세후 월급: " + netWage + "원", "계산 결과", JOptionPane.INFORMATION_MESSAGE);
    }

    public void eraseInput() {
        inputStringBuilder.setLength(0);
        if (hourlyRateInputMode) {
            hourlyRateField.setText("");
        } else {
            hoursWorkedField.setText("");
        }
    }

    public void addNumber(int number) {
        if (hourlyRateInputMode) {
            if (inputStringBuilder.length() == 0) {
                hourlyRateField.setText(""); // 이전 값 초기화
            }
            inputStringBuilder.append(number); // 숫자 추가
            hourlyRateField.setText(hourlyRateField.getText() + number); // 값을 이어서 표시
        } else {
            if (inputStringBuilder.length() == 0) {
                hoursWorkedField.setText(""); // 이전 값 초기화
            }
            inputStringBuilder.append(number); // 숫자 추가
            hoursWorkedField.setText(hoursWorkedField.getText() + number); // 값을 이어서 표시
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HourlyWageCalculator();
            }

        });
    }
}