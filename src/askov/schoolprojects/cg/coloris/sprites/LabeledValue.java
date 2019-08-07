/*
 * Copyright (c) 2019, Danijel Askov
 */

package askov.schoolprojects.cg.coloris.sprites;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Danijel Askov
 */
public class LabeledValue extends Frame {

    private static final Color BACKGROUND_COLOR = Color.web("0x111100");
    private static final LinearGradient LABEL_FILL_GRADIENT = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("0x7788AA")), new Stop(1, Color.web("0x113366")));
    private static final Font LABEL_FONT = new GameFont(GameFont.FontType.MAIN_GAME_FONT, 34).getFont();
    private static final Font VALUE_FONT = new GameFont(GameFont.FontType.SEGMENTED_DISPLAY, 58).getFont();

    private final Text valueText = new Text();
    
    private int value;
    
    public LabeledValue(double width, double height, String label, int value) {
        super(width, height, 10, BACKGROUND_COLOR);
        this.value = value;

        Text labelText = new Text();
        labelText.setText(label);
        labelText.setFont(LABEL_FONT);
        labelText.setFill(LABEL_FILL_GRADIENT);
        labelText.setTranslateY(super.borderSize + labelText.getFont().getSize() / 2 + 2 * height / 3);
        
        valueText.setText(String.format("%06d", value));
        valueText.setFont(VALUE_FONT);
        valueText.setFill(Color.web("0x0000DD"));
        Font font = valueText.getFont();
        valueText.setTranslateY(super.borderSize + font.getSize() / 2 + 0.25 * height);
        
        super.getChildren().addAll(labelText, valueText);
        
        labelText.setTranslateX(super.borderSize - labelText.getBoundsInParent().getWidth() / 2 + width / 2);
        valueText.setTranslateX(super.borderSize - valueText.getBoundsInParent().getWidth() / 2 + width / 2);
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value; 
        valueText.setText(String.format("%06d", value));
    }
    
}
