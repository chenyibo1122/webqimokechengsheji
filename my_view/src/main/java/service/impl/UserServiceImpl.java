package main.java.service.impl;

import main.java.dao.UserMapper;
import main.java.service.UserService;
import main.java.tools.MD5;
import main.java.vo.User;
import main.java.vo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Map<String, Object> getUser(String usename, String password) {
        // TODO Auto-generated method stub
        Map<String,Object> map=new HashMap<String, Object>();
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsenameEqualTo(usename);
        List<User> userResult=  userMapper.selectByExample(userExample);
        if (userResult.size()>1){
            map.put("code",4);
            map.put("info","用户数据有问题");
        }else {
            if (userResult == null) {
                map.put("code", 2);
                map.put("info", "用户名不存在");
            } else {
                if (!MD5.md5(password).equals(userResult.get(0).getPassword())) {
                    map.put("code", 3);
                    map.put("info", "密码不正确");
                } else {
                    map.put("code", 0);
                    map.put("info", "登录成功");
                    map.put("currentuser", userResult.get(0));
                }
            }
        }

        return map;
    }

    @Override
    public List<Map<String, Object>> queryUsersByCity() {
        String[] cityName=new String[]{"武汉","长沙","青岛","合肥","北京"};
        List<Map<String,Object>>list=new ArrayList<>();
        for (int i=0;i<cityName.length;i++){
            UserExample userExample=new UserExample();
            UserExample.Criteria criteria=userExample.createCriteria();
            criteria.andCityEqualTo(cityName[i]);
            int count=userMapper.countByExample(userExample);
            Map<String,Object>map=new HashMap<>();
            map.put("name",cityName[i]);
            map.put("value",count);
            list.add(map);
        }
        return list;
    }
}
