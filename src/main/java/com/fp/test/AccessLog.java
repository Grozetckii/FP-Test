package com.fp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessLog {
    private String ip;
    private SimpleDateFormat formatterInPut;
    private SimpleDateFormat formatterOutPut;
    private Date date;
    private String info;
    private int httpResponseCode;
    private double responseTime;
    private String info2;

    public AccessLog(){
        formatterInPut = new SimpleDateFormat("dd/MM/y:HH:mm:ss Z");
        formatterOutPut = new SimpleDateFormat("HH:mm:ss");
        date = new Date();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public SimpleDateFormat getFormatterOutPut() {
        return formatterOutPut;
    }

    public void setFormatterOutPut(SimpleDateFormat formatter) {
        this.formatterOutPut = formatter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateStr) throws ParseException {
        this.date = formatterInPut.parse(dateStr);
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

    public SimpleDateFormat getFormatterInPut() {
        return formatterInPut;
    }

    public void setFormatterInPut(SimpleDateFormat formatterInPut) {
        this.formatterInPut = formatterInPut;
    }
}
