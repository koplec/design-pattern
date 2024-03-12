public interface Mediator {
    //Mediatorが管理するメンバーを生成する
    public abstract void createColleagues();

    //Mediatorが各メンバーのColleaguesから相談を受ける
    //observerパターンに似ていると思った
    public abstract void colleagueChanged();
}