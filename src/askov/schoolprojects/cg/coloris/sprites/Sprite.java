/*
 * Copyright (c) 2019, Danijel Askov
 */

package askov.schoolprojects.cg.coloris.sprites;

import javafx.scene.Group;

/**
 *
 * @author Danijel Askov
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class Sprite extends Group {

    public abstract void update();
    
    public abstract double getWidth();
    
    public abstract double getHeight();

}
