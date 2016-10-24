/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author B00316640
 */
public class KnightsTourUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new KnightsTourUser().run();
        // MazePosition p= new MazePosition(1, 2);
    } // method main

    public void run() {
        KnightsTour maze = null;

        int x, y;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting position of Knight ");
        x = sc.nextInt();
        y = sc.nextInt();
        try {
            maze = new KnightsTour(x, y);
            System.out.println("Initial state " + maze);

            if (!maze.isOK(maze.getStart())) {
                System.out.println("Invalid position");
            } else {
                if (searchMaze(maze)) {
                    System.out.println("Visit finish");
                }
                System.out.println("Final state " + maze);
            }
        } catch (InputMismatchException e) {
            System.out.println("\n" + e );
        } // catch InputMismatchException  
        catch (NumberFormatException e) {
            System.out.println("\n" + e);
        } // catch NumberFormatException
        catch (RuntimeException e) {
            System.out.println("\n" + e);
            
        } // catch
    }

    /**
     * Performs the maze search.
     *
     * @param maze â€“ the maze to be searched.
     *
     * @return true - if a path from start to finish was found; otherwise, false
     */
    public boolean searchMaze(KnightsTour maze) {
        KnightsPosition start = maze.getStart();
        maze.markAsPossible(start);
        BackTrack<KnightsPosition> backTrack = new BackTrack<>(maze);
        if (maze.isGoal(start) || backTrack.tryToReachGoal(start)) {
            return true;
        }
        maze.markAsDeadEnd(start);
        return false;
    }

} // class MazeUser
