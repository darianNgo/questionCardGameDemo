package com.company.deck;

import com.company.card.Card;
import com.company.card.Category;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Deck implements Iterable<Card>{
    private String title;
    protected List<Card> cards;
    private Category category;


    public Deck(String title, Category category) {
        this.title = title;
        cards = new ArrayList<>();
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void addCard(Card card) {
        if (!cards.contains(card) && card.getCategory() == this.category) {
            cards.add(card);
        }
    }

    public void removeCard(Card card) {
        if (cards.contains(card)) {
            cards.remove(card);
        }
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
