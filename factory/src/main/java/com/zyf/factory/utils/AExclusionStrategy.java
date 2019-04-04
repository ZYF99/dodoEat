package com.zyf.factory.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class AExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {

        //被跳过的字段

        //只要是属于DBFlow数据的
        //return f.getDeclaredClass().equals(ModelAdapter.class);

        //跳过包含下“_”的属性
        //return f.getName().contains("_");

        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        //被跳过的Class

        //跳过Date和boolean类型的字段
        //return clazz == Date.class || clazz == boolean.class;

        return false;
    }
}
