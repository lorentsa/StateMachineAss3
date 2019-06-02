public class InternetOffline extends On implements IState {

    private MovieDownloader movieDownloader;

    public InternetOffline(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void internetOn() {
        movieDownloader.setCurrStateInternet(movieDownloader.getOnline());
    }

    @Override
    public void entry() {
        System.out.println("enter internetOffline state");
    }

    @Override
    public void exit() {
        System.out.println("exit internetOffline state");
    }








    @Override
    public void internetOff() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }

    @Override
    public void movieOn() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }

    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {

    }
}
