//飾り枠は中神と同じメソッドを持つ
//飾り枠と中身を同一視する
public abstract class Border extends Display{
    //中身を表すものを委譲として持つ
    protected Display display;
    protected Border(Display display){
        this.display = display;
    }
}
