import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class SportsBettingManager {

    List<Bet> bets = new ArrayList<>();
    ArrayList<Bet> betsAKO = new ArrayList<>();
    private Float odds;

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SportBettingRiskManager, where you can manage your bets and manage risk of your deposit!");

        while (true) {
            System.out.println("\nCo chcesz zrobić?");
            System.out.println("1. Dodaj zaklad pojedynczy ");
            System.out.println("2. Dodaj zakład AKO");
            System.out.println("3. Wyswietl zaklady pojedyncze");
            System.out.println("4. Wyswietl zaklady AKO");
            System.out.println("5. Zakoncz");
            System.out.println();
            System.out.print("Wybieram : ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 :
                    addSingleBet(scanner);
                    break;
                case 2 :
                    addAKOBet(scanner);
                    break;
                case 3 :
                    viewSingleBets();
                    break;
                case 4 :
                    viewAKOBets();
                    break;
                case 5:
                    System.out.println("Dziekujemy za skorzystanie z aplikacji");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Nieprawidlowy wybor!");
            }
        }
    }


    public void addSingleBet(Scanner scanner) {
        String title="";
        Float amount = 0F;
        Float odds = 1F;
        String dateInput;
        String date = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Bet bet = new Bet(title, amount, odds, date);

        System.out.println("Podaj nazwę typu : ");
        title = scanner.nextLine();

        do {
            try {
                System.out.println("Podaj kwote : ");
                amount = Float.parseFloat(scanner.nextLine());
                if(amount <= 0) {
                    System.out.println("Kwota zakładu nie może być ujemna");
                }
            } catch (NumberFormatException e) {
                System.out.println("Kwota musi być liczbą.");
            }
        } while (amount <= 0);

        do {
            try {
                System.out.println("Podaj kurs : ");
                odds = Float.parseFloat(scanner.nextLine());
                if(odds <= 1) {
                    System.out.println("Kurs zakładu nie może być mniejszy do 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Kurs musi być liczbą.");
            }
        } while (odds <= 1);

        do {
            try {
                System.out.println("Podaj date w formacie dd.MM.yyyy: ");
                dateInput = scanner.nextLine();
                date = String.valueOf(LocalDate.parse(dateInput,formatter));
            } catch (DateTimeParseException e) {
                System.out.println("Niepoprawny format daty, skorzystaj z formatu dd-MM-yyyy");
            }
        } while (Objects.equals(date, ""));

        System.out.println("Zakład został przyjęty.");
        bet.setTitle(title);
        bet.setAmount(amount);
        bet.setOdds(odds);
        bet.setDate(date);

        bets.add(bet);

    }

    public void addAKOBet(Scanner scanner)  {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<Float> newOdds = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        String title="";
        Float amount = 0F;
        Float odds = 1F;
        String dateInput;
        String date = "";
        String d = "";
        boolean cont = true;
        Float o = 1F;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Bet bet = new Bet(title, amount, odds, date);
        System.out.println(bet.getTitle());
        System.out.println(bet.getAmount());
        System.out.println(bet.getOdds());
        System.out.println(bet.getDate());

            System.out.println("Podaj nazwę typu : ");
            title = scanner.nextLine();
            do {
                try {
                    System.out.println("Podaj kwote : ");
                    amount = Float.parseFloat(scanner.nextLine());
                    if (amount <= 0) {
                        System.out.println("Kwota zakładu nie może być ujemna");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Kwota musi być liczbą.");
                }
            } while (amount <= 0);

            do {
                try {
                    System.out.println("Podaj kurs : ");
                    odds = Float.parseFloat(scanner.nextLine());
                    if (odds <= 1) {
                        System.out.println("Kurs zakładu nie może być mniejszy do 1.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Kurs musi być liczbą.");
                }
            } while (odds <= 1);

            do {
                try {
                    System.out.println("Podaj date w formacie dd.MM.yyyy: ");
                    dateInput = scanner.nextLine();
                    date = String.valueOf(LocalDate.parse(dateInput, formatter));
                } catch (DateTimeParseException e) {
                    System.out.println("Niepoprawny format daty, skorzystaj z formatu dd.MM.yyyy");
                }
            } while (Objects.equals(date, ""));

        while (cont) {
            System.out.println("Jeśli chcesz kontynuować, napisz TAK");
            String doWeContinue = scanner.nextLine();
            if (doWeContinue.equalsIgnoreCase("TAK")) {
                System.out.println("Podaj nazwę typu : ");
                String t = scanner.nextLine();
                titles.add(t);

                do {
                    try {
                        System.out.println("Podaj kurs : ");
                        o = Float.parseFloat(scanner.nextLine());
                        if (o <= 1) {
                            System.out.println("Kurs zakładu nie może być mniejszy do 1.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Kurs musi być liczbą.");
                    }
                } while (o <= 1);
                newOdds.add(o);

                do {
                    try {
                        System.out.println("Podaj date w formacie dd.MM.yyyy: ");
                        dateInput = scanner.nextLine();
                        d = String.valueOf(LocalDate.parse(dateInput, formatter));
                    } catch (DateTimeParseException e) {
                        System.out.println("Niepoprawny format daty, skorzystaj z formatu dd.MM.yyyy");
                    }
                } while (Objects.equals(d, ""));
                dates.add(d);

            } else {

                for (String s : titles) {
                    title += STR." \{s} ";
                }
                for (Float newOdd : newOdds) {
                    odds *= newOdd;
                }
                for (String s : dates) {
                    date += STR." \{s} ";
                }
                cont = false;
                System.out.println("Zaklad zostal przyjęty");
                bet.setTitle(title);
                bet.setAmount(amount);
                bet.setOdds(odds);
                bet.setDate(date);

                betsAKO.add(bet);
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
        betsAKO.forEach(bet -> {
            System.out.println(bet.getTitle()+" ");
            System.out.println(bet.getAmount());
            System.out.println(bet.getOdds());
            System.out.println(bet.getDate());
            System.out.println();
        });
        }
}

