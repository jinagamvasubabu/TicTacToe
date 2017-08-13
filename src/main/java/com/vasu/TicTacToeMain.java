package com.vasu;

import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Number of rows and columns:");
        int n = scanner.nextInt();
        char[][] board = new char[n][n];
        TicTacToe ticTacToe = new TicTacToe(n , board);
        System.out.println(ticTacToe.startGame());
    }
}
