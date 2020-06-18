package com.example.radek.cuadernodeespanol;

public class Phrase {

    private String polish;
    private String spanish;

    public Phrase(String polish, String spanish) {
        this.polish = polish;
        this.spanish = spanish;
    }

    public String getPolish() {
        return polish;
    }

    public String getSpanish() {
        return spanish;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "polish='" + polish + '\'' +
                ", spanish='" + spanish + '\'' +
                '}';
    }
}
