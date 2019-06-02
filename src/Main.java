public class Main {

    public static void main(String[] args) {
        MovieDownloader movieDownloader = new MovieDownloader();
        movieDownloader.turnOn();
        movieDownloader.internetOn();
        movieDownloader.setFileSize(102);
        movieDownloader.fileRequest();

    }

}
