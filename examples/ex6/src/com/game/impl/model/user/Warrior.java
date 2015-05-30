package com.game.impl.model.user;

import com.game.api.model.*;
import com.game.api.model.monster.Monster;
import com.game.api.model.monster.Movable;
import com.game.api.model.monster.Swimming;
import com.game.impl.model.BaseCharacter;
import com.game.impl.model.attacks.MaleAttack;
import com.game.impl.model.monster.BaseMonster;

import java.awt.*;

/**
 * Created by denis.selutin on 5/29/2015.
 */
public class Warrior extends BaseMonster implements Swimming {

    public Warrior(int health, int attackPower, int maxMoveDistance, int maxAttackDistance) {
        super(health, attackPower, maxMoveDistance, maxAttackDistance);
    }

    @Override
    protected CharacterAction getAttack(com.game.api.model.Character character) {
        return new MaleAttack(character, attackPower);
    }
}
