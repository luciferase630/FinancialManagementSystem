// package UI;
//
// import UI.Body;
//
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
//
// public class Begin extends JFrame {
//
//     private CardLayout cardLayout;
//     private JPanel cardPanel;
//
//     public Begin() {
//         setTitle("用户认证");
//         setSize(400, 300);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         cardLayout = new CardLayout();
//         cardPanel = new JPanel(cardLayout);
//
//         // 登录面板
//         JPanel loginPanel = createLoginPanel();
//         // 注册面板
//         JPanel registerPanel = createRegisterPanel();
//
//         cardPanel.add(loginPanel, "Login");
//         cardPanel.add(registerPanel, "Register");
//
//         add(cardPanel);
//         setVisible(true);
//     }
//
//     private JPanel createLoginPanel() {
//         JPanel panel = new JPanel();
//         panel.setLayout(new GridLayout(4, 2));
//
//         JTextField usernameField = new JTextField();
//         JPasswordField passwordField = new JPasswordField();
//         JButton loginButton = new JButton("登录");
//         JButton registerButton = new JButton("注册");
//         JButton backButton = new JButton("返回");
//
//         panel.add(new JLabel("用户名:"));
//         panel.add(usernameField);
//         panel.add(new JLabel("密码:"));
//         panel.add(passwordField);
//         panel.add(loginButton);
//         panel.add(registerButton);
//         panel.add(backButton);
//
//         // 登录逻辑
//         loginButton.addActionListener(e -> {
//             String username = usernameField.getText();
//             String password = new String(passwordField.getPassword());
//             // 这里添加验证逻辑
//             JOptionPane.showMessageDialog(this, "登录成功: " + username);
//             // 切换到主界面
//             new Body();
//             dispose(); // 关闭当前界面
//         });
//
//         // 切换到注册界面
//         registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));
//
//         // 返回按钮逻辑
//         backButton.addActionListener(e -> {
//             // 在这个场景下返回上一级没有实际功能，可能是用于逻辑扩展
//             JOptionPane.showMessageDialog(this, "返回上一级");
//         });
//
//         return panel;
//     }
//
//     private JPanel createRegisterPanel() {
//         JPanel panel = new JPanel();
//         panel.setLayout(new GridLayout(4, 2));
//
//         JTextField usernameField = new JTextField();
//         JPasswordField passwordField = new JPasswordField();
//         JButton registerButton = new JButton("注册");
//         JButton backButton = new JButton("返回");
//
//         panel.add(new JLabel("用户名:"));
//         panel.add(usernameField);
//         panel.add(new JLabel("密码:"));
//         panel.add(passwordField);
//         panel.add(registerButton);
//         panel.add(backButton);
//
//         // 注册逻辑
//         registerButton.addActionListener(e -> {
//             String username = usernameField.getText();
//             String password = new String(passwordField.getPassword());
//             // 这里添加注册逻辑
//             JOptionPane.showMessageDialog(this, "注册成功: " + username);
//             // 切换回登录界面
//             cardLayout.show(cardPanel, "Login");
//         });
//
//         // 返回按钮逻辑
//         backButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));
//
//         return panel;
//     }
//
//     public static void main(String[] args) {
//         new Begin();
//     }
// }
package UI;

import javax.swing.*;
import java.awt.*;
import UserManagement.UserManager;

public class Begin {
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private UserManager userManager;

    public Begin() {
        mainFrame = new JFrame("财务管理系统");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);  // 设置主窗口大小

        // 创建 UserManager 实例
        userManager = new UserManager();

        // 创建 CardLayout 和主面板
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 创建并添加登录和注册面板
        LoginPanel loginPanel = new LoginPanel(cardLayout, mainPanel, this, userManager);
        RegisterPanel registerPanel = new RegisterPanel(cardLayout, mainPanel, this, userManager);

        mainPanel.add(loginPanel, "LoginPanel");
        mainPanel.add(registerPanel, "RegisterPanel");

        // 默认显示登录面板
        cardLayout.show(mainPanel, "LoginPanel");

        // 设置主窗口的内容面板为 CardLayout
        mainFrame.setContentPane(mainPanel);

        // 添加退出按钮
        JButton exitButton = new JButton("退出");
        exitButton.addActionListener(e -> mainFrame.dispose()); // 退出程序

        // 在窗口底部添加退出按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(exitButton);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);

        // 显示窗口
        mainFrame.setVisible(true);
    }

    // 切换到注册面板
    public void switchToRegisterPanel() {
        cardLayout.show(mainPanel, "RegisterPanel");
    }

    // 切换到主界面
    public void switchToMainScreen() {
        // 这里可以替换为你的主界面逻辑，例如 Body 类
        JOptionPane.showMessageDialog(mainFrame, "登录成功，进入主界面！");
        mainFrame.dispose();  // 关闭登录窗口
        new Body();  // 显示主界面
    }

    public static void main(String[] args) {
        // 启动程序
        new Begin();
    }
}
