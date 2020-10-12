package com.company.sqlquery;

import com.company.sqlquery.limit.Limit;
import com.company.sqlquery.sort.QuerySort;
import com.company.sqlquery.where.Where;
import com.company.sqlquery.where.Wheres;

import java.util.ArrayList;
import java.util.List;

public class SqlQuery {
    public static <T> List<T> query(List<T> data, Wheres wheres, List<QuerySort> querySorts, Limit limit) {
        List<T> dataAnd = new ArrayList<>();
        if (wheres.getWheresAnd() != null) {
            dataAnd = query(data, wheres.getWheresAnd());
        }
        if (wheres.getWheresOr() != null && wheres.getWheresOr().size() > 0) {
            //TODO 1.做集合与操作后得到集合ABC
            //TODO 2.dataAnd = dataAnd | ABC
        }
        for (QuerySort querySort:querySorts) {
            dataAnd = querySort.sort(dataAnd);
        }
        return getLimitData(dataAnd, limit.getCount());
    }

    private static <T> List<T> getLimitData(List<T> data, int count) {
        final int size = data.size();
        if (count >= size)
        {
            System.out.println("will back max size data : " + size);
            count = size;
        }
        return data.subList(0,count);
    }

    private static <T> List<T> query(List<T> data, List<Where> wheres, List<QuerySort> querySorts, Limit limit) {
        return getLimitData(query(data, wheres, querySorts),limit.getCount());
    }

    private static <T> List<T> query(List<T> data, List<Where> wheres, List<QuerySort> querySorts) {
        data = query(data, wheres);
        for (QuerySort querySort:querySorts) {
            data = querySort.sort(data);
        }
        return data;
    }
    private static <T> List<T> query(List<T> data, List<Where> wheres) {
        for (Where where:wheres) {
            data = query(data, where);
        }
        return data;
    }

    private static <T> List<T> query(List<T> data, Where where) {
        List<T> result = new ArrayList<>();
        for (T t:data){
            if (where.judge(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
