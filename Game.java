import java.util.InputMismatchException;
import java.util.Scanner;

class Game {
    private Board myBoard;


    public Game(int a, int b){
        myBoard = new Board(a,b);
    }
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        Scanner strIn = new Scanner(System.in);
        int a = 0,b=0;
        System.out.println("Welcome");

        System.out.println("Enter 0-3 for easy \n 4-8 for medium \n 9+ for hard");
        try{
             a = myInput.nextInt();
        }catch (InputMismatchException exc){

        }
        System.out.println("Enter a number for size. eg.10");
        try{
            b = myInput.nextInt();
        }catch (InputMismatchException exc){

        }
        Game mygame = new Game(a,b);
        System.out.println("we shall begin now...");
        System.out.println("You will be asked your action,\nOpen cell(type o),Flag cell(f) then press enter\nenter the coordinate X press enter \nthen go for the Y");
       // mygame.myBoard.printBoard();
      //  mygame.myBoard.printBoardBombs();
        System.out.println("");
        String input = "";
        Cell[][] cells;
        boolean first_round=true;
        mygame.myBoard.printBoard();
       mygame.myBoard.printBoardBombs();
        while(true){
            System.out.println("Enter o or f");
            input = strIn.next();
            while(!(input.equals("o")||input.equals("f"))){
                System.out.println("I said: Enter o or f");
                input = strIn.next();
            }
            System.out.println("Enter X");
            a = mygame.ReadIntFromUser();
            System.out.println("Enter Y");
            b = mygame.ReadIntFromUser();
            a--;
            b--;
            cells =  mygame.myBoard.getMap();
            if(input.equals("o")) {
                if (! cells[a][b].isOpened()) {
                    if (! cells[a][b].isBombed()) {
                        if(mygame.myBoard.getNeighboorsmap()[a][b]==0){
                            mygame.expand(a,b);
                        }
                        cells[a][b].setNeighboors(mygame.myBoard.getNeighboorsmap()[a][b]);
                        cells[a][b].setSymbol(new String(String.valueOf(mygame.myBoard.getNeighboorsmap()[a][b])));
                        mygame.myBoard.setMap(cells);
                    } else {
                            if(!first_round) {
                                input = mygame.gameOver();
                                if (input.equals("y")) Game.main(null);
                            }else {
                                cells[a][b].setBombed(false);
                                cells[a][b].setNeighboors(mygame.myBoard.getNeighboorsmap()[a][b]);
                                cells[a][b].setSymbol(new String(String.valueOf(mygame.myBoard.getNeighboorsmap()[a][b])));
                                mygame.myBoard.setNeighboorsmap();
                            }


                    }
                }
                }else{
                    cells[a][b].setSymbol("f");
                    mygame.myBoard.setMap(cells);
                }
            mygame.myBoard.printBoard();
           // mygame.myBoard.printBoardBombs();
            first_round=false;
        }

        }
        //
    public String gameOver(){
        System.out.println(" BOMB ---- GAME OVER ----");
        System.out.println(" try again y/n");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        while (! (input.equals("y") || input.equals("n"))) {
            System.out.println("Enter y or n");
            input = sc.next();

        }
        return input;
    }
    public void expand(int i ,int j){

        try {
            if (this.myBoard.getNeighboorsmap()[i - 1][j - 1] == 0) {
                this.myBoard.getMap()[i-1][j-1].setOpened(true);
                this.myBoard.getMap()[i-1][j-1].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }

        try {
            if (this.myBoard.getNeighboorsmap()[i - 1][j] == 0) {
                this.myBoard.getMap()[i - 1][j].setOpened(true);
                this.myBoard.getMap()[i - 1][j].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }

        try {
            if (this.myBoard.getNeighboorsmap()[i - 1][j + 1] == 0) {
                this.myBoard.getMap()[i - 1][j + 1].setOpened(true);
                this.myBoard.getMap()[i - 1][j + 1].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }
        try {
            if (this.myBoard.getNeighboorsmap()[i][j - 1]== 0) {
                this.myBoard.getMap()[i][j - 1].setOpened(true);
                this.myBoard.getMap()[i][j - 1].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }
        try {
            if (this.myBoard.getNeighboorsmap()[i][j + 1]== 0) {
                this.myBoard.getMap()[i][j + 1].setOpened(true);
                this.myBoard.getMap()[i][j + 1].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }
        try {
            if (this.myBoard.getNeighboorsmap()[i + 1][j - 1]== 0) {
                this.myBoard.getMap()[i + 1][j - 1].setOpened(true);
                this.myBoard.getMap()[i + 1][j - 1].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }

        try {
            if (this.myBoard.getNeighboorsmap()[i + 1][j + 1]== 0) {
                this.myBoard.getMap()[i + 1][j + 1].setOpened(true);
                this.myBoard.getMap()[i + 1][j + 1].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }
        try {
            if (this.myBoard.getNeighboorsmap()[i + 1][j]== 0) {
                this.myBoard.getMap()[i + 1][j].setOpened(true);
                this.myBoard.getMap()[i + 1][j].setSymbol("| ");
            }
        } catch (ArrayIndexOutOfBoundsException err) {

        }



    }
        public int ReadIntFromUser(){
            int a = 1;
            try{
                Scanner myInput = new Scanner(System.in);
               a = myInput.nextInt();
                while(a>this.myBoard.getSize()){
                    System.out.println("a number lower than "+this.myBoard.getSize());
                    a = myInput.nextInt();
                }
            }catch (InputMismatchException exc){
                System.out.println("Enter a number between 1 and "+this.myBoard.getSize());

            }
            return a;
        }

}
