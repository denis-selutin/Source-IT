package com.game.impl.model.attacks;

import com.game.api.model.*;

/**
 * Created by denis.selutin on 5/29/2015.
 */
public class RangeAttack extends BaseAttack {
    public RangeAttack(com.game.api.model.Character targetCharacter, int attackPower) {
        super(targetCharacter, attackPower);
    }

    @Override
    public AttackType getAttackType() {
        return AttackType.RANGE;
    }
}
