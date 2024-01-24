package framework;

// 工場とは、createメソッドでProductインスタンスを作るもの
public abstract class Factory {
    // createProductで製品を作る
    // registerProductで製品を登録する
    // create自体は、finalでオーバーライドできない
    // template methodパターンを利用している。
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
