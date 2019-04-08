package com.zyf.factory.model.fun1;

public class Fun1RspModel {

    //功能1返回的参数模型例子，自行修改扩展

    private int arg1;
    private String arg2;
    private Fun1DataModel fun1DataModel;

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public Fun1DataModel getFun1DataModel() {
        return fun1DataModel;
    }

    public void setFun1DataModel(Fun1DataModel fun1DataModel) {
        this.fun1DataModel = fun1DataModel;
    }

    @Override
    public String toString() {
        return "Fun1RspModel{" +
                "arg1=" + arg1 +
                ", arg2='" + arg2 + '\'' +
                ", fun1DataModel=" + fun1DataModel +
                '}';
    }
}
