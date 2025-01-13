package week05.example02;

public class GeneralTicket extends Ticket {
    private boolean payByCredit;

    public GeneralTicket(int number, double price, boolean payByCredit) {
        super(number, price);
        this.payByCredit = payByCredit;
    }

    public GeneralTicket(int number, boolean payByCredit) {
        super(number);
        this.payByCredit = payByCredit;
    }

    public boolean isPayByCredit() {
        return payByCredit;
    }

    public void setPayByCredit(boolean payByCredit) {
        this.payByCredit = payByCredit;
    }

    @Override
    public double getPrice() {
        if (this.isPayByCredit())
            return super.getPrice() * 1.1;
        else
            return super.getPrice();
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "\n카드결제 : " + this.isPayByCredit();
        str += "\n결제금액 : " + this.getPrice() + "\n";
        return str;
    }
}
