package idcard;

import framework.Product;

public class IDCard extends Product{
    private String owner;

    // コンストラクタは、publicをつけないようにして、IDCardFactoryからしか呼び出せないようにする。
    // 直接IDCardを生成させない。
    // packageないだけでアクセスさせて、外部からはnewできないようにすることは大切
    IDCard(String owner){
        System.out.println(owner + "のカードを作ります。");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + "のカードを使います。");
        
    }

    public String getOwner() {
        return owner;
    }
    
}
