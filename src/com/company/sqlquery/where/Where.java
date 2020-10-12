package com.company.sqlquery.where;

import com.company.sqlquery.CommonUntils;

public class Where {
    private String name;
    
    private Object compareValue;

    private Operator op;

    public Where(String filedName, Operator op, Object compareValue) {
        this.name = filedName;
        this.op = op;
        this.compareValue = compareValue;
    }

    public <T> boolean judge(T t){
        final String fieldType = CommonUntils.getFieldType(t, this.name);
        final Object fieldValue = CommonUntils.getFieldValue(t, this.name);
        if (fieldType.equals(int.class.getName()) || fieldType.equals(Integer.class.getName())) {
            return this.op.compare((int)fieldValue, (int)(this.compareValue));
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(Object compareValue) {
        this.compareValue = compareValue;
    }

    public Operator getOp() {
        return op;
    }

    public void setOp(Operator op) {
        this.op = op;
    }
}
