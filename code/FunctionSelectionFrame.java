import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FunctionSelectionFrame {
    private JPanel panel;
    private JButton restaurantButton;
    private JButton schoolButton;

    public FunctionSelectionFrame(MainFrame mainFrame) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        //go to Schoolinside and Schooloutside selectionFrame
        restaurantButton = new JButton(new ImageIcon("..//images//school.png"));
        restaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showRestaurantFrame();
            }
        });
        panel.add(restaurantButton);

        //go to PartTimeJobFrame
        schoolButton = new JButton(new ImageIcon("..//images//alba.png"));
        schoolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showSchoolPartTimeJobFrame();
            }
        });
        panel.add(schoolButton);

    }

    public JPanel getPanel() {
        return panel;
    }
}