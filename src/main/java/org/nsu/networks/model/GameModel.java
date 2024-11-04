package org.nsu.networks.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class GameModel {

    private String name;;

    private int widthField;

    private int heightField;

    private int foodStatic;

    private int foodPerPlayer;

    private int stateDelay;

    private int deadFoodProb;

    private int pingDelay;

    private int nodeTimeout;

    private int maxPlayers;
}
