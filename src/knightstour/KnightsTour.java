/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

import java.util.Iterator;

/**
 *
 * @author B00316640(Tanver Hasan)
 */
public class KnightsTour implements Application<KnightsPosition> {

    int PATH = 1;
    static int N = 8;

    protected KnightsPosition start,
            finish;
   static byte square=0;
    protected byte[][] grid;

    /**
     *
     * @param x
     * @param y
     */
    public KnightsTour(int x, int y) {

        int rows = N,
                columns = N;

        grid = new byte[rows][columns];
        start = new KnightsPosition(x, y);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] =square;
            } // for j
        } //for i

    } // constructor

    public KnightsPosition getStart() {
        return start;
    } // method getStart

    /**
     * Returns a 2-dimensional array that holds a copy of the maze
     * configuration.
     *
     * @return - a 2-dimensional array that holds a copy of the maze
     * configuration.
     *
     */
    public byte[][] getGrid() {
        byte[][] gridCopy = new byte[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridCopy[i][j] = grid[i][j];
            }
        }

        return gridCopy;
    } // method gridCopy

    /**
     * Determines if a given position is legal and not a dead end.
     *
     * @param pos - the given position.
     *
     * @return true if pos is a legal position and not a dead end.
     */
    @Override
    public boolean isOK(KnightsPosition pos) {
        return pos.getRow() >= 0 && pos.getRow() < grid.length
                && pos.getColumn() >= 0 && pos.getColumn() < grid[0].length
                && grid[pos.getRow()][pos.getColumn()] == square;
    } // method isOK

    /**
     * Indicates that a given position is possibly on a path to a goal.
     *
     * @param pos the position that has been marked as possibly being on a path
     * to a goal.
     */
    @Override
    public void markAsPossible(KnightsPosition pos) {
        grid[pos.getRow()][pos.getColumn()] = (byte) PATH++;

    } // method markAsPossible

    /**
     * Indicates whether a given position is a goal position.
     *
     * @param pos the position that may or may not be a goal position.
     *
     * @return true if pos is a goal position; false otherwise.
     */
    @Override
    public boolean isGoal(KnightsPosition pos) {
        return grid[pos.getRow()][pos.getColumn()] == 64;

    } // method isGoal

    /**
     * Indicates that a given position is not on any path to a goal position.
     *
     * @param pos the position that has been marked as not being on any path to
     * a goal position.
     */
    @Override
    public void markAsDeadEnd(KnightsPosition pos) {
        grid[pos.getRow()][pos.getColumn()] = square;
        PATH--;

    } // method markAsDeadEnd

    /**
     * Converts this Application object into a String object.
     *
     * @return the String representation of this Application object.
     */
    @Override
    public String toString() {
        String result = "\n";

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                result += String.valueOf(grid[row][column]) + ' ';
            }
            result += "\n";
        } // for row = 0
        return result;
    } // method toString

    /**
     * Produces an Iterator object, over elements of type Position, that starts
     * at a given position.
     *
     * @param pos - the position the Iterator object starts at.
     *
     * @return the Iterator object.
     */
    @Override
    public Iterator<KnightsPosition> iterator(KnightsPosition pos) {
        return new MazeIterator(pos);
    } // method iterator

    protected class MazeIterator implements Iterator<KnightsPosition> {

        protected static final int MAX_MOVES = 8;

        protected int row,
                column,
                count;

        /**
         * Initializes this MazeIterator object to start at a given position.
         *
         * @param pos the position the Iterator objects starts at.
         */
        public MazeIterator(KnightsPosition pos) {
            row = pos.getRow();
            column = pos.getColumn();
            count = 0;
        } // constructor

        /**
         * Determines if this MazeIterator object can advance to another
         * position.
         *
         * @return true if this MazeIterator object can advance; false
         * otherwise.
         */
        @Override
        public boolean hasNext() {
            return count < MAX_MOVES;
        } // method hasNext

        /**
         * Advances this MazeIterator object to the next position.
         *
         * @return the position advanced to.
         */
        @Override
        public KnightsPosition next() {
            KnightsPosition nextPosition = new KnightsPosition();

            switch (count++) {

                case 0:
                    nextPosition = new KnightsPosition(row - 2, column + 1);
                    break;
                case 1:
                    nextPosition = new KnightsPosition(row - 1, column + 2);
                    break;
                case 2:
                    nextPosition = new KnightsPosition(row + 1, column + 2);
                    break;
                case 3:
                    nextPosition = new KnightsPosition(row + 2, column + 1);
                    break;
                case 4:
                    nextPosition = new KnightsPosition(row + 2, column + -1);
                    break;
                case 5:
                    nextPosition = new KnightsPosition(row + 1, column - 2);
                    break;
                case 6:
                    nextPosition = new KnightsPosition(row - 1, column - 2);
                    break;
                case 7:
                    nextPosition = new KnightsPosition(row - 2, column - 1);
            } // switch;     

            return nextPosition;
        } // method next

        @Override
        public void remove() {
            // removal is illegal for a MazeIterator object
            throw new UnsupportedOperationException();
        } // method remove

    } // class MazeIterator

} // class Maze 
