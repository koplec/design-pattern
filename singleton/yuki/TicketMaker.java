//問題5-1
public class TicketMaker {
    private int ticket = 1000;

    //multithreadは考慮していない

    private static TicketMaker singleton = new TicketMaker();
    private TicketMaker() {
    }
    public static TicketMaker getInstance() {
        return singleton;
    }
    public synchronized int getNextTicketNumber() {
        return ticket++;
    }

    public static void main(String[] args) {
        TicketMaker ticketMaker = TicketMaker.getInstance();
        System.out.println(ticketMaker.getNextTicketNumber());
        System.out.println(ticketMaker.getNextTicketNumber());
        System.out.println(ticketMaker.getNextTicketNumber());
    }
}
