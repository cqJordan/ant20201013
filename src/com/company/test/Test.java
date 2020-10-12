package com.company.test;

import com.company.sqlquery.*;
import com.company.sqlquery.limit.Limit;
import com.company.sqlquery.sort.QuerySort;
import com.company.sqlquery.sort.QuerySortType;
import com.company.sqlquery.where.Operator;
import com.company.sqlquery.where.Where;
import com.company.sqlquery.where.Wheres;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        test2();
    }

    static void test2(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("sam", 6));
        students.add(new Student("tom", 1));
        students.add(new Student("jak", 4));
        students.add(new Student("bam", 6));
        students.add(new Student("ack", 8));
        students.add(new Student("som", 1));
        print("input = ", students);

        Wheres wheres = new Wheres();
        List<Where> wheresAnd = new ArrayList<>();
        wheresAnd.add(new Where("age", Operator.NEQ, 4));
        wheres.setWheresAnd(wheresAnd);
        List<Where> wheresOr = new ArrayList<>();
        wheresOr.add(new Where("age", Operator.NEQ, 8));
        wheres.setWheresOr(wheresOr);

        List<QuerySort> querySorts = new ArrayList<>();
        querySorts.add(new QuerySort("age", QuerySortType.DES));
        querySorts.add(new QuerySort("age", QuerySortType.AES));

        Limit limit = new Limit(55);
        List<Student> result = SqlQuery.query(students, wheres, querySorts, limit);
        print("output = ", result);
    }

    private static void print(String msg, List<Student> result) {
        System.out.print(msg);
        for (Student stu:result) {
            System.out.print("[" + stu.getName() + ",");
            System.out.print(stu.getAge());
            System.out.print("]");
        }
        System.out.println();
    }
}
