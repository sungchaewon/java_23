import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputPanel extends JPanel {
    public JTextField hourlyRateField;
    public JTextField hoursWorkedField;
    public boolean hourlyRateInputMode;

    public InputPanel() {
        setLayout(new GridLayout(2, 2));

        JLabel hourlyRateLabel = new JLabel("시급 (원): ");
        JLabel hoursWorkedLabel = new JLabel("총 근무 시간: ");

        hourlyRateField = new JTextField();
        hoursWorkedField = new JTextField();
        hourlyRateInputMode = true;

        hourlyRateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    hourlyRateField.setEnabled(false);
                    hoursWorkedField.setEnabled(true);
                    hoursWorkedField.requestFocus();
                    hourlyRateInputMode = false;
                }
            }
        });

        hoursWorkedField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    hourlyRateField.setEnabled(true);
                    hourlyRateField.requestFocus();
                    hourlyRateInputMode = true;
                }
            }
        });

        hourlyRateField.setPreferredSize(new Dimension(hourlyRateField.getPreferredSize().width, 50));
        hoursWorkedField.setPreferredSize(new Dimension(hoursWorkedField.getPreferredSize().width, 50));

        add(hourlyRateLabel);
        add(hourlyRateField);
       
