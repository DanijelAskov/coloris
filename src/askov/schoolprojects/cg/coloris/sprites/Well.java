/*
 * Copyright (c) 2019, Danijel Askov
 */

package askov.schoolprojects.cg.coloris.sprites;

import javafx.scene.paint.Color;

/**
 *
 * @author Danijel Askov
 */
public class Well extends Frame {
    
    private static final Color BACKGROUND_COLOR = Color.web("0x0000DD", 0.5);
    private static final int NUM_SEGMENTS = 55;

    private static final double RELATIVE_WELL_HEIGHT = 1.4;
    
    private final SquareMatrix squareMatrix;
    private final Block fallingBlock;
    
    public Well(double squareMatrixWidth, double squareMatrixHeight) {
        super(squareMatrixWidth, RELATIVE_WELL_HEIGHT * squareMatrixHeight, NUM_SEGMENTS, BACKGROUND_COLOR);
        
        int markerIndex = (int)((((RELATIVE_WELL_HEIGHT - 1) * squareMatrixHeight + (2.0 / 3.0) * Block.DEFAULT_NUM_SQUARES * (squareMatrixHeight / SquareMatrix.DEFAULT_NUM_ROWS)) / (RELATIVE_WELL_HEIGHT * squareMatrixHeight)) * NUM_SEGMENTS);
        segmentsLeft[markerIndex].setFillType(FillType.YELLOW);
        segmentsRight[markerIndex].setFillType(FillType.YELLOW_INVERTED);
        
        squareMatrix = new SquareMatrix(squareMatrixWidth, squareMatrixHeight);
        fallingBlock = new Block(squareMatrixWidth / squareMatrix.getNumColumns(), squareMatrixWidth / squareMatrix.getNumColumns());
        
        squareMatrix.setTranslateX(super.getBorderSize());
        squareMatrix.setTranslateY(super.getBorderSize() + (RELATIVE_WELL_HEIGHT - 1) * squareMatrixHeight);
        
        super.getChildren().addAll(squareMatrix, fallingBlock);
    }
    
    public SquareMatrix getSquareMatrix() {
        return squareMatrix;
    }
    
    public Block getFallingBlock() {
        return fallingBlock;
    }
    
    @Override
    public void update() {
        squareMatrix.update();
    }

}
