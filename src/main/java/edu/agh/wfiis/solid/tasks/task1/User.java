package edu.agh.wfiis.solid.tasks.task1;

public class User { // user pewnie powinien być prostszym modelem? który prościej pokazuje intencję twórcy?
    // plus: klasa jest spójna (kohezyjna) - pole z punktami ma komplet metod do manipulowania nim
    // minus: pola protected = każda podklasa (i cała paczka) ma do nich bezpośredni dostęp z pominięciem walidacji w earn/subtract, enkapsulacja złamana (np. CodeReviewer robi user.solidPoints + 10)
    protected int solidPoints;
    protected String name;

    public User(String name) {
        this.name = name;
        // niezmiennik: solidPoints >= 0; earnPoints dodaje 1-99 naraz (points < 100), subtractPoints może zabrać wszystko naraz - taki komentarz by się tu przydał
        // ten poniżej jest mylący: start od 0, a 0 to nie "positive", i "1-100" się nie zgadza z warunkiem w kodzie
        this.solidPoints = 0; // points should be a positive number and earned in increments of 1-100 points but not more than 100 points at a time
    }

    public void earnPoints(int points) {
        // rzucamy wyjątek i łapiemy go w tym samym bloku = wyjątki do sterowania logiką; wołający nigdy się nie dowie, że się nie udało
        // sam wyjątek przy złamaniu niezmiennika jest ok (nie zamiatamy pod dywan), ale powinien wyjść na zewnątrz, a lepiej jeszcze walidować przed wywołaniem
        try {
            if (points > 0 && points < 100) {
                this.solidPoints += points; // niezmiennik zachowany, chyba że overflow - a ten w Javie nie rzuca wyjątku, tylko po cichu się przekręca
            } else {
                throw new IllegalArgumentException("Points must be positive and no more than 100.");
            }
        } catch (IllegalArgumentException e) { // hmmm, rozwiązujemy problemy które sami sobie stworzyliśmy, jeżeli nam płacą za linijki kodu to ok
            System.out.println("Error: " + e.getMessage()); // połykamy wyjątek, i to jeszcze na System.out, a nie System.err
        } catch (Exception e) { // hmm, dodajemy inta do inta, co może pójść nie tak?
            System.out.println("General error occurred while earning points.");
        }
    }


    public void subtractPoints(int points) {
        try {
            if (points > 0 && points <= this.solidPoints) {
                this.solidPoints -= points;
            } else {
                throw new IllegalArgumentException("Invalid points."); // "Invalid points." nic nie mówi, jeszcze gorzej niż komunikat w earnPoints
            }
        } catch (IllegalArgumentException e) { // jw.
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) { // nadmierne defensywne programowanie - zabezpieczanie się na przypadki, których nie ma, tylko zaciemnia kod
            System.out.println("General error occurred while subtracting points.");
        }
    }

    // sporne: albo wystawia stan wewnętrzny 1:1 w formie, w jakiej jest przechowywany (łamie enkapsulację), albo to zwykła operacja biznesowa
    // tak czy siak: jeśli jest getter, to po co displayPoints (i odwrotnie); analogicznie reset vs ogólny set(0)
    public int getTotalPoints() {
        return this.solidPoints;
    }

    public void displayPoints() { // może potrzebne? ale w sumie YAGNI i czemu to jest tu a nie w SolidPoints?
        System.out.println("Total SOLID points: " + this.solidPoints);
    }

    public void resetPoints() { // może potrzebne? chociaż YAGNI bo nikt tego nie używa, a zawsze można zrobić subtractPoints(getTotalPoints())
        this.solidPoints = 0;
    }
}
