import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame {
    private JPanel panel;
    private JButton loginButton;

    public LoginFrame(MainFrame mainFrame) { //Login panel, the first panel
        panel = new JPanel(new FlowLayout());
        panel.setLayout(null);

        //제목
        ImageIcon titleicon = new ImageIcon("..//images//title2.png"); //specify the path of the image file.
        Image img = titleicon.getImage();
        Image changeImg = img.getScaledInstance(1407,190, Image.SCALE_SMOOTH); //Resize the image

        ImageIcon changeIcon1 = new ImageIcon(changeImg);

        JLabel iconLabel1 = new JLabel(changeIcon1); //title
        iconLabel1.setBounds(10, 10, 1500,300);
        panel.add(iconLabel1);

        JLabel loginLabel = new JLabel("LOGIN"); //login
        loginLabel.setBounds(755, 300, 80,45);
        panel.add(loginLabel);

        JLabel usernameLabel = new JLabel("아이디:"); //id
        usernameLabel.setBounds(600, 350, 80,45);
        panel.add(usernameLabel);

        //adjust the width of the ID field.
        JTextField usernameField = new JTextField(15);
        usernameField.setBounds(650, 350, 300,45);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBounds(595, 420, 80,45);
        panel.add(passwordLabel);

        //adjust the width of the password field.
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBounds(650, 420, 300,45);
        panel.add(passwordField);

        //snow image
        ImageIcon icon = new ImageIcon("..//images//snowing.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(380, 230, 200,300);
        panel.add(iconLabel);

        //loginbutton
        loginButton = new JButton("로그인");
        loginButton.setBounds(740, 490, 100, 40);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Implement the login verification logic here afterwards
                mainFrame.showFunctionSelectionFrame();
            }
        });
        panel.add(loginButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}