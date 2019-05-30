public class InternetOffline implements IState {

    private MovieDownloader movieDownloader;

    public InternetOffline(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void internetOff() {
        System.out.println("enter InternetOffline state");
        
        System.out.println("exit InternetOffline state");
    }

    @Override
    public void internetOn() {

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
