package week05.example02;

/**
 * 접근제어자, 상속
 */

public class TestMain {
    public static void main(String[] args) {
//        Ticket ticket1 = new Ticket(1, 1000);
//        System.out.println(ticket1);
//        ticket1.setPrice(2000);
//        System.out.println(ticket1);
//
//        GeneralTicket ticket1 = new GeneralTicket(1, 1000.0, false);
//        GeneralTicket ticket2 = new GeneralTicket(2, 2000.0, true);
//        System.out.println(ticket1);
//        System.out.println(ticket2);

        AdvanceTicket ticket1 = new AdvanceTicket(1, 1000.0, 32);
        AdvanceTicket ticket2 = new AdvanceTicket(2, 1000.0, 15);
        System.out.println(ticket1);
        System.out.println(ticket2);
    }
}
