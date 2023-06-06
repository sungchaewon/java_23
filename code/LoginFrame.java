import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame {
    private JPanel panel;
    private JButton loginButton;

    public LoginFrame(MainFrame mainFrame) {
        panel = new JPanel(new FlowLayout());
        panel.setLayout(null);

        //제목
        ImageIcon titleicon = new ImageIcon("..//images//title2.png"); // 이미지 파일의 경로를 지정해야 합니다.
        Image img = titleicon.getImage();
        Image changeImg = img.getScaledInstance(1407,190, Image.SCALE_SMOOTH);

        ImageIcon changeIcon1 = new ImageIcon(changeImg);

        JLabel iconLabel1 = new JLabel(changeIcon1);
        iconLabel1.setBounds(10, 10, 1500,300);
        panel.add(iconLabel1);

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setBounds(755, 300, 80,45);
        panel.add(loginLabel);

        JLabel usernameLabel = new JLabel("아이디:");
        usernameLabel.setBounds(600, 350, 80,45);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField(15); // 아이디 필드의 너비를 조정할 수 있습니다.
        usernameField.setBounds(650, 350, 300,45);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordLabel.setBounds(595, 420, 80,45);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(15); // 비밀번호 필드의 너비를 조정할 수 있습니다.
        passwordField.setBounds(650, 420, 300,45);
        panel.add(passwordField);

        ImageIcon icon = new ImageIcon("..//images//snowing.png"); // 이미지 파일의 경로를 지정해야 합니다.
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(380, 230, 200,300);
        panel.add(iconLabel);

        loginButton = new JButton("로그인");
        loginButton.setBounds(740, 490, 100, 40);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 로그인 검증 로직을 여기에 구현합니다.
                // 간단한 예시로 로그인이 성공했다고 가정합니다.
                mainFrame.showFunctionSelectionFrame();
            }
        });
        panel.add(loginButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}

