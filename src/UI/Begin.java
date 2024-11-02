package UI;

import UI.Body;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Begin extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public Begin() {
        setTitle("用户认证");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 登录面板
        JPanel loginPanel = createLoginPanel();
        // 注册面板
        JPanel registerPanel = createRegisterPanel();

        cardPanel.add(loginPanel, "Login");
        cardPanel.add(registerPanel, "Register");

        add(cardPanel);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("登录");
        JButton registerButton = new JButton("注册");
        JButton backButton = new JButton("返回");

        panel.add(new JLabel("用户名:"));
        panel.add(usernameField);
        panel.add(new JLabel("密码:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(backButton);

        // 登录逻辑
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // 这里添加验证逻辑
            JOptionPane.showMessageDialog(this, "登录成功: " + username);
            // 切换到主界面
            new Body();
            dispose(); // 关闭当前界面
        });

        // 切换到注册界面
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));

        // 返回按钮逻辑
        backButton.addActionListener(e -> {
            // 在这个场景下返回上一级没有实际功能，可能是用于逻辑扩展
            JOptionPane.showMessageDialog(this, "返回上一级");
        });

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("注册");
        JButton backButton = new JButton("返回");

        panel.add(new JLabel("用户名:"));
        panel.add(usernameField);
        panel.add(new JLabel("密码:"));
        panel.add(passwordField);
        panel.add(registerButton);
        panel.add(backButton);

        // 注册逻辑
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // 这里添加注册逻辑
            JOptionPane.showMessageDialog(this, "注册成功: " + username);
            // 切换回登录界面
            cardLayout.show(cardPanel, "Login");
        });

        // 返回按钮逻辑
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));

        return panel;
    }

    public static void main(String[] args) {
        new Begin();
    }
}
