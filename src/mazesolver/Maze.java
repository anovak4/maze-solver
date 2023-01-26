package mazesolver;


public class Maze {
    private final char TRIED = '~';
    private final char PATH = '*';
    private char[][] grid;

    public Maze(int rows, int columns) {
        grid = new char[rows][columns];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                int rand = (int) (Math.random() * 2);
                if (rand == 0)
                    grid[i][j] = '#';
                else
                    grid[i][j] = ' ';
            }
        grid[0][0] = ' ';
        grid[grid.length - 1][grid[0].length - 1] = ' ';
    }

    public boolean traverse(int row, int column) {
        boolean done = false;
        if (valid(row, column)) {
            grid[row][column] = TRIED;
            if (row == grid.length - 1 && column == grid[0].length - 1)
                done = true;
            else {
                done = traverse(row + 1, column);
                if (!done)
                    done = traverse(row, column + 1);
                if (!done)
                    done = traverse(row - 1, column);
                if (!done)
                    done = traverse(row, column - 1);
                if (!done)
                    done = traverse(row - 1, column - 1);
                if (!done)
                    done = traverse(row - 1, column + 1);
                if (!done)
                    done = traverse(row + 1, column - 1);
                if (!done)
                    done = traverse(row + 1, column + 1);
            }
            if (done)
                grid[row][column] = PATH;
        }
        return done;
    }

    private boolean valid(int row, int column) {
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length)
            if (grid[row][column] == ' ')
                return true;
        return false;
    }

    @Override
    public String toString() {
        String result = "\n--";
        for (int i = 0; i < grid[0].length; i++) {
            result += "--";
        }
        result += "-\n";
        for (int i = 0; i < grid.length; i++) {
            result += "| ";
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '*') {
                    result += "\u001B[32m" + grid[i][j] + "\u001B[0m" + " "; // print * in green
                } else if (grid[i][j] == '~') {
                    result += "\u001B[31m" + grid[i][j] + "\u001B[0m" + " "; // print ~ in red
                } else {
                    result += grid[i][j] + " ";
                }
            }
            result += "| \n";
        }
        for (int i = 0; i < grid[0].length; i++) {
            result += "--";
        }
        result += "---";
        return result;
    }
}
