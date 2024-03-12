public interface Colleague {
    /**
     * Mediatorを設定する
     * ConstructorでMediatorを設定するのではなく、
     * このメソッドでMediatorを設定する
     * なぜなら、Mediatorを設定するタイミングは、
     * 生成後のインスタンスの状態によって変わるため？
     * 
     * @param mediator
     */
    public abstract void setMediator(Mediator mediator);

    /**
     * Mediatorからの指示を受ける
     * Enabledだったら自分自身を有効にする
     * 
     * @param enabled
     */
    public abstract void setColleagueEnabled(boolean enabled);
}
