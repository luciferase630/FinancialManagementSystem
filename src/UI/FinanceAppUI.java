package UI;

import UI.LoginPanel;
import UI.RegisterPanel;
import UserManagement.UserManager;

import javax.swing.*;
import java.awt.*;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinanceAppUI {

    private static UserManager userManager = new UserManager(); // 用户管理实例

    public static void main(String[] args) {
        // 创建主窗口
        JFrame frame = new JFrame("个人理财管理系统");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1)); // 使用网格布局

        // 注册面板
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(3, 2)); // 2列布局

        // 注册输入字段
        registerPanel.add(new JLabel("用户名:"));
        JTextField usernameField = new JTextField();
        registerPanel.add(usernameField);

        registerPanel.add(new JLabel("密码:"));
        JPasswordField passwordField = new JPasswordField();
        registerPanel.add(passwordField);

        JButton registerButton = new JButton("注册");
        registerPanel.add(registerButton);

        // 登录面板
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        loginPanel.add(new JLabel("用户名:"));
        JTextField loginUsernameField = new JTextField();
        loginPanel.add(loginUsernameField);

        loginPanel.add(new JLabel("密码:"));
        JPasswordField loginPasswordField = new JPasswordField();
        loginPanel.add(loginPasswordField);

        JButton loginButton = new JButton("登录");
        loginPanel.add(loginButton);

        // 添加面板到主窗口
        frame.add(registerPanel);
        frame.add(loginPanel);

        // 事件处理
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理注册逻辑
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (userManager.registerUser(username, password)) {
                    JOptionPane.showMessageDialog(frame, "注册成功: " + username);
                } else {
                    JOptionPane.showMessageDialog(frame, "注册失败: 用户名已存在");
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理登录逻辑
                String username = loginUsernameField.getText();
                String password = new String(loginPasswordField.getPassword());
                if (userManager.loginUser(username, password)) {
                    JOptionPane.showMessageDialog(frame, "登录成功: " + username);
                } else {
                    JOptionPane.showMessageDialog(frame, "登录失败: 用户名或密码错误");
                }
            }
        });

        // 显示窗口
        frame.setVisible(true);
    }
}

