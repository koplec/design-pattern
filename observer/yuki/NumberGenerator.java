import java.util.ArrayList;
import java.util.List;

//NumberGeneratorにobserverのNotifierの役割まで持たせているのは、過剰にも感じる

public abstract class NumberGenerator {
    //自分が通知するobserverを管理
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            //引数に自分自身を渡して、自分自身の情報をobserverに伝える
            //eventをわたすよりもおおざっぱに渡している
            observer.update(this);
        }
    }

    public abstract int getNumber();
    public abstract void execute();
}
