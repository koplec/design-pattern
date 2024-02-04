package framework;

public interface Product extends Cloneable{
    // サブクラスの実装に任せるけど、とにかく「使う」
    public abstract void use(String s);

    // 複製する
    public abstract Product createClone();
}