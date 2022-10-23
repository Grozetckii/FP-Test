package com.fp.test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Args _args = new Args();
        _args.initArgs(args);

        System.out.println("Минимально допустимый уровень доступности " + _args.getAcceptanceLevel());
        System.out.println("Приемлемое время ответа " + _args.getAcceptableResponseTime());
    }
}
