package com.game.impl.model.monster;

import com.game.api.model.*;
import com.game.api.model.monster.*;
import com.game.impl.model.BaseCharacter;

import java.awt.*;

/**
 * Created by Denis on 5/27/2015.
 */
public abstract class BaseMonster extends BaseCharacter implements Monster, Movable {
    protected int attackPower;
    private int maxMoveDistance;
    private int attackDistance;
    private Point coordinates;

    public BaseMonster(int health, int attackPower, int maxMoveDistance) {
        this(health, attackPower, maxMoveDistance, 1);
    }

    public BaseMonster(int health, int attackPower, int maxMoveDistance, int attackDistance) {
        super(health);
        this.attackPower = attackPower;
        this.maxMoveDistance = maxMoveDistance;
        this.attackDistance = attackDistance;
    }

    @Override
    public final boolean canDoAction(CharacterAction action) {
        if(canFly(action.getActionTarget()) && ! canFly(this)) {
            return false;
        }
        return true;
    }

    public final void attack(com.game.api.model.Character character) {
        getAttack(character).doAction();
    }

    protected abstract CharacterAction getAttack(com.game.api.model.Character character);

    public final void moveTo(Point point) {
        this.coordinates = point;
    }
    public final boolean canMoveTo(Point point) {
        if(this.coordinates == null) {
            return true;
        } else {
            return this.coordinates.distance(point.getX(), point.getY()) < this.maxMoveDistance;
        }
    }

    @Override
    public int getAttackDistance() {
        return this.attackDistance;
    }

    @Override
    public Point getPosition() {
        return this.coordinates;
    }
}

