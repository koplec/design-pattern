public class StringDisplay extends Display{
    private String string;
    public StringDisplay(String string){
        this.string = string;
    }

    @Override
    public int getColumns() {
        // return string.getBytes().length;
        // return string.length();
        //全角の場合は2倍必要
        int col = 0;
        for(char ch : string.toCharArray()){
            if (Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS //漢字
            || Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.HIRAGANA //ひらがな
            || Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.KATAKANA //カタカナ
            || Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION //全角の句読点
            ){
                col += 2;
            }else{
                col += 1;
            }
        }
        return col;
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
