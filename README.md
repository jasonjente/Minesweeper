# Minesweeper
Minesweeper game, written in java.

Purpose of the game is to avoid any bombs, either by flagging them or by clicking on the empty cells.
This a work in progress keep in mind.
On the first upload I created the Board entity that holds an array of Cells. Both Cells and Board are the main classes of this program.
The Board Class, initializes the cells in its constructor with some characteristics like size or difficulty, being imported as parameters from user input.
Game class, handles the board itself and the game logic that will be implemented.

I am also running a 2d boolean array (bombarray, each cell is either true or false, does it have bomb or not)  and a 2d integer array where I calculate 
all the neighbooring bombs which helps for with the execution of the expansion which happens when a player hits an empty cell with no neighborign bombs.
