package edu.agh.wfiis.solid.tasks.task1;

// po co ta klasa? User nie jest abstrakcyjny, więc nie chodzi o instancjonowanie; jedyna różnica: rzuca błędy zamiast je wypisywać
// extends = relacja "is a": SolidPoints JEST użytkownikiem? dziwne; tu pasuje kompozycja ("has a") - użytkownik MA punkty
public class SolidPoints extends User { // DRY; cała ta logika jest już w User, tylko błędy są inne, bez sensu

    public SolidPoints(String name) {
        super(name);
    }

    // to samo co User.getTotalPoints, tylko pod inną nazwą - dlatego nie trzeba @Override i duplikat łatwo przeoczyć (@Override to dobra praktyka)
    public int getSolidPoints() {
        return solidPoints;
    }

    public void earnPoints(int points) {
        if (points > 0 && points < 100) {
            super.earnPoints(points); // try/catch z User nigdy się tu nie wykona, bo walidacja jest powtórzona wyżej - "minus razy minus dał plus"
        } else {
            throw new IllegalArgumentException("Points must be positive and no more than 100.");
        }
    }

    public void subtractPoints(int points) {
        if (points > 0 && points <= this.solidPoints) {
            super.subtractPoints(points);
        } else {
            throw new IllegalArgumentException("Points must be positive."); // ten sam warunek co w User, ale komunikat niepełny i mylący: nie mówi, że nie można odjąć więcej, niż się ma
        }
    }
}
