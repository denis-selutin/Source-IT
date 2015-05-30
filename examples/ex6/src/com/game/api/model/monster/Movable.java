package com.game.api.model.monster;

import java.awt.*;

/**
 * Created by Denis on 5/27/2015.
 */
public interface Movable {
    void moveTo(Point point);
    boolean canMoveTo(Point point);
    Point getPosition();
}
