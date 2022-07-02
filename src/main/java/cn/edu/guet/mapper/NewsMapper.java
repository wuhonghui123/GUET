package cn.edu.guet.mapper;

import cn.edu.guet.bean.News;

import java.util.List;

public interface NewsMapper {
    List<News> newsList();
    List<News> newsclass(String news_class);
}
