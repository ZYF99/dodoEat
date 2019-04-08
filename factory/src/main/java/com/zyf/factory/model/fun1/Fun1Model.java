package com.zyf.factory.model.fun1;

public class Fun1Model {

    private String arg1;
    private String arg2;


    public Fun1Model(String arg1, String arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "Fun1Model{" +
                "arg1='" + arg1 + '\'' +
                ", arg2='" + arg2 + '\'' +
                '}';
    }
}
