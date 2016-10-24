/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knightstour;

/**
 *
 * @author B00316640
 */
public class KnightsPosition {

    protected int row,
            column;

    /**
     * Initializes this Position object to (0, 0).
     */
    public KnightsPosition() {
        row = 0;
        column = 0;
    } // default constructor

    /**
     * Initializes this Position object to (row, column).
     *
     * @param row the row this Position object has been initialized to.
     * @param column the column this Position object has been initialized to.
     */
    public KnightsPosition(int row, int column) {
        this.row = row;
        this.column = column;
    } // constructor

    /**
     * Determines the row of this Position object.
     *
     * @return the row of this Position object.
     */
    public int getRow() {
        return row;
    } // method getRow

    /**
     * Determines the column of this Position object.
     *
     * @return the column of this Position object.
     */
    public int getColumn() {
        return column;
    } // method getColumn

} // class MazePosition
