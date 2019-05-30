public class Offline implements IState {

    private MovieDownloader movieDownloader;

    public Offline(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void internetOff() {
        System.out.println();
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
