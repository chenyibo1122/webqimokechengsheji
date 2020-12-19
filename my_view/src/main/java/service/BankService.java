package main.java.service;

import java.util.Map;

public interface BankService {
    public Map<String,Object> zhuanZhang(double money, String password,String other);
    public Map<String,Object> quKuan(double money, String password);

    public Map<String, Object> yuE();
}
