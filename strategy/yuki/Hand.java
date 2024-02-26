import java.util.HashMap;
import java.util.Map;

public class Hand {
    public static enum HandType {
        GUU("グー", 0),
        CHOKI("チョキ", 1),
        PAA("パー", 2);

        private String name;
        private int value;

        private HandType(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
    private static final Map<HandType, Hand> handMap = new HashMap<HandType, Hand>();
    static {
        handMap.put(HandType.GUU, new Hand(HandType.GUU));
        handMap.put(HandType.CHOKI, new Hand(HandType.CHOKI));
        handMap.put(HandType.PAA, new Hand(HandType.PAA));
    }
    private HandType handType;

    private Hand(HandType handType) {
        this.handType = handType;
    }

    public static Hand getHand(int value) {
        switch (value) {
            case 0:
                return handMap.get(HandType.GUU);
            case 1:
                return handMap.get(HandType.CHOKI);
            case 2:
                return handMap.get(HandType.PAA);
            default:
                return null;
        }
    }

    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand other) {
        if (this == other) {//singleton
            return 0;
        } else if ((this.handType == HandType.GUU && other.handType == HandType.CHOKI) ||
                (this.handType == HandType.CHOKI && other.handType == HandType.PAA) ||
                (this.handType == HandType.PAA && other.handType == HandType.GUU)) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return handType.getName();
    }

}