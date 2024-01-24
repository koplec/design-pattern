import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        //Mainから見れば、FactoryとProductの使い方さえ知っておけば、IDCardFactoryとIDCardの使い方は知らなくても良い。

        Factory factory = new IDCardFactory();
        Product card1 = factory.create("田中太郎");
        Product card2 = factory.create("中村次郎");
        Product card3 = factory.create("山田花子");
        System.out.println("------------------");
        card1.use();
        card2.use();
        card3.use();

        System.out.println("------------------");
        IDCardFactory idcardFactory = (IDCardFactory)factory;
        System.out.println(idcardFactory.getOwners());

    }
}
