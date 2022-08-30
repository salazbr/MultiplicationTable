package com.tw;

public class MultiplicationTable {
    public String create(int start, int end) {
        return isValid(start, end) && isInRange(start) && isInRange(end)
                ? generateSingleExpression(start, end)
                : null;
    }

    public Boolean isValid(int start, int end) {

        return isStartNotBiggerThanEnd(start,end) && isInRange(start) && isInRange(end);
    }

    public Boolean isInRange(int number) {

        return number >= 1 && number <= 1000;
    }

    public Boolean isStartNotBiggerThanEnd(int start, int end) {

        return start <= end;
    }

    public String generateTable(int start, int end) {
        StringBuilder output = new StringBuilder();
        for(int i = start; i <= end; i++) {
            for(int j = start; j <= i; j++) {
                output.append(generateSingleExpression(j, i));
                if(j < i) output.append("  ");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim().replaceAll("\\n\\n", "");
    }

    public String generateLine(int start, int row) {
        StringBuilder output = new StringBuilder();
        for(int i = start; i <= row; i++) {
            output.append(generateSingleExpression(i, row)).append("  ");
        }
        return output.toString().trim();
    }

    public String generateSingleExpression(int multiplicand, int multiplier) {
        return multiplicand + "*" + multiplier + "=" + (multiplicand*multiplier);
    }
}
