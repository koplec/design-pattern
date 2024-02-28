public class StringDisplay extends Display{
    private String string;
    public StringDisplay(String string){
        this.string = string;
    }

    @Override
    public int getColumns() {
        // return string.getBytes().length;
        return string.length();
        //全角の場合は2倍必要
        
    }

    @Override
    public String getRowText(int row) {
        return (row == 0) ? string : null;
    }

    @Override
    public int getRows() {
        return 1;
    }
    
}
