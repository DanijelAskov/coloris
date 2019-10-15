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
import javafx.scene.text.Text;

/**
 *
 * @author Danijel Askov
 */
@SuppressWarnings("unused")
public class GameOverLabel extends Sprite {

    public GameOverLabel() {
        Text labelText = new Text("GAME OVER");
        labelText.setFont(new GameFont(GameFont.FontType.MAIN_GAME_FONT, 34).getFont());
        labelText.setFill(Color.web("0xEEEE00"));
        
        super.getChildren().add(labelText);
        labelText.setTranslateY(labelText.getBoundsInParent().getHeight());
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
        return this.getBoundsInLocal().getWidth();
    }

    
    
}
