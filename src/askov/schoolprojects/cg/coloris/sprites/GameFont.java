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
                    font = Font.loadFont(Thread.currentThread().getContextClassLoader().getResource("fonts/digital-7-mono.ttf").toExternalForm(), size);
                    break;
                case MAIN_GAME_FONT:
                    font = Font.loadFont(Thread.currentThread().getContextClassLoader().getResource("fonts/computerfont.ttf").toExternalForm(), size);
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
