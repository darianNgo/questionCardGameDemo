package com.company;

import com.company.card.Card;
import com.company.card.Category;
import com.company.deck.Deck;
import com.company.player.Player;

import java.util.*;


public class CardGame extends Observable {
    private List<Player> players = new ArrayList<>();
    private Deck deck;
    private Card currentCard;
    private Player whoseTurn;
    private Category category;
    private int deckSize;
    private int playerSize;
    private Match currentMatch;
    private List<Match> matches;
    private int maxRounds;
    private Scanner scanner;

    // makes a card game
    public CardGame(Deck deck, List<Player> playerList) {
        this.deck = deck;
        this.players = playerList;
        this.category = deck.getCategory();
        deckSize = this.deck.getCards().size();
        playerSize = players.size();
        matches = new ArrayList<>();
        currentMatch = null;

        for (Player player : playerList) {
            addObserver(player);
        }

        maxRounds = playerSize * deckSize;
        play();
    }

    public void play() {
        if (maxRounds > 0) {
            generateCurrentMatch();
            System.out.println(currentMatch.getCard().getQuestion());
            scanner = new Scanner(System.in);
            System.out.println("Enter n for next question");

            String userInput = scanner.nextLine();

            if (userInput.equals("n")) {
                play();
            }
        }
    }


    // EFFECTS: checks if there are at least 2 players in the game
    public Boolean atLeastTwo() {
        return players.size() >= 2;
    }

    // REQUIRES: must have multiple cards in deck
    // EFFECTS: generates the current card and current player
    public void generateCurrentMatch() {
        Card currentC;
        Player currentP;
        Match potentialMatch;
        if (atLeastTwo()) {
            currentP = players.get(new Random().nextInt(playerSize));
            currentC = deck.getCards().get(new Random().nextInt(deckSize));
            potentialMatch = new Match(currentP, currentC);
            if (notMatchedBefore(potentialMatch)) {
                currentMatch = potentialMatch;
                matches.add(currentMatch);
                this.whoseTurn = currentMatch.getPlayer();
                this.currentCard = currentMatch.getCard();
                maxRounds--;
                setChanged();
                notifyObservers(currentP);
            } else {
                generateCurrentMatch();
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Boolean notMatchedBefore(Match match) {
        return !matches.contains(match);
    }

    public Match getCurrentMatch() {
        return currentMatch;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Player getWhoseTurn() {
        return whoseTurn;
    }
}
