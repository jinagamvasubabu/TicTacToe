package com.vasu;

import java.util.Scanner;

import static com.vasu.State.O;
import static com.vasu.State.X;
import static com.vasu.State.blank;

public class TicTacToe implements ITicTacToe {
    private int n;
    private Board boardChart;

    TicTacToe(int n, char[][] board) {
        this.n = n;
        this.boardChart = new Board(n, board);
    }

    String startGame() {
        Integer playerChoice = 0; // Initially X
        boardChart.fillBoardInitiallyWithBlankSpaces();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (playerChoice % 2 == 0) {
                    System.out.println("It's X's choice !!!");
                    Boolean isWin = readInputAndDecideGame(X.getChar());
                    if (isWin) {
                        return "X Won !!!";
                    }
                } else {
                    System.out.println("It's O's choice !!!");
                    Boolean isWin = readInputAndDecideGame(O.getChar());
                    if (isWin) {
                        return "O Won !!!";
                    }
                }
                playerChoice++;
            }
        }
        return "Match tied !!!";
    }

    public Boolean checkMoveIsLegal(int x, int y) {
        return (x < n && y < n) && (boardChart.getCharOnPosition(x,y) == blank.getChar());
    }

    public Boolean checkIsItWinOrDraw(int x, int y, char state) {
        Boolean result = boardChart.checkRowsLeadToWin(x, state);
        if (result) return true;

        result = boardChart.checkColumnsLeadToWin(y, state);
        if (result) return true;

        result = boardChart.checkDiagonalsLeadsToWin(x, y, state);
        if (result) return true;

        result = boardChart.checkAntiDiagonalsLeadsToWin(x, y, state);

        return result;
    }

    private Boolean readInputAndDecideGame(char C) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (checkMoveIsLegal(x, y)) {
            boardChart.placeCharOnBoard(x,y,C);
            boardChart.displayBoard();
            if (checkIsItWinOrDraw(x, y, C)) {
                return true;
            }

        } else {
            System.out.println("Wrong choice!!!!");
            boardChart.displayBoard();
        }
        return false;
    }
}


