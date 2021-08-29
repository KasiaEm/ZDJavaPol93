package sda.ex.ex10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

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
                int c = grid[i][j];
                int k = 3 * (i / 3) + (j / 3);

                if (!(rows.get(i).add(c) && cols.get(j).add(c) && sqrs.get(k).add(c))) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<Set<Integer>> generateSets() {
        return Stream.generate(HashSet<Integer>::new).limit(9).collect(toCollection(ArrayList::new));
    }

}
