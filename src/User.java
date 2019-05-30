import java.util.LinkedList;
import java.util.List;

public class User {
    private double speed;
    private String degree;
    private int points;
    private String userName;
    private List<String> downloads;

    public User(String userName) {
        points = 0;
        speed = 0.01;
        degree = "Junior";
        this.userName = userName;
        downloads = new LinkedList<>();
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getDegree() {
        return degree;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<String> downloads) {
        this.downloads = downloads;
    }

    public int getPoints() {
        return points;
    }

    public void updatePoints(int points) {
        this.points += points;
        if (this.points < 0)
            this.points = 0;
        updateDegree();
    }

    private void updateDegree() {
        if (points < 4) {
            degree = "Junior";
            speed = 0.01;
        }
        else if (points >= 4  && points < 7) {
            degree = "Advanced";
            speed = 0.012;
        }
        else {
            degree = "Professional";
            speed = 0.015;
        }
    }
}
