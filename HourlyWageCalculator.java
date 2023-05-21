import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HourlyWageCalculator extends JFrame {
    private JTextField hourlyRateField;
    private JTextField hoursWorkedField;
    private JButton eraseButton;
    private JButton[] numberButtons;
    private StringBuilder inputStringBuilder;
    private boolean hourlyRateInputMode; // 시급 입력 모드 여부

    public HourlyWageCalculator() {
        setTitle("Hourly Wage Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 3));

        JLabel hourlyRateLabel = new JLabel("시급 (원): ");
        JLabel hoursWorkedLabel = new JLabel("총 근무 시간: ");
        JLabel taxRateLabel = new JLabel("세금: 3.3%");

        hourlyRateField = new JTextField();
        hoursWorkedField = new JTextField();
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

        add(hourlyRateLabel);
        add(hourlyRateField);
        add(hoursWorkedLabel);
        add(hoursWorkedField);
        add(eraseButton);

        for (int i = 1; i < numberButtons.length; i++) {
            add(numberButtons[i]);
        }

        // Add number 0 button
        numberButtons[0] = new JButton("0");
        numberButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber(0);
            }
        });
        add(numberButtons[0]);

        add(taxRateLabel);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);

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
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());
        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
        double wage = hourlyRate * hoursWorked;
        double taxRate = 3.3;
        double taxAmount = wage * (taxRate / 100);
        double netWage = wage - taxAmount;

        JOptionPane.showMessageDialog(this, "월급: " + wage + "원" + "\n세금 (3.3%): " + taxAmount + "원" + "\n세후 월급: " + netWage + "원", "계산 결과", JOptionPane.INFORMATION_MESSAGE);
    }

    private void eraseInput() {
        inputStringBuilder.setLength(0);
        if (hourlyRateInputMode) {
            hourlyRateField.setText("");
        } else {
            hoursWorkedField.setText("");
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
                new HourlyWageCalculator();
            }
        }
    }
}
        