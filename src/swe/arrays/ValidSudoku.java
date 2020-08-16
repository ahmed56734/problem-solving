package swe.arrays;

import java.util.*;

public class ValidSudoku {

    public static void main(String[] args) {

        int[][] arr = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {5, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println(validSudoku(arr));
      

    }


    public static boolean validSudoku(int[][] board) {
        //key is tuple of(value, column number)
        Set<Tuple<Integer, Integer>> columnsSet = new HashSet<>();
        //key is tuple of(value, row number)
        Set<Tuple<Integer, Integer>> rowSet = new HashSet<>();
        //key is tuple of(value, box indices(i,j))
        Set<Tuple<Integer, Tuple<Integer, Integer>>> boxesSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = board[i][j];

                if (value == 0)
                    continue;

                Tuple<Integer, Integer> rowTuple = new Tuple(value, i);
                Tuple<Integer, Integer> colTuple = new Tuple(value, j);
                Tuple<Integer, Tuple<Integer, Integer>> boxTuple = new Tuple(value, new Tuple(i / 3, j / 3));

                if (rowSet.contains(rowTuple) || columnsSet.contains(colTuple) || boxesSet.contains(boxTuple)) {
                    return false;
                } else {
                    rowSet.add(rowTuple);
                    columnsSet.add(colTuple);
                    boxesSet.add(boxTuple);
                }


            }
        }
        return true;
    }


    static public class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Tuple) {
                Tuple other = (Tuple) obj;
                return x.equals(other.x) && y.equals(other.y);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
