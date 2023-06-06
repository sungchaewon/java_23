import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create and add the login frame to the card panel
        LoginFrame loginFrame = new LoginFrame(this);
        cardPanel.add(loginFrame.getPanel(), "login");

        // Create and add the function selection frame to the card panel
        FunctionSelectionFrame functionSelectionFrame = new FunctionSelectionFrame(this);
        cardPanel.add(functionSelectionFrame.getPanel(), "functionSelection");

        // Create and add the restaurant frame to the card panel
        RestaurantFrame restaurantFrame = new RestaurantFrame(this);
        cardPanel.add(restaurantFrame.getPanel(), "restaurant");

        // Create and add the school outside frame to the card panel
        SchoolOutsideFrame schoolOutsideFrame = new SchoolOutsideFrame(this);
        cardPanel.add(schoolOutsideFrame.getPanel(), "schoolOutside");

        // Create and add the school inside frame to the card panel
        SchoolInsideFrame schoolInsideFrame = new SchoolInsideFrame(this);
        cardPanel.add(schoolInsideFrame.getPanel(), "schoolInside");

        // Create and add the school part-time job frame to the card panel
        SchoolPartTimeJobFrame schoolPartTimeJobFrame = new SchoolPartTimeJobFrame(this);
        cardPanel.add(schoolPartTimeJobFrame.getPanel(), "SchoolPartTimeJob");

        // Add the card panel to the main frame
        add(cardPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the main frame to the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        // Center the main frame on the screen
        setLocationRelativeTo(null);

        // Make the main frame visible
        setVisible(true);
    }

    // Show the login frame
    public void showLoginFrame() {
        cardLayout.show(cardPanel, "login");
    }

    // Show the function selection frame
    public void showFunctionSelectionFrame() {
        cardLayout.show(cardPanel, "functionSelection");
    }

    // Show the restaurant frame
    public void showRestaurantFrame() {
        cardLayout.show(cardPanel, "restaurant");
    }

    // Show the school outside frame
    public void showSchoolOutsideFrame() {
        cardLayout.show(cardPanel, "schoolOutside");
    }

    // Show the school inside frame
    public void showSchoolInsideFrame() {
        cardLayout.show(cardPanel, "schoolInside");
    }

    // Show the school part-time job frame
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