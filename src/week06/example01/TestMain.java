package week06.example01;

/**
 * 다형성
 */

public class TestMain {
    public static void main(String[] args) {
        TicketManager manager = new TicketManager(10, "아이유 콘서트");
//        manager.register(new Ticket(101, 1000));
        manager.register(new GeneralTicket(102, 1000, true));
        manager.register(new GeneralTicket(103, 2000, false));
        manager.register(new AdvanceTicket(104, 5000, 60));
        manager.register(new AdvanceTicket(105, 2000, 20));
        manager.register(new GeneralTicket(106, 4000, true));

        manager.showGeneralTicket((false));
//        System.out.println(manager);
//
//        Ticket t1 = new GeneralTicket(1,
//                1000.0, false);
//        System.out.println(t1);
//
//        Ticket ticket1 = new Ticket(1, 1000);
//        System.out.println(ticket1);
//        ticket1.setPrice(2000);
//        System.out.println(ticket1);
//
//        GeneralTicket ticket1 = new GeneralTicket(1,
//                1000.0, false);
//        GeneralTicket ticket2 = new GeneralTicket(2,
//                2000.0, true);
//        System.out.println(ticket1);
//        System.out.println(ticket2);
//
//        AdvanceTicket ticket1 = new AdvanceTicket(1,
//                1000.0, 32);
//        AdvanceTicket ticket2 = new AdvanceTicket(2,
//                1000.0, 15);
//        System.out.println(ticket1);
//        System.out.println(ticket2);
    }
}
