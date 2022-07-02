package cn.edu.guet.service;

import cn.edu.guet.bean.Loopimg;
import cn.edu.guet.bean.News;

import java.util.List;

public interface INewsService {
    List<News> getnewsList();
    List<News> newsclass(String newsclass);
    List<Loopimg> getloopimgList();
}
