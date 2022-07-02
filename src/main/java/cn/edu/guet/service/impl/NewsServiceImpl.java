package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Loopimg;
import cn.edu.guet.bean.News;
import cn.edu.guet.mapper.LoopimgMapper;
import cn.edu.guet.mapper.NewsMapper;
import cn.edu.guet.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {
    private NewsMapper newsMapper;

    private LoopimgMapper loopimgMapper;

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Autowired
    public void setLoopimgMapper(LoopimgMapper loopimgMapper) {
        this.loopimgMapper = loopimgMapper;
    }

    @Override
    public List<News> getnewsList() {
        return newsMapper.newsList();
    }

    @Override
    public List<News> newsclass(String newsclass) {
        return newsMapper.newsclass(newsclass);
    }

    @Override
    public List<Loopimg> getloopimgList() {
        return loopimgMapper.getloopimgList();
    }
}
