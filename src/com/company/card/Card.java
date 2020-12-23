package com.company.card;

public class Card {
    private String question;
    private Category category;

    public Card(String question, Category category) {
        this.question = question;
        this.category = category;
    }

    public String getQuestion() {
        return this.question;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return question.equals(card.question);
    }

    @Override
    public int hashCode() {
        return question.hashCode();
    }
}
