package week06.example01;

public class GeneralTicket extends Ticket {
    private boolean payByCredit;

    public GeneralTicket(int number, boolean payByCredit) {
        super(number);
        this.payByCredit = payByCredit;
    }

    public GeneralTicket(int number, double price, boolean payByCredit) {
        super(number, price);
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
            return this.price * 1.1;
        else
            return this.price;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += "\n카드결재 : " + this.isPayByCredit();
        str += "\n결재금액 : " + this.getPrice() + "\n";
        return str;
    }
}
