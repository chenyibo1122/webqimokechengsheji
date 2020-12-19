package main.java.service;

import main.java.vo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public Map<String,Object> getUser(String usename, String password);
    public List<Map<String,Object>> queryUsersByCity();
}
