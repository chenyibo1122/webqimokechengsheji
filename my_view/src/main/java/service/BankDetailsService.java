package main.java.service;

import main.java.vo.Bankdetail;

import java.util.List;

public interface BankDetailsService {
    public List<Bankdetail> getBankDetails(String time,String inorout);
    public int getBankDetailsCount(String time,String inorout);
    public List<Bankdetail> selectBankDetailById(int id);
}
