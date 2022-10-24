package com.fp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessLog {
    private String ip;
    private SimpleDateFormat formatter;
    private Date date;
    private String info;
    private int httpResponseCode;
    private double responseTime;
    private String info2;

    public AccessLog(){
        formatter = new SimpleDateFormat("dd/MM/y:HH:mm:ss Z");
        date = new Date();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateStr) throws ParseException {
        this.date = formatter.parse(dateStr);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getHttpResponseCode() {
        return httpResponseCode;
    }

    public void setHttpResponseCode(int httpResponseCode) {
        this.httpResponseCode = httpResponseCode;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }
}
