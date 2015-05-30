package com.game.impl.model.user;

import com.game.api.model.*;
import com.game.api.model.monster.Flying;
import com.game.api.model.monster.Movable;
import com.game.impl.model.BaseCharacter;
import com.game.impl.model.attacks.MagicAttack;
import com.game.impl.model.monster.BaseMonster;

import java.awt.*;

/**
 * Created by denis.selutin on 5/29/2015.
 */
public class Angel extends BaseMonster implements Flying {

    public Angel(int health, int attackPower, int maxMoveDistance, int maxAttackDistance) {
        super(health, attackPower, maxMoveDistance, maxAttackDistance);
    }

    @Override
    protected CharacterAction getAttack(com.game.api.model.Character character) {
        return new MagicAttack(character, attackPower);
    }
}
