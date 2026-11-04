package edu.agh.wfiis.solid.tasks.task1;

// coraz dłuższy łańcuch dziedziczenia: User -> SolidPoints -> PointsViewer; "PointsViewer" to też inna abstrakcja niż rola CodeReviewer
public class PointsViewer extends SolidPoints {
    public PointsViewer(String name) {
        super(name);
    }

    // po cichu ignoruje punkty: nie rzucamy, więc "nie trzeba obsługiwać błędów", ale jako User biznesowo powinien móc je dostać (LSP)
    @Override
    public void earnPoints(int points) {
    }

    public void viewPoints(User user) {
        System.out.println(user.name + " has " + getTotalPoints() + " points."); // bug: getTotalPoints() woła się na viewerze (zawsze 0, bo earnPoints nic nie robi), a nie na oglądanym user
    }
}