
public class Bet {

    public String title;
    public float amount;
    public float odds;
    public String date;


    Bet(String title, float amount, float odds, String date) {
        this.title = title;
        this.amount = amount;
        this.odds = odds;
        this.date = date;
    }

    public final String getTitle() {
        return title;
    }

    public final float getAmount() {
        return amount;
    }


    public final float getOdds() {
        return odds;
    }

    public final String getDate() {
        return date;
    }

}
