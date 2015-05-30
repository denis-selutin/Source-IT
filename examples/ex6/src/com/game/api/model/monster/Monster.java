package com.game.api.model.monster;

import com.game.api.model.Character;

/**
 * Created by Denis on 5/27/2015.
 */
public interface Monster extends Character{
    void attack(Character character);
    int getAttackDistance();
}
