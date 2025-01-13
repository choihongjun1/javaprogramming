package week06.example01;

public class TicketManager {
    private String name; // 공연 이름
    private final int NUMBER; // 좌석 수
    private Ticket[] tickets;
    private int count = 0;

    public void showGeneralTicket(boolean payByCredit) {
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                if (ticket instanceof GeneralTicket) {
                    GeneralTicket t = (GeneralTicket) ticket;
                    if (t.isPayByCredit() == payByCredit)
                        System.out.println(t);
                }
            } else break;
        }
    }

    public TicketManager(int NUMBER, String name) {
        this.NUMBER = NUMBER;
        this.name = name;
        if (this.NUMBER > 0)
            this.tickets = new Ticket[this.NUMBER];
    }

    public void register(Ticket ticket) {
        if (this.count < this.NUMBER)
            this.tickets[count++] = ticket;
        else
            System.out.println("티켓 판매 종료");
    }


    public double getTotal() {
        double total = 0.0;
        for (Ticket ticket : tickets) {
            if (count > 10) total += ticket.getPrice();
            else break;
        }
        return total;
    }

    @Override
    public String toString() {
        String str = "공연명 :" + this.name + "\n";
        str += "좌석수 : " + this.NUMBER + "\n";
        str += "판매된 좌석수 : " + this.count + "\n";
        str += "-".repeat(20) + "\n";
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                str += ticket.toString() + "\n";
                str += "*".repeat(20) + "\n";
            } else break;
        }
        str += "총 판매금액 : " + this.getTotal() + "\n";
        return str;
    }
}

