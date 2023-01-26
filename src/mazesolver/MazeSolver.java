package mazesolver;


public class MazeSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Maze maze = new Maze((int)(Math.random() * 5) + 5, (int)(Math.random() * 5) + 5);
        System.out.println("0 = a blocked path\n1 = a clear path\n3 = a tried path\n7 = a succesful path\nCan solve diagonally\n");
        System.out.println("The maze:\n" + maze);
        if(maze.traverse(0,0))
            System.out.println("\nThe maze was solved!");
        else
            System.out.println("\nThere isn't a path.");
        System.out.println(maze);
        
    }
    
}
