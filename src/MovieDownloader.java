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
}
