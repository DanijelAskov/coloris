/*
 * Copyright (c) 2019, Danijel Askov
 */

package askov.schoolprojects.cg.coloris.sprites;

import javafx.scene.text.Font;

/**
 *
 * @author Danijel Askov
 */
public class GameFont {
    
    public enum FontType {
        SEGMENTED_DISPLAY,
        MAIN_GAME_FONT
    }
    
    private Font font;
    
    public GameFont(FontType fontType, double size) {
        try {
            switch (fontType) {
                case SEGMENTED_DISPLAY:
                    font = Font.loadFont(GameFont.class.getResource("resources/digital-7-mono.ttf").toExternalForm(), size);
                    break;
                case MAIN_GAME_FONT:
                    font = Font.loadFont(GameFont.class.getResource("resources/computerfont.ttf").toExternalForm(), size);
                    break;
            }
        } catch (Exception exception) {
            font = Font.font("Consolas", size);
        }
    }
    
    public Font getFont() {
        return font;
    }
    
}
