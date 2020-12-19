package main.java.service.impl;

import main.java.dao.BankMapper;
import main.java.dao.BankdetailMapper;
import main.java.service.BankService;
import main.java.tools.MD5;
import main.java.vo.Bank;
import main.java.vo.BankExample;
import main.java.vo.Bankdetail;
import main.java.vo.BankdetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankMapper bankMapper;
    @Autowired
    private BankdetailMapper bankdetailMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> zhuanZhang(double money_out, String password, String other) {
        Map<String, Object> map = new HashMap<>();
        BankExample bankExample1 = new BankExample();
        BankExample.Criteria criteria1 = bankExample1.createCriteria();
        criteria1.andUsenameEqualTo(other);
        List<Bank> list = bankMapper.selectByExample(bankExample1);
        if (list.size() == 0) {
            map.put("info", "没有该账户");
            map.put("code", "2");
        } else {
            if (MD5.md5(password).equals(bankMapper.selectPasswordByUseName("wtu"))) {
                double money = bankMapper.selectMoneyByUseName("wtu");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                if (money >= money_out) {
                    //此账户余额减少
                    BankExample bankExample2 = new BankExample();
                    BankExample.Criteria criteria2 = bankExample2.createCriteria();
                    criteria2.andUsenameEqualTo("wtu");
                    Bank bank2 = new Bank();
                    bank2.setMoney(money - money_out);
                    bank2.setTime(df.format(new Date()));
                    bankMapper.updateByExampleSelective(bank2, bankExample2);


                    //被转账账户余额增多
                    BankExample bankExample3 = new BankExample();
                    BankExample.Criteria criteria3 = bankExample3.createCriteria();
                    criteria3.andUsenameEqualTo(other);
                    Bank bank3 = new Bank();
                    bank3.setMoney(list.get(0).getMoney() + money_out);
                    bank3.setTime(df.format(new Date()));
                    bankMapper.updateByExampleSelective(bank3, bankExample3);


                    //明细
                    Bankdetail bankdetail = new Bankdetail();
                    bankdetail.setInorout("out");
                    bankdetail.setByorto(list.get(0).getName());
                    bankdetail.setMoney(money_out);
                    bankdetail.setSum(money - money_out);
                    bankdetail.setTime(df.format(new Date()));
                    bankdetailMapper.insert(bankdetail);


                    map.put("info", "成功向" + other + "转账" + money_out + "元");
                    map.put("code", 0);
                } else {
                    map.put("info", "余额不够");
                    map.put("code", 3);
                }

            } else {
                map.put("info", "密码不对请重新输入");
                map.put("code", 1);
            }
        }

        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> quKuan(double money_qukuan, String password) {
        Map<String, Object> map = new HashMap<>();
        if (MD5.md5(password).equals(bankMapper.selectPasswordByUseName("wtu"))) {
            double money = bankMapper.selectMoneyByUseName("wtu");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            if (money >= money_qukuan) {
                //此账户余额减少
                BankExample bankExample2 = new BankExample();
                BankExample.Criteria criteria2 = bankExample2.createCriteria();
                criteria2.andUsenameEqualTo("wtu");
                Bank bank2 = new Bank();
                bank2.setMoney(money - money_qukuan);
                bank2.setTime(df.format(new Date()));
                bankMapper.updateByExampleSelective(bank2, bankExample2);

                //明细
                Bankdetail bankdetail = new Bankdetail();
                bankdetail.setInorout("qukuan");
                bankdetail.setByorto("myself");
                bankdetail.setMoney(money_qukuan);
                bankdetail.setSum(money - money_qukuan);
                bankdetail.setTime(df.format(new Date()));
                bankdetailMapper.insert(bankdetail);
                map.put("info", "成功取款" + money_qukuan + "元");
                map.put("code", 0);
            } else {
                map.put("info", "余额不够");
                map.put("code", 2);
            }

        } else {
            map.put("info", "密码不对请重新输入");
            map.put("code", 1);
        }


        return map;
    }

    @Override
    public Map<String, Object> yuE() {
        double money = bankMapper.selectMoneyByUseName("wtu");
        Map<String,Object> map=new HashMap<>();
        map.put("money",money);
        return map;
    }
}
