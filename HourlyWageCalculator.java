import javax.swing.*;

public class HourlyWageCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WageCalculatorFrame();
            }
        });
    }
}

