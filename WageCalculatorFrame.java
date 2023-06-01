import javax.swing.*;
import java.awt.*;

public class WageCalculatorFrame extends JFrame {
    public WageCalculatorFrame() {
        setTitle("�ñ� ����");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(new InputPanel(), BorderLayout.NORTH);
        add(new ButtonPanel(), BorderLayout.CENTER);
        add(new CalculationPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }
}
