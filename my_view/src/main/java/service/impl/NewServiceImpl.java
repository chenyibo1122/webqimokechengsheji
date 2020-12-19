package main.java.service.impl;

import com.github.pagehelper.PageHelper;
import main.java.dao.NewMapper;
import main.java.service.NewService;
import main.java.vo.New;
import main.java.vo.NewExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewMapper newMapper;

    public List<New> getNewsByNewsid(int newsid) {
        NewExample newExample=new NewExample();
        NewExample.Criteria criteria=newExample.createCriteria();
        criteria.andNewsidEqualTo(newsid);
        //1.调用pagehelper的静态方法
        PageHelper.startPage(1,16,"time");
        return newMapper.selectByExample(newExample);
    }
}
