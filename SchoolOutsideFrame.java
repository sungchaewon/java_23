import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SchoolOutsideFrame {
    private JPanel panel;
    private JButton backButton;

    public SchoolOutsideFrame(MainFrame mainFrame) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("학교 외부 프레임");
        panel.add(label, BorderLayout.CENTER);

        backButton = new JButton("뒤로 가기");
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
