package com.game;

import com.game.api.service.GameService;
import com.game.impl.service.GameServiceImpl;

/**
 * Created by denis.selutin on 5/30/2015.
 */
public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();

        for(int i = 0; i < 50; i++) {
            System.out.println("-----------Step " + i + "-----------");
            gameService.calculateNextStep();
        }
    }
}
