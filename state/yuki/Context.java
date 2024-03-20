//金庫の状態変化を管理するインターフェース
//警備センターとの連絡を取るインターフェース
public interface Context {
    /**
     * 時刻を設定する
     * 
     * @param hour
     */
    public void setClock(int hour);

    /**
     * 状態を変化させる
     * 
     * @param state
     */
    public void changeState(State state);

    /**
     * 警備センターを呼ぶ
     * 
     * @param msg
     */
    public void callSecurityCenter(String msg);

    /**
     * 警備センター記録
     * 
     * @param msg
     */
    public void recordLog(String msg);
}
