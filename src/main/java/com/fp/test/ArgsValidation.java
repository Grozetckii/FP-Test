package com.fp.test;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class ArgsValidation implements IParameterValidator{
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(value == null || value.equals("-u") || value.equals("-t")){
            throw new ParameterException("Не найдено значение для параметра " + name);
        }
    }
}
