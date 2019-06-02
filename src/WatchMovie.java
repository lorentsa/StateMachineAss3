public class WatchMovie implements IState,Runnable {

    private MovieDownloader movieDownloader;
    private Thread watchMovieThread;

    public WatchMovie(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void entry() {
        System.out.println("enter watchingMovieIdle state");
        watchMovieThread = new Thread();
        watchMovieThread.start();
    }

    @Override
    public void exit() {
        System.out.println("exit watchingMovieIdle state");
    }

    @Override
    public void restartMovie() {
        movieDownloader.setCurrStateWatchingMovie(this);
        movieDownloader.setTime(0);
    }

    @Override
    public void run() {
        while(!Thread.interrupted() && movieDownloader.getTime() < movieDownloader.getMovieLength()){
            movieDownloader.setTime(movieDownloader.getTime()+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void holdMovie() {
        movieDownloader.setCurrStateWatchingMovie(movieDownloader.getPauseMovie());
    }

    @Override
    public void downloadError() {
        movieDownloader.setCurrStateWatchingMovie(movieDownloader.getPauseMovie());
    }

    @Override
    public void internetOff() {
        movieDownloader.setCurrStateWatchingMovie(movieDownloader.getPauseMovie());
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void turnOn() {

    }

    //region unused
    @Override
    public void internetOn() {

    }

    @Override
    public void fileRequest() {

    }

    @Override
    public void downloadAborted() {

    }



    @Override
    public void errorFixed() {

    }

    @Override
    public void movieOn() {

    }



    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {

    }
    //endregion
}
