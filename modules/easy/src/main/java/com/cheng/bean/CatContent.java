package com.cheng.bean;

import com.cheng.illegaljson.CompareSelect;
import com.cheng.illegaljson.IllegalJsonDeserializer;
import com.google.gson.annotations.JsonAdapter;

import java.util.List;

@JsonAdapter(value = IllegalJsonDeserializer.class)
public class CatContent {
    private String wallpaper;
    private String spider;
    private List<DataBean> sites;
    private List<DataBean> lives;

    public String getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }

    public String getSpider() {
        return spider;
    }

    public void setSpider(String spider) {
        this.spider = spider;
    }

    public List<DataBean> getData() {
        return sites;
    }

    public void setSites(List<DataBean> sites) {
        this.sites = sites;
    }

    public List<DataBean> getLives() {
        return lives;
    }

    public void setLives(List<DataBean> lives) {
        this.lives = lives;
    }

    public class DataBean {
        private long id;
        @CompareSelect({"newsInfo", "specialInfo"})
        private CatNewsInfoBean newsInfo;
        private CatInfoBean freshnewsInfo;


        private int contentType;
        private String createTime;
        private String showType;
        private String key;
        private String name;
        private String type;
        private String api;
        private String searchable;
        private String quickSearch;
        private String filterable;
        private String ext;

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        private List<CatInfoBean> channels;

        public List<CatInfoBean> getChannels() {
            return channels;
        }

        public void setChannels(List<CatInfoBean> channels) {
            this.channels = channels;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }

        public String getSearchable() {
            return searchable;
        }

        public void setSearchable(String searchable) {
            this.searchable = searchable;
        }

        public String getQuickSearch() {
            return quickSearch;
        }

        public void setQuickSearch(String quickSearch) {
            this.quickSearch = quickSearch;
        }

        public String getFilterable() {
            return filterable;
        }

        public void setFilterable(String filterable) {
            this.filterable = filterable;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public CatNewsInfoBean getNewsInfo() {
            return newsInfo;
        }

        public void setNewsInfo(CatNewsInfoBean newsInfo) {
            this.newsInfo = newsInfo;
        }

        public CatInfoBean getFreshnewsInfo() {
            return freshnewsInfo;
        }

        public void setFreshnewsInfo(CatInfoBean freshnewsInfo) {
            this.freshnewsInfo = freshnewsInfo;
        }

        public int getContentType() {
            return contentType;
        }

        public void setContentType(int contentType) {
            this.contentType = contentType;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getShowType() {
            return showType;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }
    }
}

