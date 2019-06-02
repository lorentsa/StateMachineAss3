import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MovieDownloader movieDownloader = new MovieDownloader();

        String s;
        do {
            System.out.println("\nHello User,\n" + "please choose what you want the machine to do: (press only the number of the option)\n" + "1. Turn on\n" + "2. Turn off\n" + "3. Internet on\n" + "4. Internet off\n" + "5. File request\n" + "6. Download aborted\n" + "7. Download error\n" + "8. Error fixed\n" + "9. Movie on\n" + "10. Restart movie\n" + "11. Hold movie\n" + "12. Movie off\n" + "13. Resume\n" +"14. Set storage size\n" +"15. Set file size\n" +"16. Set movie length\n" + "17. Exit\n");
            System.out.print("Your input is:");
            Scanner f = new Scanner(System.in);
            s = f.next();
            switch (s) {
                case "1":
                    movieDownloader.turnOn();
                    break;
                case "2":
                    movieDownloader.turnOff();
                    break;
                case "3":
                    movieDownloader.internetOn();
                    break;
                case "4":
                    movieDownloader.internetOff();
                    break;
                case "5":
                    movieDownloader.fileRequest();
                    break;
                case "6":
                    movieDownloader.downloadAborted();
                    break;
                case "7":
                    movieDownloader.downloadError();
                    break;
                case "8":
                    movieDownloader.errorFixed();
                    break;
                case "9":
                    movieDownloader.movieOn();
                    break;
                case "10":
                    movieDownloader.restartMovie();
                    break;
                case "11":
                    movieDownloader.holdMovie();
                    break;
                case "12":
                    movieDownloader.movieOff();
                    break;
                case "13":
                    movieDownloader.resume();
                    break;
                case "14":
                    System.out.println("What is the size you want to set to the storage?");
                    String sizeOfStorage = f.next();
                    double storageSize=100;
                    try {
                        storageSize = Double.parseDouble(sizeOfStorage);
                    }
                    catch (Exception e){
                        System.out.println("not a number");
                    }
                    movieDownloader.setStorage(storageSize);
                    break;
                case "15":
                    System.out.println("What is the size you want to set to the file?");
                    String sizeOfFile = f.next();
                    double fileSize=10;
                    try {
                        fileSize = Double.parseDouble(sizeOfFile);
                    }
                    catch (Exception e){
                        System.out.println("not a number");
                    }
                    movieDownloader.setFileSize(fileSize);
                    break;
                case "16":
                    System.out.println("What is the length you want to set to the movie?");
                    String lntOfMovie = f.next();
                    int movieLnt=60;
                    try {
                        movieLnt = Integer.parseInt(lntOfMovie);
                    }
                    catch (Exception e){
                        System.out.println("not a number");
                    }
                    movieDownloader.setMovieLength(movieLnt);
                    break;
                case "17":
                    break;
            }
            /*try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        while (!s.equals("17"));
    }
}