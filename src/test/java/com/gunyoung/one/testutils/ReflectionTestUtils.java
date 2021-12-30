package com.gunyoung.one.testutils;

import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionTestUtils {
    public static Object getField(Object object, String fieldName) {
        Field field = null;
        try {
            field = object.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        List<Field> fieldNames = List.of(field);
        return ReflectionUtils.readFieldValues(fieldNames,object).get(0);
    }
}
