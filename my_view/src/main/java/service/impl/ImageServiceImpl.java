package main.java.service.impl;

import main.java.dao.ImageMapper;
import main.java.service.ImageService;
import main.java.vo.Image;
import main.java.vo.ImageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    public ImageMapper imageMapper;
    @Override
    public List<Image> getImagesByGroupId(String groupid) {
        ImageExample imageExample=new ImageExample();
        ImageExample.Criteria criteria=imageExample.createCriteria();
        criteria.andGroupidEqualTo(groupid);
      return  imageMapper.selectByExample(imageExample);
    }
}
