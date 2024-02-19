//実装のクラス階層
public class StringDisplayImpl extends DisplayImpl{
    private String string;
    private int width;

    public StringDisplayImpl(String string){
        this.string = string;
        //文字列のバイト数を幅として保存
        this.width = string.getBytes().length;
    }

    public void rawOpen(){
        printLine();
    }

    public void rawPrint(){
        System.out.println("|" + string + "|");
    }

    public void rawClose(){
        printLine();
    }

    private void printLine(){
        System.out.print("+");
        for(int i = 0; i < width; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
