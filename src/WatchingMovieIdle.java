public class WatchingMovieIdle extends On implements IState {

    private MovieDownloader movieDownloader;

    public WatchingMovieIdle(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void entry() {
        System.out.println("enter watchingMovieIdle state");
        System.out.println("watch movie from " + movieDownloader.getTime() + "seconds");
        movieDownloader.setTime(0);
    }

    @Override
    public void exit() {
        System.out.println("exit watchingMovieIdle state");
    }

    @Override
    public void movieOn() {
        if(movieDownloader.getCurrStateDownload() instanceof DownloadFile && (movieDownloader.getDownload()/movieDownloader.getFileSize()) >= 0.2){
            movieDownloader.setCurrStateWatchingMovie(movieDownloader.getWatchMovie());
        }
    }









    @Override
    public void movieOff() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void internetOff() {

    }

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
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }



    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }


    @Override
    public void resume() {

    }
}
