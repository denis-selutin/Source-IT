package com.game.impl.model.monster;

import com.game.api.model.*;
import com.game.impl.model.attacks.MaleAttack;

/**
 * Created by Denis on 5/27/2015.
 */
public class Pig extends BaseMonster implements Npc {

    public Pig(int health, int attackPower, int maxMoveDistance) {
        super(health, attackPower, maxMoveDistance);
    }

    @Override
    protected CharacterAction getAttack(com.game.api.model.Character character) {
        return new MaleAttack(character, attackPower);
    }
}
