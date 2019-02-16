package com.example.week6test;

public class DupStrings {

    public static void main(String[] agrs) {

        String[][] stringArray = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "a", "b"}};

        int rows = stringArray.length;
        int cols = stringArray[0].length;
        Coordinate coordinate;
        int r;
        int c;
        String firstCoord = "{";
        String secondCoord = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                coordinate = new Coordinate(stringArray[i][j], i, j);
                r = i;
                c = j + 1;
                while (r < rows - 1) {
                    if (c == cols) {
                        r++;
                        c = 0;
                    }
                    while (c < cols) {
                        if (coordinate.getA().equals(stringArray[r][c])) {
                            firstCoord = firstCoord + "(" + i + "," + j + "),";
                            secondCoord = "(" + r + "," + c + ")," + secondCoord;
                        }
                        c++;
                    }
                }
            }
        }

        secondCoord = secondCoord.substring(0, secondCoord.length() - 1);
        String outString = firstCoord + secondCoord + "}";
        System.out.println(outString);
    }

    public static class Coordinate {
        String a;
        int x;
        int y;

        public Coordinate(String a, int x, int y) {
            this.a = a;
            this.x = x;
            this.y = y;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
