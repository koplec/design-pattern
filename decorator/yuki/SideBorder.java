public class SideBorder extends Border{
    private char borderChar;
    public SideBorder(Display display, char ch){
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        return this.display.getColumns() + 2;
    }

    @Override
    public String getRowText(int row) {
        return borderChar + this.display.getRowText(row) + borderChar;
    }

    @Override
    public int getRows() {
        return this.display.getRows();
    }
    
}
