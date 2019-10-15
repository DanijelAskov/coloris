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

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;

/**
 *
 * @author Danijel Askov
 */
@SuppressWarnings("unused")
public class GameLogo extends Sprite {

    private static final String TEXT = "COLORIS";
    public static final double FONT_SIZE = 80;
    
    public GameLogo() {
        char[] charArray = TEXT.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            Text text = new Text(String.valueOf(charArray[i]));
            
            text.setFont(new GameFont(GameFont.FontType.MAIN_GAME_FONT, FONT_SIZE).getFont());
            text.setFill(Color.web("0xBE0609"));
            text.setStroke(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("0xEEEE00")), new Stop(1, Color.web("0x666600"))));
            text.setStrokeWidth(2);
            
            text.setTranslateY(i * 0.65 * FONT_SIZE);
            super.getChildren().add(text);
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    @Override
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
}
