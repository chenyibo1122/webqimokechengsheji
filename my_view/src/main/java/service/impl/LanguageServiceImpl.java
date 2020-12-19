package main.java.service.impl;

import main.java.dao.LanguageMapper;
import main.java.service.LanguageService;
import main.java.vo.Language;
import main.java.vo.LanguageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageMapper languageMapper;
    @Override
    public List<Language> getLanguageByGroupId(String groupId) {
        LanguageExample languageExample=new LanguageExample();
        LanguageExample.Criteria criteria=languageExample.createCriteria();
        criteria.andGroupidEqualTo(groupId);
        return languageMapper.selectByExample(languageExample);
    }
}
