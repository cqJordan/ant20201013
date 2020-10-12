package com.company.sqlquery.limit;

public class Limit {
    private int count = 0;

    public Limit(int count) {
        if (count > 0)
        {
            this.count = count;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
