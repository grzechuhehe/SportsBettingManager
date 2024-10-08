import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsBettingManager {

    List<Bet> bets = new ArrayList<>();
    List<Bet> betsAKO = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {

        System.out.println("Welcome to SportBettingRiskManager, where you can manage your bets and manage risk of your deposit!");

        while (true) {
            System.out.println("\nCo chcesz zrobić?");
            System.out.println("1. Dodaj zaklad pojedynczy ");
            System.out.println("2. Dodaj zakład AKO");
            System.out.println("3. Wyswietl zaklady pojedyńcze");
            System.out.println("4. Wyswietl zaklady AKO");
            System.out.println("5. Zakoncz");
            System.out.println();
            System.out.print("Wybieram : ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addSingleBet();
                    break;
                case 2:
                    addAKOBet();
                    break;
                case 3:
                    viewSingleBets();
                    break;
                case 4 :
                    viewAKOBets();
                case 5:
                    System.out.println("Dziekujemy za skorzystanie z aplikacji");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Nieprawidlowy wybor!");
            }
        }
    }

    private String setTitle() {
        System.out.println("Podaj nazwe zakładu : ");
        return scanner.nextLine();
    }

    private float setAmount() {
        while(true) {
            try {
                System.out.println("Podaj kwote : ");
                float amount = Float.parseFloat(scanner.nextLine());
                if(amount > 0) {
                    return amount;
                }
                System.out.println("Wartość zakładu musi być większa od 0");
            } catch(NumberFormatException e) {
                System.out.println("Kwota musi być liczbą.");
            }
        }
    }

    private float setOdds() {
        while(true) {
            try {
                System.out.println("Podaj kurs : ");
                float odds = Float.parseFloat(scanner.nextLine());
                if(odds >= 1) {
                    return odds;
                }
                System.out.println("Kurs musi być większy od 1 ");
            } catch(NumberFormatException e) {
                System.out.println("Kurs musi być liczbą");
            }
        }
    }

    public String setDate() {
        while (true) {
            System.out.println("Wpisz date zakładu o formacie dd.MM.yyyy:");
            try {
                String inputDate = scanner.nextLine();
                LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                return inputDate;
            } catch (DateTimeParseException e) {
                System.out.println("Niepoprawny format daty, data musi być w formacie dd.MM.yyyy!");
            }
        }
    }

    
    public void addSingleBet() {
        String title = setTitle();
        float amount = setAmount();
        float odds = setOdds();
        String date = setDate();
        Bet bet = new Bet(title,amount,odds,date);
        bets.add(bet);
        System.out.println("Poprawnie dodano zakład");
    }


    public Float calculateTotalOdds(ArrayList<Float> oddsAKO) {
        Float odds = 1f;
        for(int i = 0; i < oddsAKO.size(); i++) {
            odds *= oddsAKO.get(i);
        }
        return odds;
    }

    public void addAKOBet() {
        String cont;
        boolean doWeContinue = true;
        StringBuilder title = new StringBuilder();
        StringBuilder date = new StringBuilder();
        float odds;
        float amount;
        ArrayList<Float> oddsAKO = new ArrayList<>();
        title.append(setTitle());
        amount = setAmount();
        oddsAKO.add(setOdds());
        date.append(setDate());

        while(doWeContinue) {
            System.out.println("Jeśli chcesz kontynuować, wpisz TAK.");
            cont = scanner.nextLine();
            if(cont.equalsIgnoreCase("tak")) {
                title.append(STR."\{setTitle()}").append(" ");
                oddsAKO.add(setOdds());
                date.append(STR."\{setDate()}").append(" ");
            } else {
                odds = calculateTotalOdds(oddsAKO);
                doWeContinue = false;
                Bet betAKO = new Bet(title.toString(),amount,odds, date.toString());
                betsAKO.add(betAKO);
                System.out.println("Poprawnie dodano zakład");
            }

        }
    }


    public void viewSingleBets() {
        bets.forEach(bet -> {
            System.out.println(bet.getTitle());
            System.out.println(STR."\{bet.getAmount()}zł");
            System.out.println(bet.getOdds());
            System.out.println(bet.getDate());
            System.out.println();
        });
    }

    public void viewAKOBets() {
        betsAKO.forEach(betAKO -> {
            System.out.println(STR."\{betAKO.getTitle()} ");
            System.out.println(STR."\{betAKO.getAmount()}zł");
            System.out.println(STR."\{betAKO.getOdds()}");
            System.out.println(STR."\{betAKO.getDate()}");
        });
    }
}