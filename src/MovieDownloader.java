public class MovieDownloader {
    IState downloadCheck;
    IState downloadFile;
    IState downloadIdle;
    IState downloadRepair;
    IState downloadWaiting;

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

        currUser=null;

        currStateDownload= ;
        currStateHandleQueue=  ;
        currStateWatchingMovie= ;
    }
}
