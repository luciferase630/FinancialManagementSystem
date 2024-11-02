package UserManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class UserManager {
    private HashMap<String, String> users; // 存储用户名和密码

    public UserManager() {
        users = new HashMap<>();
    }

    // 注册用户
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // 用户名已存在
        }
        users.put(username, password); // 存储用户名和密码
        return true; // 注册成功
    }

    // 登录用户
    public boolean loginUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password); // 验证用户凭据
    }
}
