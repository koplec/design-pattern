import java.util.Random;

public class WinningStrategy implements Strategy{

    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed){
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if(!won){
            //負けたら乱数を振って手を変える
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
