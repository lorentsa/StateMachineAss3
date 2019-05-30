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
        downloadCheck = new DownloadCheck();
        downloadFile = new DownloadFile();
        downloadIdle = new DownloadIdle();
        downloadRepair = new DownloadRepair();
        downloadWaiting = new DownloadWaiting();
        enterQueue = new EnterQueue();
        handleQueueIdle = new HandleQueueIdle();
        offline = new Offline();
        online = new Online();
        pauseMovie = new PauseMovie();
        watchingMovieIdle = new WatchingMovieIdle();
        watchMovie = new WatchMovie();

        currUser=null;

        currStateDownload= downloadIdle;
        currStateHandleQueue=  handleQueueIdle;
        currStateWatchingMovie= watchingMovieIdle;
    }
}
