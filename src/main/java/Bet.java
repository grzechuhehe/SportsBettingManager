public class Bet {

    private String title;
    private Float amount;
    private Float odds;
    private String date;


    Bet(String title, float amount, float odds, String date) {
        this.title = title;
        this.amount = amount;
        this.odds = odds;
        this.date = date;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Float getAmount() {
        return this.amount;
    }


    public final Float getOdds() {
        return this.odds;
    }

    public final String getDate() {
        return this.date;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setOdds(Float odds) {
        this.odds = odds;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
