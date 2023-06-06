import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        LoginFrame loginFrame = new LoginFrame(this);
        cardPanel.add(loginFrame.getPanel(), "login");

        FunctionSelectionFrame functionSelectionFrame = new FunctionSelectionFrame(this);
        cardPanel.add(functionSelectionFrame.getPanel(), "functionSelection");

        RestaurantFrame restaurantFrame = new RestaurantFrame(this);
        cardPanel.add(restaurantFrame.getPanel(), "restaurant");

        SchoolOutsideFrame schoolOutsideFrame = new SchoolOutsideFrame(this);
        cardPanel.add(schoolOutsideFrame.getPanel(), "schoolOutside");

        SchoolInsideFrame schoolInsideFrame = new SchoolInsideFrame(this);
        cardPanel.add(schoolInsideFrame.getPanel(), "schoolInside");

        SchoolPartTimeJobFrame schoolPartTimeJobFrame = new SchoolPartTimeJobFrame(this);
        cardPanel.add(schoolPartTimeJobFrame.getPanel(), "SchoolPartTimeJob");

        add(cardPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showLoginFrame() {
        cardLayout.show(cardPanel, "login");
    }

    public void showFunctionSelectionFrame() {
        cardLayout.show(cardPanel, "functionSelection");
    }

    public void showRestaurantFrame() {
        cardLayout.show(cardPanel, "restaurant");
    }

    public void showSchoolOutsideFrame() {
        cardLayout.show(cardPanel, "schoolOutside");
    }

    public void showSchoolInsideFrame() {
        cardLayout.show(cardPanel, "schoolInside");
    }

    public void showSchoolPartTimeJobFrame() {
        cardLayout.show(cardPanel, "SchoolPartTimeJob");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}


