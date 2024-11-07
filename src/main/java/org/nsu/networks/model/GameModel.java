package org.nsu.networks.model;

import lombok.Getter;
import lombok.Setter;


public class GameModel {

    private static GameModel instance;

    private GameModel() {}

    public static GameModel getInstance() {
        if (instance == null) {
            instance = new GameModel();
        }
        return instance;
    }

    @Setter
    @Getter
    private String name;;

    @Setter
    @Getter
    private int widthField;

    @Setter
    @Getter
    private int heightField;

    @Setter
    @Getter
    private int foodStatic;

    @Setter
    @Getter
    private int foodPerPlayer;

    @Setter
    @Getter
    private int stateDelay;

    @Setter
    @Getter
    private int deadFoodProb;

    @Setter
    @Getter
    private int pingDelay;

    @Setter
    @Getter
    private int nodeTimeout;

    @Setter
    @Getter
    private int maxPlayers;
}
