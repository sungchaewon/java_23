import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RestaurantFrame {
    private JPanel panel;
    private JButton backButton;
    private JButton schoolInsideButton;
    private JButton schoolOutsideButton;

    public RestaurantFrame(MainFrame mainFrame) {
        panel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        //schoolinsidebutton
        schoolInsideButton = new JButton(new ImageIcon("..//images//schoolinside.png"));
        schoolInsideButton.addActionListener(new ActionListener() { //Move to inner frame when button pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showSchoolInsideFrame();
            }
        });
        buttonPanel.add(schoolInsideButton);

        //schooloutside button
        schoolOutsideButton = new JButton(new ImageIcon("..//images//schooloutside1.png"));
        schoolOutsideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showSchoolOutsideFrame(); //Move to outside frame when button pressed
            }
        });
        buttonPanel.add(schoolOutsideButton); //add button

        panel.add(buttonPanel, BorderLayout.CENTER);

        backButton = new JButton("뒤로 가기"); //back button
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
