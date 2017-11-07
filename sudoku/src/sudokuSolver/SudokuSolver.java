/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuSolver;

/**
     * This program is executed in the following way:
     *    java SudokuSolver <input-file>
     * For details of the input-file format,see the Grid.java class.
     *
     * @author  Patrick Chan
     * @modified bornbygoogle
     * @version 1,12/31/05
     * @see Grid
     */
    import java.io.*;
    import java.util.*;

    public class SudokuSolver {


        public static void main(String [] args) throws Exception {
            
            System.out.println(args[0]);
            
            // Open the file containing the givens
            File file = new File(args[0]);
            FileReader rd = new FileReader(args[0]);

            // Process each grid in the file
            System.out.println(System.getProperty("user.dir")+"\\solutions.txt");
            try 
            {
                File f = new File(System.getProperty("user.dir")+"\\solutions.txt");
                if (f.createNewFile()){
	        System.out.println("File is created!");
	      }else{
	        System.out.println("File already exists.");
	      }
            } catch (IOException e) { e.printStackTrace(); }
            
            while (true) {
                Grid grid = Grid.create(rd);
                if (grid == null) {
                    // No more grids
                    break;
                }

                // Find a solution
                List<Grid> solutions = solve(grid);
                
                printSolutions(grid,solutions);
                
                
            }
        }

        // Recursive routine that
        private static List<Grid> solve(Grid grid) {
            List<Grid> solutions = new ArrayList<Grid>();
            solve(grid,solutions);
            return solutions;
        }

        private static void solve(Grid grid,List<Grid> solutions) {
            // Return if there is already more than two solution
            if (solutions.size() >= 2) {
                return;
            }

            // Find first empty cell
            int loc = grid.findEmptyCell();

            // If no empty cells are found,a solution is found
            if (loc < 0) {
                solutions.add(grid.clone());
                return;
            }

            // Try each of the 9 digits in this empty cell
            for (int n=1; n<10; n++  ){
                if (grid.set(loc,n)) {
                    // With this cell set,work on the next cell
                    solve(grid,solutions);

                    // Clear the cell so that it can be filled with another digit
                    grid.clear(loc);
                }
            }
        }

        private static void printSolutions(Grid grid,List<Grid> solutions) {
            // Print the grid with the givens
            System.out.println("Original");
            System.out.println(grid);

            // Print the solution
            if (solutions.isEmpty()) {
                System.out.println("Unsolveable");
            } else if (solutions.size() == 1) {
                System.out.println("Solved");
            } else {
                System.out.println("At least two solutions");
            }

            // Print the solution(s)
            for (int i=0; i<solutions.size(); i++  ) {
                System.out.println(solutions.get(i));
            }
            System.out.println();
        }
    }
