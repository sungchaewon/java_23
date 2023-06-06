import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HourlyWageCalculator extends JFrame {
    public JTextField hourlyRateField;
    public JTextField hoursWorkedField;
    public JButton eraseButton;
    public JButton[] numberButtons;
    public StringBuilder inputStringBuilder;
    public boolean hourlyRateInputMode; // 시급 입력 모드 여부
    JPanel p1 =   new JPanel();
    JPanel p2 =   new JPanel();
    JPanel p3 =   new JPanel();

    public HourlyWageCalculator() {
        setTitle("Hourly Wage Calculator");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(2, 2));
        p2.setLayout(new GridLayout(4, 3));
        p3.setLayout(new GridLayout(2, 1));

        JLabel hourlyRateLabel = new JLabel("시급 (원): ");
        JLabel hoursWorkedLabel = new JLabel("총 근무 시간: ");
        JLabel taxRateLabel = new JLabel("세금: 3.3%");
        JLabel taxRateLabel2 = new JLabel("*시급을 입력하신 후 입력창을 클릭하고 Enter키를 누르시면 총 근무 시간을 입력하실 수 있습니다.");

        hourlyRateField = new JTextField(15);
        hoursWorkedField = new JTextField(15);
        inputStringBuilder = new StringBuilder();
        hourlyRateInputMode = true;

        eraseButton = new JButton("초기화");
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseInput();
            }
        });

        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++) {
            final int number = i;
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addNumber(number);
                }
            });
        }

        JButton calculateButton = new JButton("계산하기");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWage();
            }
        });

        p1.add(hourlyRateLabel);
        p1.add(hourlyRateField);
        // add(new JLabel());

        p1.add(hoursWorkedLabel);
        p1.add(hoursWorkedField);
        // add(new JLabel());

        for (int i = 7; i <= 9; i++) {
            p2. add(numberButtons[i]);
        }

        for (int i = 4; i <= 6; i++) {
            p2.add(numberButtons[i]);
        }

        for (int i = 1; i <= 3; i++) {
            p2.add(numberButtons[i]);
        }

        p2.add(eraseButton);
        p2.add(numberButtons[0]);
        p2.add(calculateButton);

        // p2.add(new JLabel());
        p3.add(taxRateLabel);
        p3.add(taxRateLabel2);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);

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
}