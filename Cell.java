class Cell{

    private boolean isOpened = false;
    private boolean isFlagged = false;
    private boolean isBombed = false;
    private String symbol;
    private int neighboors;

    public int getNeighboors() {
        return neighboors;
    }

    public void setNeighboors(int neighboors) {
        this.neighboors = neighboors;
    }

    public Cell(boolean isF, boolean isB){
        this.setBombed(isB);
        this.setFlagged(isF);
        this.setSymbol("#");
        this.neighboors = 0;

    }




    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
        if(!isFlagged)this.setSymbol("f");
    }

    public boolean isBombed() {
        return isBombed;
    }

    public void setBombed(boolean bombed) {
        isBombed = bombed;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }
}