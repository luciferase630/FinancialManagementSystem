// package UI;
//
// import UserManagement.UserManager;
//
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
//
// public class LoginPanel extends JPanel {
//     private JTextField loginUsernameField;
//     private JPasswordField loginPasswordField;
//     private JButton loginButton;
//     private UserManager userManager;
//
//     public LoginPanel(CardLayout cardLayout, JPanel mainPanel) {
//         this.userManager = new UserManager();
//         setLayout(new GridLayout(3, 2)); // 设置网格布局
//
//         add(new JLabel("用户名:"));
//         loginUsernameField = new JTextField();
//         add(loginUsernameField);
//
//         add(new JLabel("密码:"));
//         loginPasswordField = new JPasswordField();
//         add(loginPasswordField);
//
//         loginButton = new JButton("登录");
//         add(loginButton);
//
//         // 登录按钮事件处理
//         loginButton.addActionListener(e -> {
//             String username = loginUsernameField.getText();
//             String password = new String(loginPasswordField.getPassword());
//             if (userManager.loginUser(username, password)) {
//                 JOptionPane.showMessageDialog(this, "登录成功: " + username);
//                 // 登录成功后的逻辑
//             } else {
//                 JOptionPane.showMessageDialog(this, "登录失败: 用户名或密码错误");
//             }
//         });
//     }
// }
package UI;

import UserManagement.UserManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField loginUsernameField;
    private JPasswordField loginPasswordField;
    private JButton loginButton;
    private JButton registerButton;
    private UserManager userManager;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Begin begin;

    public LoginPanel(CardLayout cardLayout, JPanel mainPanel, Begin begin, UserManager userManager) {
        this.userManager = userManager;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.begin = begin;

        setLayout(new GridLayout(3, 2)); // 设置网格布局

        add(new JLabel("用户名:"));
        loginUsernameField = new JTextField();
        add(loginUsernameField);

        add(new JLabel("密码:"));
        loginPasswordField = new JPasswordField();
        add(loginPasswordField);

        loginButton = new JButton("登录");
        add(loginButton);

        // 登录按钮事件处理
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginUsernameField.getText();
                String password = new String(loginPasswordField.getPassword());
                if (userManager.loginUser(username, password)) {
                    JOptionPane.showMessageDialog(LoginPanel.this, "登录成功: " + username);
                    begin.switchToMainScreen();  // 登录成功后切换到主界面
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "登录失败: 用户名或密码错误");
                }
            }
        });

        registerButton = new JButton("注册");
        add(registerButton);

        // 注册按钮事件处理
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                begin.switchToRegisterPanel();  // 切换到注册面板
            }
        });
    }
}
