import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HourlyWageCalculator extends JFrame {
    private JTextField hourlyRateField; //시급 입력 필드
    private JTextField hoursWorkedField; // 총 근무 시간 입력필드 
    private JButton eraseButton; // 초기화 버튼
    private JButton[] numberButtons; //숫자 버튼 배열 
    private StringBuilder inputStringBuilder; // 입력된 숫자 저장하는 문자열
    private boolean hourlyRateInputMode; // 시급 입력 모드 여부

    public HourlyWageCalculator() {
        setTitle("Hourly Wage Calculator"); //프레임 제목설정
        setSize(300, 200); // 프레임 크기 설정 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 동작설정 
        setLayout(new GridLayout(5, 3)); // 그리드 레이아웃 설정 

        JLabel hourlyRateLabel = new JLabel("시급 (원): "); //시급 레이블 생성 
        JLabel hoursWorkedLabel = new JLabel("총 근무 시간: "); //총 근무시간 레이블 생성 
        JLabel taxRateLabel = new JLabel("세금: 3.3%"); //세금 레이블 생성 

        hourlyRateField = new JTextField(); //시급 입력 필드 생성 
        hoursWorkedField = new JTextField(); // 총 근무시간 입력 필드 생성 
        inputStringBuilder = new StringBuilder(); //입력된 숫자를 저장하는 문자열 생성 
        hourlyRateInputMode = true; //시급입력 모드 초기화 

        eraseButton = new JButton("초기화"); //초기화 버튼생성 
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseInput();
            }
        });

        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++) {
            final int number = i;
            numberButtons[i] = new JButton(Integer.toString(i)); //숫자 버튼생성 
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addNumber(number);
                }
            });
        }

        JButton calculateButton = new JButton("계산하기"); //계산하기 버튼생성
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWage();
            }
        });

        add(hourlyRateLabel); //시급 레이블 추가
        add(hourlyRateField); //시급 입력 필드 추가
        add(hoursWorkedLabel); //총 근무시간 레이블 추가
        add(hoursWorkedField); //초기화 버튼 추가
        add(eraseButton);

        for (int i = 1; i < numberButtons.length; i++) {
            add(numberButtons[i]); //숫자버튼추가
        }

        // 숫자 0 버튼 생성 
        numberButtons[0] = new JButton("0");
        numberButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber(0);
            }
        });
        add(numberButtons[0]); //숫자 0버튼 추가
        add(taxRateLabel); //세금 레이블 추가 
        add(new JLabel()); //간격을 위한 빈 레이블 추가 
        add(calculateButton); //계산하기 버튼 추가 

        hourlyRateField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hourlyRateField.setEnabled(false);
                hoursWorkedField.setEnabled(true);
                hoursWorkedField.requestFocus();
                hourlyRateInputMode = false;
            }
        });

        hoursWorkedField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWage();
            }
        });

        setVisible(true);
    }

    private void calculateWage() {
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());  // 시급 입력 필드에서 시급 값 가져오기
        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());  // 총 근무 시간 입력 필드에서 총 근무 시간 값 가져오기
        double wage = hourlyRate * hoursWorked; // 시급과 총 근무 시간으로 급여 계산
        double taxRate = 3.3;   // 세율 설정
        double taxAmount = wage * (taxRate / 100); // 세금 계산
        double netWage = wage - taxAmount;   // 세후 급여 계산

        JOptionPane.showMessageDialog(this, "월급: " + wage + "원" + "\n세금 (3.3%): " + taxAmount + "원" + "\n세후 월급: " + netWage + "원", "계산 결과", JOptionPane.INFORMATION_MESSAGE);
    }

    private void eraseInput() {
        inputStringBuilder.setLength(0);
        if (hourlyRateInputMode) {
            hourlyRateField.setText(""); //시급 입력필드 초기화
        } else {
            hoursWorkedField.setText(""); //총 근무시간 입력필드 초기화
        }
    }

    private void addNumber(int number) {
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
                new HourlyWageCalculator(); // HourlyWageCalculator 객체 생성
            }
        }
    }
}