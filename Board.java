class Board {
    private int size;
    private int difficulty;
    private Cell[][] map;
    private boolean hasinitialized;
    private boolean[][] bombmap;
    private int[][] neighboorsmap;

    public Board(int difficulty , int size ) {
        this.size = size;
        this.difficulty = difficulty;
        hasinitialized = false;
        map = new Cell[size][size];
        bombmap = new boolean[size][size];
        neighboorsmap = new int[size][size];
        System.out.println("Preparing your board, game will start now.\nGood Luck!");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = new Cell(false, false);
                double check = 1 - Math.random();
                if (check < thresholdDiff()) {
                    map[i][j].setBombed(true);
                    bombmap[i][j] = true;
                }
            }
        }
        setNeighboorsmap();
    }

    public void printBoard(){
        System.out.print("  ");
        for(int i=1;i<=size;i++) { System.out.print(" "+ i );}
        System.out.println();
        for(int i=0;i<size;i++) {
            if(i<9) {
                System.out.print(i + 1 + " ");
            }else{
                System.out.print(i + 1 + "");
            }
            for (int j = 0; j < size; j++) {
                if(!map[i][j].isOpened()) {
                    System.out.print("|" + map[i][j].getSymbol());
                }else{
                    System.out.print("|" + map[i][j].getNeighboors());
               }
            }
            System.out.println();
        }
    }

    public void printBoardBombs(){

        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j].isBombed()) {
                    System.out.print("B");
                }else{
                    System.out.print("x");
                }
            }
            System.out.println();
        }
    }
    private double thresholdDiff() {
        double threshold;
        if(difficulty<3){
            threshold = 0.1;
        }else if(difficulty<=5){
            threshold = 0.2;
        }else{
            threshold = 0.3;
        }
        return threshold;

    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Cell[][] getMap() {
        return map;
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }

    public boolean isHasinitialized() {
        return hasinitialized;
    }

    public void setHasinitialized(boolean hasinitialized) {
        this.hasinitialized = hasinitialized;
    }
    public boolean[][] getBombmap() {
        return bombmap;
    }

    public void setBombmap(boolean[][] bombmap) {
        this.bombmap = bombmap;
    }

    public int[][] getNeighboorsmap() {
        return neighboorsmap;
    }

    public void setNeighboorsmap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int count = 0;
                try{
                    if(bombmap[i-1][j-1]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }

                try{
                    if(bombmap[i-1][j]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
                try{
                    if(bombmap[i-1][j+1]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
                try{
                    if(bombmap[i][j-1]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
                try{
                    if(bombmap[i][j+1]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
                try{
                    if(bombmap[i+1][j-1]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
                try{
                    if(bombmap[i][j]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
                try{
                    if(bombmap[i+1][j+1]){
                        count++;
                    }
                }catch (ArrayIndexOutOfBoundsException err){

                }
                neighboorsmap[i][j] = count;
            }
        }
    }
}