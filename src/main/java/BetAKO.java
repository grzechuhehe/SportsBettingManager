import java.time.LocalDate;

public class BetAKO {
    private String title;
    private Float amount;
    private Float odds;
    public String date;


    BetAKO(String title, Float amount, Float odds, String date) {
    this.title = title;
    this.amount = amount;
    this.odds = odds;
    this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public Float getOdds() {
        return this.odds;
    }

    public Float getAmount() {
        return this.amount;
    }

    public String getTitle() {
        return this.title;
    }
}
