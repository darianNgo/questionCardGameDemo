package com.company;

import com.company.card.Card;
import com.company.player.Player;

public class Match {
    private Player player;
    private Card card;

    public Match(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }
}
