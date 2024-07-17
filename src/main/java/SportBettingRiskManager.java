import java.io.*;
import java.util.*;

public class SportBettingRiskManager {

    List<Bet> bets = new ArrayList<>();

    public void run() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to SportBettingRiskManager, where you can manage your bets and manage risk of your deposit!");

        while (true) {
            System.out.println("\nCo chcesz zrobić?");
            System.out.println("1. Dodaj zaklad pojedyńczy ");
            System.out.println("2. Dodaj zakład AKO");
            System.out.println("3. Wyswietl zaklady");
            System.out.println("4. Zakoncz");
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
                    viewBets();
                    break;
                case 4:
                    System.out.println("Thank you for using SportBettingRiskManager!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    public void addSingleBet(Scanner scanner) {
        System.out.println("Podaj typ : ");
        String title = scanner.nextLine();
        System.out.println("Podaj kwote : ");
        float amount = Float.parseFloat(scanner.nextLine());
        System.out.println("Podaj kurs : ");
        float odds = Float.parseFloat(scanner.nextLine());
        System.out.println("Podaj date : ");
        String date = scanner.nextLine();
        System.out.println("Zakład został przyjęty.");
        Bet bet = new Bet(title, amount, odds, date);
        bets.add(bet);

    }

    public void addAKOBet(Scanner scanner)  {
        boolean cont = true;
        float newOdds = 1;
        while (cont) {
            int licznik = 1;
            System.out.println("Podaj typ : ");
            String title = scanner.nextLine();
            System.out.println("Podaj kwote : ");
            float amount = Float.parseFloat(scanner.nextLine());
            System.out.println("Podaj kurs : ");
            float odds = Float.parseFloat(scanner.nextLine());
            System.out.println("Podaj date : ");
            String date = scanner.nextLine();
            System.out.println("Kontynuujemy? Odpowiedz tak lub nie");
            String doWeContinue = scanner.nextLine();
            licznik++;
            if(doWeContinue.equalsIgnoreCase("tak")) {
                System.out.println("Podaj typ : ");
                String title2 = scanner.nextLine();
                String newTitle = title+title2;
                System.out.println("Podaj kurs : ");
                Float odds2 = Float.parseFloat(scanner.nextLine());
                for (int i = 0; i < licznik-1; i++) {
                    newOdds *= odds;
                }
                System.out.println("Podaj date : ");
                String date2 = scanner.nextLine();
            } else {
                cont = false;
            }


            Bet bet = new Bet(title, amount, newOdds, date);
            bets.add(bet);
            System.out.println("Końcowy kurs : " +odds);

        }
    }

    public void viewBets() {
        bets.forEach(bet -> {
            System.out.println(bet.title);
            System.out.println(bet.amount);
            System.out.println(bet.odds);
            System.out.println(bet.date);
        });

    }

}

