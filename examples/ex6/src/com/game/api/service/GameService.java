package com.game.api.service;

import com.game.api.model.*;
import com.game.api.model.monster.Monster;

/**
 * Created by denis.selutin on 5/29/2015.
 */
public interface GameService {
    public com.game.api.model.Character getUserCharacter();
    public Monster[] getMonsters();
    public void calculateNextStep();
}
