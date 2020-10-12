package com.company.sqlquery;

import java.lang.reflect.Field;

public final class CommonUntils {
    public static String getFieldType(Object object, String fieldName) {
        return getFieldByName(object, fieldName).getType().getName();
    }

    public static Object getFieldValue(Object object, String fieldName) {
        Object o = null;
        try {
            o = getFieldByName(object, fieldName).get(object);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return o;
    }

    private static Field getFieldByName(Object object, String fieldName) {
        if (object == null || fieldName == null || "".equals(fieldName)) {
            return null;
        }

        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}