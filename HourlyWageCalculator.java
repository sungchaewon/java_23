import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HourlyWageCalculator extends JFrame {
    private JTextField hourlyRateField; //�ñ� �Է� �ʵ�
    private JTextField hoursWorkedField; // �� �ٹ� �ð� �Է��ʵ� 
    private JButton eraseButton; // �ʱ�ȭ ��ư
    private JButton[] numberButtons; //���� ��ư �迭 
    private StringBuilder inputStringBuilder; // �Էµ� ���� �����ϴ� ���ڿ�
    private boolean hourlyRateInputMode; // �ñ� �Է� ��� ����

    public HourlyWageCalculator() {
        setTitle("Hourly Wage Calculator"); //������ ������
        setSize(300, 200); // ������ ũ�� ���� 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư ���ۼ��� 
        setLayout(new GridLayout(5, 3)); // �׸��� ���̾ƿ� ���� 

        JLabel hourlyRateLabel = new JLabel("�ñ� (��): "); //�ñ� ���̺� ���� 
        JLabel hoursWorkedLabel = new JLabel("�� �ٹ� �ð�: "); //�� �ٹ��ð� ���̺� ���� 
        JLabel taxRateLabel = new JLabel("����: 3.3%"); //���� ���̺� ���� 

        hourlyRateField = new JTextField(); //�ñ� �Է� �ʵ� ���� 
        hoursWorkedField = new JTextField(); // �� �ٹ��ð� �Է� �ʵ� ���� 
        inputStringBuilder = new StringBuilder(); //�Էµ� ���ڸ� �����ϴ� ���ڿ� ���� 
        hourlyRateInputMode = true; //�ñ��Է� ��� �ʱ�ȭ 

        eraseButton = new JButton("�ʱ�ȭ"); //�ʱ�ȭ ��ư���� 
        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseInput();
            }
        });

        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++) {
            final int number = i;
            numberButtons[i] = new JButton(Integer.toString(i)); //���� ��ư���� 
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addNumber(number);
                }
            });
        }

        JButton calculateButton = new JButton("����ϱ�"); //����ϱ� ��ư����
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateWage();
            }
        });

        add(hourlyRateLabel); //�ñ� ���̺� �߰�
        add(hourlyRateField); //�ñ� �Է� �ʵ� �߰�
        add(hoursWorkedLabel); //�� �ٹ��ð� ���̺� �߰�
        add(hoursWorkedField); //�ʱ�ȭ ��ư �߰�
        add(eraseButton);

        for (int i = 1; i < numberButtons.length; i++) {
            add(numberButtons[i]); //���ڹ�ư�߰�
        }

        // ���� 0 ��ư ���� 
        numberButtons[0] = new JButton("0");
        numberButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber(0);
            }
        });
        add(numberButtons[0]); //���� 0��ư �߰�
        add(taxRateLabel); //���� ���̺� �߰� 
        add(new JLabel()); //������ ���� �� ���̺� �߰� 
        add(calculateButton); //����ϱ� ��ư �߰� 

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
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());  // �ñ� �Է� �ʵ忡�� �ñ� �� ��������
        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());  // �� �ٹ� �ð� �Է� �ʵ忡�� �� �ٹ� �ð� �� ��������
        double wage = hourlyRate * hoursWorked; // �ñް� �� �ٹ� �ð����� �޿� ���
        double taxRate = 3.3;   // ���� ����
        double taxAmount = wage * (taxRate / 100); // ���� ���
        double netWage = wage - taxAmount;   // ���� �޿� ���

        JOptionPane.showMessageDialog(this, "����: " + wage + "��" + "\n���� (3.3%): " + taxAmount + "��" + "\n���� ����: " + netWage + "��", "��� ���", JOptionPane.INFORMATION_MESSAGE);
    }

    private void eraseInput() {
        inputStringBuilder.setLength(0);
        if (hourlyRateInputMode) {
            hourlyRateField.setText(""); //�ñ� �Է��ʵ� �ʱ�ȭ
        } else {
            hoursWorkedField.setText(""); //�� �ٹ��ð� �Է��ʵ� �ʱ�ȭ
        }
    }

    private void addNumber(int number) {
        if (hourlyRateInputMode) {
            if (inputStringBuilder.length() == 0) {
                hourlyRateField.setText(""); // ���� �� �ʱ�ȭ
            }
            inputStringBuilder.append(number); // ���� �߰�
            hourlyRateField.setText(hourlyRateField.getText() + number); // ���� �̾ ǥ��
        } else {
            if (inputStringBuilder.length() == 0) {
                hoursWorkedField.setText(""); // ���� �� �ʱ�ȭ
            }
            inputStringBuilder.append(number); // ���� �߰�
            hoursWorkedField.setText(hoursWorkedField.getText() + number); // ���� �̾ ǥ��
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HourlyWageCalculator(); // HourlyWageCalculator ��ü ����
            }
        }
    }
}