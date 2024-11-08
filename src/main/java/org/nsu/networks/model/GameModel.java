package org.nsu.networks.model;

import lombok.Getter;
import lombok.Setter;


public class GameModel {

    private static GameModel instance;

    private GameModel() {}

    public static GameModel getInstance() {
        if (instance == null) {
            instance = new GameModel();
            initialize();
        }
        return instance;
    }

    private static void initialize() {
        instance.setName("Player");
        instance.setWidthField(25);
        instance.setHeightField(25);
        instance.setFoodStatic(0);
        instance.setMaxPlayers(2);
        instance.setStateDelay(1000);
    }

    @Setter
    @Getter
    private String GameName;

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
    private int stateDelay;

    @Setter
    @Getter
    private int maxPlayers;



}
