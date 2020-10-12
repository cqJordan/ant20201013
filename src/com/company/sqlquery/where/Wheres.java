package com.company.sqlquery.where;

import com.company.sqlquery.where.Where;

import java.util.List;

public class Wheres {
    private List<Where> wheresAnd;
    private List<Where> wheresOr;

    public List<Where> getWheresAnd() {
        return wheresAnd;
    }

    public void setWheresAnd(List<Where> wheresAnd) {
        this.wheresAnd = wheresAnd;
    }

    public List<Where> getWheresOr() {
        return wheresOr;
    }

    public void setWheresOr(List<Where> wheresOr) {
        this.wheresOr = wheresOr;
    }
}
