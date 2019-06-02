public class PauseMovie implements IState {

    private MovieDownloader movieDownloader;

    public PauseMovie(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void entry() {
        System.out.println("enter pauseMovie state");
    }

    @Override
    public void exit() {
        System.out.println("exit pauseMovie state");
    }

    @Override
    public void internetOn() {
        movieDownloader.setCurrStateWatchingMovie(movieDownloader.getWatchMovie());
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void errorFixed() {
        movieDownloader.setCurrStateWatchingMovie(movieDownloader.getWatchMovie());
    }

    @Override
    public void resume() {
        movieDownloader.setCurrStateWatchingMovie(movieDownloader.getWatchMovie());
    }

    @Override
    public void movieOff() {
        movieDownloader.setCurrStateWatchingMovie(movieDownloader.getWatchingMovieIdle());
    }





    @Override
    public void turnOn() {

    }

    @Override
    public void internetOff() {

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
    public void movieOn() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }


}
