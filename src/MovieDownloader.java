public class MovieDownloader {
    IState downloadCheck;
    IState downloadFile;
    IState downloadIdle;
    IState downloadRepair;
    IState downloadWaiting;
    IState enterQueue;
    IState handleQueueIdle;
    IState offline;
    IState online;
    IState pauseMovie;
    IState watchingMovieIdle;
    IState watchMovie;

    IState currStateWatchingMovie;
    IState currStateDownload;
    IState currStateHandleQueue;

    User currUser;

    public MovieDownloader(){
        downloadCheck = new DownloadCheck(this);
        downloadFile = new DownloadFile(this);
        downloadIdle = new DownloadIdle(this);
        downloadRepair = new DownloadRepair(this);
        downloadWaiting = new DownloadWaiting(this);
        enterQueue = new EnterQueue(this);
        handleQueueIdle = new HandleQueueIdle(this);
        offline = new InternetOffline(this);
        online = new InternetOnline(this);
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
}
