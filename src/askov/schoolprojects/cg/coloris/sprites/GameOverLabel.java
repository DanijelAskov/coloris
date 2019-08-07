/*
 * Copyright (c) 2019, Danijel Askov
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
