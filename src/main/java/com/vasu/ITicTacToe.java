package com.vasu;

interface ITicTacToe {

    Boolean checkMoveIsLegal(int x, int y);

    Boolean checkIsItWinOrDraw(int x, int y, char state);
}
