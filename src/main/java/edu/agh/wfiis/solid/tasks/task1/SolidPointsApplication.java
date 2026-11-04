package edu.agh.wfiis.solid.tasks.task1;

// brak wymagań, testów i dokumentacji - trudno nawet stwierdzić, co ma działać inaczej; refaktor małymi krokami (ewolucja, nie rewolucja)
public class SolidPointsApplication {
    public static void main(String[] args) {
        // role nazwane niespójnie: CodeReviewer to rola w zespole, PointsViewer to inna abstrakcja, a "Alice jest SolidPoints" nic nie mówi
        SolidPoints alice = new SolidPoints("Alice");
        CodeReviewer bob = new CodeReviewer("Bob");
        PointsViewer charlie = new PointsViewer("Charlie");

        // komentarze w main tylko powtarzają kod; ratują je jedynie złe nazwy, a łatwiej poprawić nazwy niż dopisywać komentarze "dla nowej osoby"
        // Adding points directly for Alice
        try { // jeden wielki try na całą logikę - nie widać, która metoda co rzuca; ma sens w pętli / obsłudze zapytań / global exception handlerze, tu i tak program się po nim kończy
            // powtórzone earn + println można by zamknąć w pętli, ale to przekombinowanie - lepszy zwyczajnie brzydki, czytelny kod niż udziwniony na siłę
            alice.earnPoints(10);
            System.out.println("Alice's points: " + alice.getSolidPoints());
            alice.earnPoints(20);
            System.out.println("Alice's points: " + alice.getSolidPoints());

            // String zamiast enuma na ocenę kodu; "reviewCode(alice, ...)" - oceniamy Alice czy jej kod?
            // Reviewer Bob reviews code and adds points for Alice
            bob.reviewCode(alice, "excellent"); // Excellent code reviewed
            System.out.println("Alice's points after review: " + alice.getSolidPoints());

            // Viewer Charlie views Alice's points
            charlie.viewPoints(alice);

            // Subtract points for bad review
            bob.reviewCode(alice, "bad"); // Bad code reviewed
            System.out.println("Alice's points after bad review: " + alice.getSolidPoints());

        } catch (IllegalArgumentException e) { // samo getMessage() na System.out: programista traci stack trace, a klient końcowy dostaje techniczny komunikat, który tylko niepokoi - złe w obu światach
            System.out.println("Error: " + e.getMessage());
        } catch (UnsupportedOperationException e) { // łapiemy, bo CodeReviewer.earnPoints go rzuca - patrz komentarz o LSP/ISP tam
            System.out.println("Error: " + e.getMessage());
        }
    }
}