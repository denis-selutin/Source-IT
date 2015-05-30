package com.game.impl.service;

import com.game.api.model.Character;
import com.game.api.model.monster.Monster;
import com.game.api.model.monster.Movable;
import com.game.api.service.GameService;
import com.game.impl.model.monster.FlyPig;
import com.game.impl.model.monster.Pig;
import com.game.impl.model.user.Angel;
import com.game.impl.model.user.Warrior;

import java.awt.Point;
import java.util.Random;

/**
 * Created by denis.selutin on 5/29/2015.
 */
public class GameServiceImpl implements GameService {

    private static final int ANGEL_POWER = 50;
    private static final int ANGEL_HEALTH = 200;
    private static final int ANGEL_MOVE_DISTANCE = 20;
    private static final int ANGEL_ATTACK_DISTANCE = 8;
    private static final int WARRIOR_POWER = 70;
    private static final int WARRIOR_MOVE_DISTANCE = 8;
    private static final int WARRIOR_ATTACK_DISTANCE  = 5;
    private static final int WARRIOR_HEALTH = 500;
    private static final int MAX_MONSTERS = 5;
    private static final int MAX_MOVE_LENGTH = 2;

    private static final Character generateRandomUserCharacter() {
        Character result;
        Random r = new Random();
        if(r.nextInt(2) == 0) {
            result = new Angel(ANGEL_HEALTH, ANGEL_POWER, ANGEL_MOVE_DISTANCE, ANGEL_ATTACK_DISTANCE);
        } else {
            result = new Warrior(WARRIOR_HEALTH, WARRIOR_POWER, WARRIOR_MOVE_DISTANCE, WARRIOR_ATTACK_DISTANCE);
        }
        if(result.canMove()) {
            ((Movable) result).moveTo(new Point(0, 0));
        }
        return result;
    }

    private static final Monster[] generateRandomMonsters() {
        Random r = new Random();
        Monster[] monsters = new Monster[r.nextInt(MAX_MONSTERS) + MAX_MONSTERS];
        for(int i = 0; i < monsters.length; i++) {
            Monster m;
            if(r.nextInt(2) == 0) {
                m = new Pig(r.nextInt(80) + 20, r.nextInt(10) + 5, r.nextInt(3) + 1);
            } else {
                m = new FlyPig(r.nextInt(50) + 20, r.nextInt(20) + 5, r.nextInt(8) + 1);
            }
            monsters[i] = m;
        }
        return monsters;
    }

    private Character userChar;
    private Monster[] monsters;
    private GameProcessor processor;

    public GameServiceImpl() {
        this.userChar = generateRandomUserCharacter();
        this.monsters = generateRandomMonsters();
        this.processor = this.new GameProcessor();
        this.processor.printStat();
    }

    @Override
    public com.game.api.model.Character getUserCharacter() {
        return this.userChar;
    }

    @Override
    public Monster[] getMonsters() {
        return this.monsters;
    }

    @Override
    public void calculateNextStep() {
        this.processor.processNextStep();
    }

    private class GameProcessor {
        private Movable[] movableMonsters = new Movable[monsters.length + 1];
        private GameProcessor() {
            Random r = new Random();
            for(int i = 0; i < monsters.length; i++) {
                if(monsters[i].canMove()) {
                    int x = r.nextInt(MAX_MOVE_LENGTH);
                    int y = r.nextInt(MAX_MOVE_LENGTH);
                    Movable m = (Movable) monsters[i];
                    m.moveTo(new Point(x, y));
                    movableMonsters[i] = m;
                }
            }
            movableMonsters[movableMonsters.length-1] = (Movable)userChar;
        }

        public void processNextStep() {
            fight();
            move();
            printStat();
        }

        private void move() {
            Random r = new Random();
            for(int i = 0; i < movableMonsters.length; i++) {
                Movable m = movableMonsters[i];
                int sign = r.nextInt(2) == 0 ? -1 : 1;
                m.moveTo(new Point(m.getPosition().x + r.nextInt(MAX_MOVE_LENGTH) * sign, m.getPosition().y + r.nextInt(MAX_MOVE_LENGTH) * sign));
            }
        }

        private void fight() {
            for(int i = 0; i < movableMonsters.length - 1; i++) {
                Movable m1 = movableMonsters[i];
                Movable m2 = movableMonsters[i + 1];
                if(m1.getPosition().distance(m2.getPosition().getX(), m2.getPosition().getY()) <= ((Monster)m1).getAttackDistance()) {
                    ((Monster) m1).attack(((Monster) m2));
                }
            }
        }

        private void printStat() {
            for(int i = 0; i < movableMonsters.length; i++) {
                Monster m = (Monster)movableMonsters[i];
                System.out.println(m.getClass().getName()
                        + " health="
                        + m.getHealth()
                        + " position="
                        + movableMonsters[i].getPosition()
                );
            }
        }

    }
}
