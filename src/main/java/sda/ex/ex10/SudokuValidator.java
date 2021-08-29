package sda.ex.ex10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuValidator {
    private List<Set<Integer>> rows;
    private List<Set<Integer>> cols;
    private List<Set<Integer>> sqrs;

    public boolean validate(int[][] grid) {
        if (grid.length != 9) {
            return false;
        }
        for (int[] row : grid) {
            if (row.length != 9) {
                return false;
            }
        }
        rows = generateSets();
        cols = generateSets();
        sqrs = generateSets();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int current = grid[i][j];

                boolean addedToRow = rows.get(i).add(current);
                boolean addedToColumn = cols.get(j).add(current);
                boolean addedToSquare = sqrs.get(3 * (i / 3) + (j / 3)).add(current);

                if (!(addedToRow && addedToColumn && addedToSquare)) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<Set<Integer>> generateSets() {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<>());
        }
        return list;
    }

}
