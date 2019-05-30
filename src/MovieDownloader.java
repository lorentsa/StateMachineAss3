public class MovieDownloader {
   private IState downloadCheck;
   private IState downloadFile;
   private IState downloadIdle;
   private IState downloadRepair;
   private IState downloadWaiting;
   private IState enterQueue;
   private IState handleQueueIdle;
   private IState offline;
   private IState online;
   private IState pauseMovie;
   private IState watchingMovieIdle;
   private IState watchMovie;

   private IState currStateWatchingMovie;
   private IState currStateDownload;
   private IState currStateHandleQueue;

   private User currUser;

    public MovieDownloader(){
        downloadCheck = new DownloadCheck(this);
        downloadFile = new DownloadFile(this);
        downloadIdle = new DownloadIdle(this);
        downloadRepair = new DownloadRepair(this);
        downloadWaiting = new DownloadWaiting(this);
        enterQueue = new EnterQueue(this);
        handleQueueIdle = new HandleQueueIdle(this);
        offline = new Offline(this);
        online = new Online(this);
        pauseMovie = new PauseMovie(this);
        watchingMovieIdle = new WatchingMovieIdle(this);
        watchMovie = new WatchMovie(this);

        currUser=null;

        currStateDownload= downloadIdle;
        currStateHandleQueue=  handleQueueIdle;
        currStateWatchingMovie= watchingMovieIdle;
    }

    public void setCurrStateWatchingMovie(IState currStateWatchingMovie) {
        this.currStateWatchingMovie = currStateWatchingMovie;
    }

    public void setCurrStateDownload(IState currStateDownload) {
        this.currStateDownload = currStateDownload;
    }

    public void setCurrStateHandleQueue(IState currStateHandleQueue) {
        this.currStateHandleQueue = currStateHandleQueue;
    }

    public IState getDownloadCheck() {
        return downloadCheck;
    }

    public IState getDownloadFile() {
        return downloadFile;
    }

    public IState getDownloadIdle() {
        return downloadIdle;
    }

    public IState getDownloadRepair() {
        return downloadRepair;
    }

    public IState getDownloadWaiting() {
        return downloadWaiting;
    }

    public IState getEnterQueue() {
        return enterQueue;
    }

    public IState getHandleQueueIdle() {
        return handleQueueIdle;
    }

    public IState getOffline() {
        return offline;
    }

    public IState getOnline() {
        return online;
    }

    public IState getPauseMovie() {
        return pauseMovie;
    }

    public IState getWatchingMovieIdle() {
        return watchingMovieIdle;
    }

    public IState getWatchMovie() {
        return watchMovie;
    }


    public void turnOff(){
        currStateWatchingMovie.turnOff();
        currStateHandleQueue.turnOff();
        currStateDownload.turnOff();
    }

    public void turnOn(){
        currStateWatchingMovie.turnOn();
        currStateHandleQueue.turnOn();
        currStateDownload.turnOn();
    }

    public void internetOff(){
        currStateWatchingMovie.internetOff();
        currStateHandleQueue.internetOff();
        currStateDownload.internetOff();
    }

    public void internetOn(){
        currStateWatchingMovie.internetOn();
        currStateHandleQueue.internetOn();
        currStateDownload.internetOn();
    }

    public void fileRequest(){
        currStateWatchingMovie.fileRequest();
        currStateHandleQueue.fileRequest();
        currStateDownload.fileRequest();
    }

    public void downloadAborted(){
        currStateWatchingMovie.downloadAborted();
        currStateHandleQueue.downloadAborted();
        currStateDownload.downloadAborted();
    }

    public void downloadError(){
        currStateWatchingMovie.downloadError();
        currStateHandleQueue.downloadError();
        currStateDownload.downloadError();
    }

    public void errorFixed(){
        currStateWatchingMovie.errorFixed();
        currStateHandleQueue.errorFixed();
        currStateDownload.errorFixed();
    }

    public void movieOn(){
        currStateWatchingMovie.movieOn();
        currStateHandleQueue.movieOn();
        currStateDownload.movieOn();
    }

    public void restartMovie(){
        currStateWatchingMovie.restartMovie();
        currStateHandleQueue.restartMovie();
        currStateDownload.restartMovie();
    }

    public void holdMovie(){
        currStateWatchingMovie.holdMovie();
        currStateHandleQueue.holdMovie();
        currStateDownload.holdMovie();
    }

    public void movieOff(){
        currStateWatchingMovie.movieOff();
        currStateHandleQueue.movieOff();
        currStateDownload.movieOff();
    }

    public void resume(){
        currStateWatchingMovie.resume();
        currStateHandleQueue.resume();
        currStateDownload.resume();
    }
}
