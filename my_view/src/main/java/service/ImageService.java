package main.java.service;

import main.java.vo.Image;

import java.util.List;

public interface ImageService {
    public List<Image> getImagesByGroupId(String groupid);
}
