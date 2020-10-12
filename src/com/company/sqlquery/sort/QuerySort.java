package com.company.sqlquery.sort;

import com.company.sqlquery.CommonUntils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuerySort {
    private String name;

    QuerySortType querySortType;

    public QuerySort(String name, QuerySortType querySortType) {
        this.name = name;
        this.querySortType = querySortType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuerySortType getQuerySortType() {
        return querySortType;
    }

    public void setQuerySortType(QuerySortType querySortType) {
        this.querySortType = querySortType;
    }

    public <T> List<T> sort(List<T> data) {
        Collections.sort(data, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                final String fieldType = CommonUntils.getFieldType(o1, name);
                final Object fieldValue1 = CommonUntils.getFieldValue(o1, name);
                final Object fieldValue2 = CommonUntils.getFieldValue(o2, name);
                final int var = (querySortType == QuerySortType.AES ? 1 : -1);
                if (fieldType.equals(int.class.getName()) || fieldType.equals(Integer.class.getName())) {
                    return ((int)fieldValue1 - (int)(fieldValue2)) * var;
                }
                return 0;
            }
        });
        return data;
    }
}
