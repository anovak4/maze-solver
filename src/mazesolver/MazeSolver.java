/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver;

/**
 *
 * @author robno
 */
public class MazeSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Maze maze = new Maze((int)(Math.random() * 5) + 5, (int)(Math.random() * 5) + 5);
        System.out.println("0 = a blocked path\n1 = a clear path\n3 = a tried path\n7 = a succesful path\nCan solve diagonally\n");
        System.out.println("The maze:\n" + maze);
        if(maze.traverse(0,0))
            System.out.println("THE MAZE WAS SOLVED!!");
        else
            System.out.println("There isn't a path.");
        System.out.println(maze);
        
    }
    
}
