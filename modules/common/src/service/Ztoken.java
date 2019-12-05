package service;

import auth.User;

public class Ztoken  {

    private String  id;
    private String  accessToken;
    private String  mac;
    private String  ticket;
    private String  accessTokenCreateTime;
    private String  accessTokenRefreshTime;
   private User user;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getAccessTokenCreateTime() {
        return accessTokenCreateTime;
    }

    public void setAccessTokenCreateTime(String accessTokenCreateTime) {
        this.accessTokenCreateTime = accessTokenCreateTime;
    }

    public String getAccessTokenRefreshTime() {
        return accessTokenRefreshTime;
    }

    public void setAccessTokenRefreshTime(String accessTokenRefreshTime) {
        this.accessTokenRefreshTime = accessTokenRefreshTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
