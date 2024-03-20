// 金庫の状態を表すインターフェース
public interface State {
    /**
     * 時刻を設定する
     * 
     * @param context
     * @param hour
     */
    public void doClock(Context context, int hour);

    /**
     * 金庫を使用する
     * 
     * @param context
     */
    public void doUse(Context context);

    /**
     * 非常ベルを鳴らす
     * 
     * @param context
     */
    public void doAlarm(Context context);

    /**
     * 通常通話をする
     * 
     */
    public void doPhone(Context context);

}