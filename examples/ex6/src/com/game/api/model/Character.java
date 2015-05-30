package com.game.api.model;

/**
 * Created by Denis on 5/27/2015.
 */
public interface Character {
    public boolean canDoAction(CharacterAction action);
    public void doAction(CharacterAction action);
    public int getHealth();
    public void modifyHealth(int val);
    public boolean isNpc();
    public boolean canMove();
}
