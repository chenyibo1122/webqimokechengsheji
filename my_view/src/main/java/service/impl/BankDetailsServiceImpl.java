package main.java.service.impl;

import com.alibaba.druid.sql.visitor.functions.Concat;
import main.java.dao.BankdetailMapper;
import main.java.service.BankDetailsService;
import main.java.vo.Bankdetail;
import main.java.vo.BankdetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankDetailsServiceImpl implements BankDetailsService {
    @Autowired
    private BankdetailMapper bankdetailMapper;
    @Override
    public List<Bankdetail> getBankDetails(String time, String inorout) {
        BankdetailExample bankdetailExample=new BankdetailExample();
        BankdetailExample.Criteria criteria=bankdetailExample.createCriteria();
        criteria.andTimeLike("%"+time+"%");
        criteria.andInoroutLike("%"+inorout+"%");
        return bankdetailMapper.selectByExample(bankdetailExample);
    }

    @Override
    public int getBankDetailsCount(String time, String inorout) {
        BankdetailExample bankdetailExample=new BankdetailExample();
        BankdetailExample.Criteria criteria=bankdetailExample.createCriteria();
        criteria.andTimeLike("%"+time+"%");
        criteria.andInoroutLike("%"+inorout+"%");
        return bankdetailMapper.countByExample(bankdetailExample);
    }

    @Override
    public List<Bankdetail> selectBankDetailById(int id) {
        BankdetailExample bankdetailExample=new BankdetailExample();
        BankdetailExample.Criteria criteria=bankdetailExample.createCriteria();
        criteria.andIdEqualTo(id);
        return bankdetailMapper.selectByExample(bankdetailExample);
    }
}
