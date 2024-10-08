public class Bet {
    private String title;
    private float amount;
    private float odds;
    private String date;

    public Bet(String title, float amount, float odds, String date) {
        this.title = title;
        this.amount = amount;
        this.odds = odds;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public float getAmount() {
        return amount;
    }

    public float getOdds() {
        return odds;
    }

}
