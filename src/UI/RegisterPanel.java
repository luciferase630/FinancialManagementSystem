package UI;

import UserManagement.UserManager;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RegisterPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private UserManager userManager;

    public RegisterPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.userManager = new UserManager();
        setLayout(new GridLayout(3, 2)); // 设置网格布局

        add(new JLabel("用户名:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerButton = new JButton("注册");
        add(registerButton);

        // 注册按钮事件处理
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (userManager.registerUser(username, password)) {
                JOptionPane.showMessageDialog(this, "注册成功: " + username);
            } else {
                JOptionPane.showMessageDialog(this, "注册失败: 用户名已存在");
            }
        });
    }
}
