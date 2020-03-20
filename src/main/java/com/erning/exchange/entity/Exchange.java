package com.erning.exchange.entity;

public class Exchange {
    private String currencyCode;
    private String currencyName;
    private String country;
    private float exchange;
    private long updateTime;

    public Exchange() {
    }

    public Exchange(String currencyCode, float exchange,long updateTime) {
        this.currencyCode = currencyCode;
        this.exchange = exchange;
        this.updateTime = updateTime;
    }

    public Exchange(String currencyCode, String currencyName, String country, float exchange) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.country = country;
        this.exchange = exchange;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getExchange() {
        return exchange;
    }

    public void setExchange(float exchange) {
        this.exchange = exchange;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
