import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MovieDownloader movieDownloader = new MovieDownloader();

        String s;
        int i;
        do {
            System.out.println("\nHello User,\n" + "please choose what you want the machine to do: (press only the number of the option)\n" + "1. Turn on\n" + "2. Turn off\n" + "3. Internet on\n" + "4. Internet off\n" + "5. File request\n" + "6. Download aborted\n" + "7. Download error\n" + "8. Error fixed\n" + "9. Movie on\n" + "10. Restart movie\n" + "11. Hold movie\n" + "12. Movie off\n" + "13. Resume\n" +"14. Set storage size\n" +"15. Set file size\n" +"16. Set movie length\n" + "17. Exit\n");
            System.out.print("Your input is:");
            Scanner f = new Scanner(System.in);
            s = f.next();
            System.out.println("The output is:");
            switch (s) {
                case "1":
                    movieDownloader.turnOn();
                case "2":
                    movieDownloader.turnOff();
                case "3":
                    movieDownloader.internetOn();
                case "4":
                    movieDownloader.internetOff();
                case "5":
                    movieDownloader.fileRequest();
                case "6":
                    movieDownloader.downloadAborted();
                case "7":
                    movieDownloader.downloadError();
                case "8":
                    movieDownloader.errorFixed();
                case "9":
                    movieDownloader.movieOn();
                case "10":
                    movieDownloader.restartMovie();
                case "11":
                    movieDownloader.holdMovie();
                case "12":
                    movieDownloader.movieOff();
                case "13":
                    movieDownloader.resume();
                /*case "14":
                    System.out.println("What is the size you what to set to the storage?");
                    String sizeOfStorage = f.next();
                    int storageSize=100;
                    try {
                        storageSize = Integer.parseInt(sizeOfStorage);
                    }
                    catch (Exception e){
                        System.out.println("not a number");
                    }
                    movieDownloader.setStorage(storageSize);*/
                case "17":
                    break;
            }
        }
        while (!s.equals("17"));
    }
}