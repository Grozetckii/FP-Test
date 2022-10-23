package com.fp.test;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names = "-u", description = "Минимально допустимый уровень доступности", validateWith = ArgsValidation.class)
    private Double acceptanceLevel;
    @Parameter(names = "-t", description = "Приемлемое время ответа", validateWith = ArgsValidation.class)
    private double acceptableResponseTime;

    public double getAcceptanceLevel() {
        return acceptanceLevel;
    }

    public void setAcceptanceLevel(double acceptanceLevel) {
        this.acceptanceLevel = acceptanceLevel;
    }

    public double getAcceptableResponseTime() {
        return acceptableResponseTime;
    }

    public void setAcceptableResponseTime(double acceptableResponseTime) {
        this.acceptableResponseTime = acceptableResponseTime;
    }

    public void initArgs(String[] args){
        JCommander.newBuilder().addObject(this).build().parse(args);
        if(this.acceptanceLevel == null){
            System.out.println("Отсутствует обязательный аргумент -u");
            System.out.println("Требуются аргументы (-u <число> -t <число>)");
            System.out.println("-u : Минимально допустимый уровень доступности");
            System.out.println("-t : Приемлемое время ответа");
            System.exit(-1);
        }
    }
}
