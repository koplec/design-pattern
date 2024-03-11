public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);
       
        // 連鎖の形成
        // MainがClient役として働いて、連鎖を掲載している
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        // 異なる番号のトラブル発生
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
