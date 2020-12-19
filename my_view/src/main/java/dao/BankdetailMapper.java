package main.java.dao;

import java.util.List;
import main.java.vo.Bankdetail;
import main.java.vo.BankdetailExample;
import org.apache.ibatis.annotations.Param;

public interface BankdetailMapper {
    int countByExample(BankdetailExample example);

    int deleteByExample(BankdetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bankdetail record);

    int insertSelective(Bankdetail record);

    List<Bankdetail> selectByExample(BankdetailExample example);

    Bankdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bankdetail record, @Param("example") BankdetailExample example);

    int updateByExample(@Param("record") Bankdetail record, @Param("example") BankdetailExample example);

    int updateByPrimaryKeySelective(Bankdetail record);

    int updateByPrimaryKey(Bankdetail record);
}