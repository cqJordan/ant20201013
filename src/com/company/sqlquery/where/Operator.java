package com.company.sqlquery.where;

public enum Operator {
    ALT,//>
    LE,//<
    EQ,//=
    NEQ {
        @Override
        public boolean compare(int fieldValue, int compareValue) {
            return fieldValue != compareValue;
        }
    },
    EALT,//>=
    ELE,
    ;//<=

    public boolean compare(int fieldValue, int compareValue) {
        return true;
    }
    // todo string, char, float|Float
    public boolean compare(String fieldValue, String compareValue) {
        return true;
    }
}
