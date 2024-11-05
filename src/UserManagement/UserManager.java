// package UserManagement;
//
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
//
// import java.util.HashMap;
//
// public class UserManager {
//     private HashMap<String, String> users; // 存储用户名和密码
//
//     public UserManager() {
//
//         users = new HashMap<>();
//         loadUserData(); // 初始化时加载用户数据   // 20241105 朱羿帆添加
//     }
//
//     private void loadUserData() {   // 20241105 朱羿帆添加新方法，用于从文件加载用户数据
//         File file = new File("users.txt");
//         if (!file.exists()) {
//             return; // 如果文件不存在，直接返回
//         }
//
//         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] parts = line.split(":");
//                 if (parts.length == 2) {
//                     String username = parts[0];
//                     String password = parts[1];
//                     users.put(username, password); // 将用户名和密码存储到 HashMap 中
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//
//     private void saveUserData(String username, String password) {   // 20241105 朱羿帆添加新方法，用于保存用户数据到文件中
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
//             writer.write(username + ":" + password);
//             writer.newLine(); // 写入新行
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//
//
//
//     // 注册用户
//     public boolean registerUser(String username, String password) {
//         if (users.containsKey(username)) {
//             return false; // 用户名已存在
//         }
//         users.put(username, password); // 存储用户名和密码
//
//         // 将新用户写入到文件
//         saveUserData(username, password);   // 20241105 朱羿帆添加
//         return true; // 注册成功
//     }
//
//     // 登录用户
//     // public boolean loginUser(String username, String password) {
//     //     return users.containsKey(username) && users.get(username).equals(password); // 验证用户凭据
//     // }
//     public boolean loginUser(String username, String password) {    // 20241105 朱羿帆修改了方法，从文件中读取用户信息验证登录
//         File file = new File("users.txt");
//         if (!file.exists()) {
//             return false; // 文件不存在时直接返回 false
//         }
//
//         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] parts = line.split(":");
//                 if (parts.length == 2 && parts[0].equals(username)) {
//                     return parts[1].equals(password); // 找到匹配的用户名，验证密码
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return false; // 未找到用户
//     }
//
// }
package UserManagement;

import java.io.*;
import java.util.HashMap;

public class UserManager {
    private HashMap<String, String> users;  // 存储用户名和密码

    public UserManager() {
        users = new HashMap<>();
        loadUserData();  // 初始化时加载用户数据
    }

    private void loadUserData() {
        File file = new File("users.txt");
        if (!file.exists()) {
            return;  // 如果文件不存在，直接返回
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    users.put(username, password);  // 将用户名和密码存储到 HashMap 中
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUserData(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + ":" + password);
            writer.newLine();  // 写入新行
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 注册用户
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false;  // 用户名已存在
        }
        users.put(username, password);  // 存储用户名和密码
        saveUserData(username, password);  // 将新用户写入到文件
        return true;  // 注册成功
    }

    // 登录用户
    public boolean loginUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);  // 验证用户凭据
    }
}

