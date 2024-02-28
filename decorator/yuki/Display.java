public abstract class Display {
    public abstract int getColumns(); //横の文字数
    public abstract int getRows(); //縦の行数
    public abstract String getRowText(int row); //row番目の文字列

    public final void show(){
        for(int i = 0; i < getRows(); i++){
            System.out.println(getRowText(i));
        }
    }
}