package com.vasu;

public enum State {

    X('X'),
    O('O'),
    blank('-');

    private char C;

    State(char c) {
        C = c;
    }

    public char getChar() {
        return C;
    }
}
