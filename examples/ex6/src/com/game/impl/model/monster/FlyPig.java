package com.game.impl.model.monster;

import com.game.api.model.*;
import com.game.api.model.monster.Flying;
import com.game.impl.model.attacks.RangeAttack;

/**
 * Created by denis.selutin on 5/29/2015.
 */
public class FlyPig extends Pig implements Flying {

    public FlyPig(int health, int attackPower, int maxMoveDistance) {
        super(health, attackPower, maxMoveDistance);
    }

    @Override
    protected CharacterAction getAttack(com.game.api.model.Character character) {
        return new RangeAttack(character, this.attackPower);
    }
}
