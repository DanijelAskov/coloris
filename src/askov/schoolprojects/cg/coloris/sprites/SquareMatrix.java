/*
 * Copyright (C) 2019  Danijel Askov
 *
 * This file is part of Coloris.
 *
 * Coloris is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Coloris is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package askov.schoolprojects.cg.coloris.sprites;

/**
 *
 * @author Danijel Askov
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SquareMatrix extends Sprite {

    public static final int DEFAULT_NUM_ROWS = 14;
    public static final int DEFAULT_NUM_COLUMNS = 7;

    private final Square[][] squares;
    private final int numRows;
    private final int numColumns;

    private final double width;
    private final double height;
    private final double squareWidth;
    private final double squareHeight;
    private final int blockSize;

    public SquareMatrix(double width, double height, int numRows, int numColumns, int blockSize) {
        this.numRows = numRows + (this.blockSize = blockSize);
        this.numColumns = numColumns;

        squareWidth = (this.width = width) / numColumns;
        squareHeight = (this.height = height) / this.numRows;

        squares = new Square[this.numRows][numColumns];

        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                squares[i][j] = new Square(squareWidth, squareHeight);

                super.getChildren().add(squares[i][j]);
            }
        }
    }

    public SquareMatrix(double width, double height) {
        this(width, height, DEFAULT_NUM_ROWS, DEFAULT_NUM_COLUMNS, Block.DEFAULT_NUM_SQUARES);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumColumns() {
        return numColumns;
    }

    public Square getSquare(int row, int column) {
        if (row >= 0 && row < numRows && column >= 0 && column < numColumns) {
            return squares[row][column];
        } else {
            return null;
        }
    }

    public void absorbColorsFrom(int row, int column, Block block) {
        if (row < 0 || row >= numRows || column < 0 || column >= numColumns) {
            return;
        }
        for (int i = 0; i < block.getNumSquares(); i++) {
            squares[row++][column].absorbColorFrom(block.getSquare(i));
        }
    }
    
    public boolean isColumnOverflow() {
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (squares[i][j].getSquareColor() != Square.SquareColor.NULL) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void update() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                squares[i][j].setTranslateX(j * squareWidth);
                squares[i][j].setTranslateY(i * squareHeight);
                squares[i][j].update();
            }
        }
    }

}
