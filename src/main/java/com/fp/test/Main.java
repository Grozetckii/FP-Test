package com.fp.test;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Args _args = new Args();
        _args.initArgs(args);
        ArrayList<AccessLog> arrLog = new ArrayList<>();
        readLog(arrLog);
        failureReport(arrLog, _args);
    }
    private static void readLog(ArrayList<AccessLog> arrLog) throws ParseException {
        Scanner scan = new Scanner(System.in);
        String temp;

        while(scan.hasNext()){
            AccessLog log = new AccessLog();
            temp = scan.nextLine();

            String ipStrPattern = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}.[0-9]{1,3}";
            Pattern ipPattern = Pattern.compile(ipStrPattern);
            Matcher matchIp = ipPattern.matcher(temp);
            if(matchIp.find()){
                temp = temp.replace(matchIp.group(), "");
                log.setIp(matchIp.group());
            }

            String dateStrPattern = "([0-9]{2}/){2}[0-9]{4}(:[0-9]{2}){3} [+][0-9]{4}";
            Pattern datePattern = Pattern.compile(dateStrPattern);
            Matcher matchDate = datePattern.matcher(temp);
            if(matchDate.find()){
                temp = temp.replace(matchDate.group(), "");
                log.setDate(matchDate.group());
            }

            String infoStrPattern = "\".*?\"";
            Pattern infoPattern = Pattern.compile(infoStrPattern);
            Matcher matchInfo = infoPattern.matcher(temp);
            for(int i = 0; i < 3; i++){
                if(matchInfo.find()){
                    temp = temp.replace(matchInfo.group(), "");
                }
            }

            String httpResponseCodeStrPattern = "[1-5][0-9]{2}";
            Pattern httpResponseCodePattern = Pattern.compile(httpResponseCodeStrPattern);
            Matcher matchHttpResponse = httpResponseCodePattern.matcher(temp);
            if(matchHttpResponse.find()){
                temp = temp.replace(matchHttpResponse.group(), "");
                log.setHttpResponseCode(Integer.parseInt(matchHttpResponse.group()));
            }

            String timeStrPattern = "[0-9]+[.][0-9]+";
            Pattern timePattern = Pattern.compile(timeStrPattern);
            Matcher matchTime = timePattern.matcher(temp);
            if(matchTime.find()){
                log.setResponseTime(Double.parseDouble(matchTime.group()));
            }
            arrLog.add(log);
        }
    }

    private static void failureReport(ArrayList<AccessLog> arrLog, Args args){
        ArrayList<AccessLog> tempArrLog = new ArrayList<>();
        int countLog = 1;
        String httpResponseCodeStrPattern = "5[0-9]{2}";
        Pattern httpResponseCodePattern = Pattern.compile(httpResponseCodeStrPattern);

        for(var x : arrLog){
            Matcher matchHttpResponse = httpResponseCodePattern.matcher(String.valueOf(x.getHttpResponseCode()));
            if(matchHttpResponse.find() || (x.getResponseTime() > args.getAcceptableResponseTime())){
                long a = x.getDate().getTime();
                double b = x.getResponseTime();
                Date tempDate = new Date(Long.parseLong(String.format("%.0f", (a - b))));
                System.out.println(x.getFormatterOutPut().format(tempDate) + " " + x.getFormatterOutPut().format(x.getDate()) + " " + String.format("%.1f", (100 - (1.0 / countLog) * 100)));
                countLog = 1;
                continue;
            }
            countLog++;
        }
    }
}
