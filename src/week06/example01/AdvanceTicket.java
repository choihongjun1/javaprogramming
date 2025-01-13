package week06.example01;

public class AdvanceTicket extends Ticket {
    private int advanceDays;

    public AdvanceTicket(int number, double price, int advanceDays) {
        super(number, price);
        this.advanceDays = advanceDays;
    }

    public int getAdvanceDays() {
        return advanceDays;
    }

    public void setAdvanceDays(int advanceDays) {
        this.advanceDays = advanceDays;
    }

    @Override
    public double getPrice() {
        if (this.advanceDays >= 30)
            return this.price * 0.7;
        else if (this.advanceDays >= 20)
            return this.price * 0.8;
        else if (this.advanceDays >= 10)
            return this.price * 0.9;
        else
            return this.price;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n예약일: " + this.getAdvanceDays() + "일 전\n" +
                "결재금액:" + this.getPrice() + "\n";
    }
}

