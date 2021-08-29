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

    }

    private List<Set<Integer>> generateSets() {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<>());
        }
        return list;
        /*return Stream.generate(HashSet::new)
                .limit(9)
                .collect(Collectors.toList())*/
    }

}
