package com.vasu;

class Board {
    private int n;
    private char[][] board;

    Board(int n, char[][] board) {
        this.n = n;
        this.board = board;
    }

    Boolean checkAntiDiagonalsLeadsToWin(int x, int y, char state) {
        if (x + y == n - 1) {
            for (int i = 0; i < n; i++) {
                if (board[i][(n - 1) - i] != state)
                    break;
                if (i == n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    Boolean checkDiagonalsLeadsToWin(int x, int y, char state) {
        if (x == y) {
            //we're on a diagonal
            for (int i = 0; i < n; i++) {
                if (board[i][i] != state)
                    return false;
                if (i == n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    Boolean checkColumnsLeadToWin(int y, char state) {
        for (int i = 0; i < n; i++) {
            if (board[i][y] != state)
                return false;

            if (i == n - 1) {
                return true;
            }
        }
        return false;
    }

    Boolean checkRowsLeadToWin(int x, char state) {
        for (int i = 0; i < n; i++) {
            if (board[x][i] != state)
                return false;

            if (i == n - 1) {
                return true;
            }
        }
        return false;
    }

    void fillBoardInitiallyWithBlankSpaces() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = State.blank.getChar();
            }
        }
    }

    void displayBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    void placeCharOnBoard(int x, int y, char C) {
        this.board[x][y] = C;
    }

    char getCharOnPosition(int x, int y) {
        return this.board[x][y];
    }

}
