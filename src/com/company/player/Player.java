package com.company.player;

import com.company.CardGame;
import com.company.card.Card;

import java.util.Observable;
import java.util.Observer;

public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
            String playerName = ((Player) arg).name;
            if (playerName.equals(this.name)) {
                System.out.println(this.name + "'s turn:");
            }
    }
}
