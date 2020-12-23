package com.company;

import com.company.card.Card;
import com.company.card.Category;
import com.company.deck.Deck;
import com.company.player.Player;

import java.util.ArrayList;
import java.util.List;

public class QuestionCardGameConsole {

    public static void main(String[] args) {
        Player p1 = new Player("Darian");
        Player p2 = new Player("Eilleen");
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

        Deck familyDeck = new Deck("Family", Category.FAMILY);
        Deck friendsDeck = new Deck("Friends", Category.FRIENDS);
        Deck relationshipDeck = new Deck("Relationship", Category.RELATIONSHIP);

        Card fc1 = new Card("Who has inspired you the most in this room the most this year and why?",
                Category.FRIENDS);
        Card fc2 = new Card("What was your biggest failure this year and why did it hurt the most?",
                Category.FRIENDS);
        Card fc3 = new Card("What is something you fear, but the most ashamed to tell anyone" +
                " about it and why?", Category.FRIENDS);
        Card fc4 = new Card("Tell a story relating to a time where you were dealing with the most pain",
                Category.FRIENDS);
        Card fc5 = new Card("Share the first memory you had with the person sitting across from you",
                Category.FRIENDS);

        friendsDeck.addCard(fc1);
        friendsDeck.addCard(fc2);
        friendsDeck.addCard(fc3);
        friendsDeck.addCard(fc4);
        friendsDeck.addCard(fc5);

        new CardGame(friendsDeck, players);
    }
}
