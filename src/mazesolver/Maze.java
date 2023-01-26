/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver;

/**
 *
 * @author robno
 * 
 * from computer's book pages 462-463
 * with modifications
 */
public class Maze {
    private final int TRIED = 3;
    private final int PATH = 7;
    private int[][] grid;
    
    public Maze(int rows, int columns) {
        grid = new int[rows][columns];
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                grid[i][j] = (int)(Math.random() * 2);
        grid[0][0] = 1;
        grid[grid.length - 1][grid[0].length - 1] = 1;
    }
    
    public boolean traverse(int row, int column) {
        boolean done = false;
        if(valid(row, column)) {
            grid[row][column] = TRIED;
            if(row == grid.length - 1 && column == grid[0].length - 1)
                done = true;
            else {
                done = traverse(row + 1, column);
                if(!done)
                    done = traverse(row, column + 1);
                if(!done)
                    done = traverse(row - 1, column);
                if(!done)
                    done = traverse(row, column - 1);
                if(!done)
                    done = traverse(row - 1, column - 1);
                if(!done)
                    done = traverse(row - 1, column + 1);
                if(!done)
                    done = traverse(row + 1, column - 1);
                if(!done)
                    done = traverse(row + 1, column + 1);
            }
            if(done)
                grid[row][column] = PATH;
        }
        return done;
    }
    
    private boolean valid(int row, int column) {
        if(row >= 0 && row < grid.length && column >= 0 && column < grid[row].length)
            if(grid[row][column] == 1)
                return true;
        return false;
    }
    
    @Override
    public String toString() {
        String result = "\n";
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++)
                result += grid[i][j] + " ";
            result += "\n";
        }
        return result;
    }
}
