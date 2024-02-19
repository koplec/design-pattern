//機能クラス階層
//Displayクラスのサブクラスで、Displayから機能を追加した
public class CountDisplay extends Display {
    //実装を参照しているのは、もとのDisplayクラスと変わらない
    public CountDisplay(DisplayImpl impl){
        super(impl);
    }

    //新機能
    public void multiDisplay(int times){
        open();
        for(int i = 0; i < times; i++){
            print();
        }
        close();
    }
}