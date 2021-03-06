public class On implements IState{
    private double storage = 100;
    private int chance = 0;
    private boolean availableSpace = false;
    private int points = 0;
    private double speed = 1;
    private int time = 0;
    private double download = 0;
    private double fileSize = 30;
    private int movieLength = 30;

    private IState downloadCheck;
    private IState downloadFile;
    private IState downloadIdle;
    private IState downloadRepair;
    private IState downloadWaiting;
    private IState offline;
    private IState online;
    private IState pauseMovie;
    private IState watchingMovieIdle;
    private IState watchMovie;

    private IState currStateWatchingMovie;
    private IState currStateDownload;
    private IState currStateInternet;

    private MovieDownloader movieDownloader;

    public On(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
        downloadCheck = new DownloadCheck(this);
        downloadFile = new DownloadFile(this);
        downloadIdle = new DownloadIdle(this);
        downloadRepair = new DownloadRepair(this);
        downloadWaiting = new DownloadWaiting(this);
        offline = new InternetOffline(this);
        online = new InternetOnline(this);
        pauseMovie = new PauseMovie(this);
        watchingMovieIdle = new WatchingMovieIdle(this);
        watchMovie = new WatchMovie(this);

        currStateDownload=downloadIdle;
        currStateInternet=offline;
        currStateWatchingMovie=watchingMovieIdle;
    }

    @Override
    public void entry() {
        System.out.println("enter on state");
        currStateDownload.entry();
        currStateInternet.entry();
        currStateWatchingMovie.entry();
    }

    @Override
    public void exit() {
        System.out.println("exit on state");
    }


    public void setCurrStateWatchingMovie(IState currStateWatchingMovie) {
        this.currStateWatchingMovie.exit();
        this.currStateWatchingMovie = currStateWatchingMovie;
        this.currStateWatchingMovie.entry();
    }

    public void setCurrStateDownload(IState currStateDownload) {
        this.currStateDownload.exit();
        this.currStateDownload = currStateDownload;
        this.currStateDownload.entry();
        if(currStateDownload instanceof DownloadIdle)
            setCurrStateWatchingMovie(getWatchingMovieIdle());

    }

    public void setCurrStateInternet(IState currStateInternet) {
        this.currStateInternet.exit();
        this.currStateInternet = currStateInternet;
        this.currStateInternet.entry();
    }

    public IState getCurrStateWatchingMovie() {
        return currStateWatchingMovie;
    }

    public IState getCurrStateDownload() {
        return currStateDownload;
    }

    public IState getCurrStateInternet() {
        return currStateInternet;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public double getStorage() {
        return storage;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public boolean isAvailableSpace() {
        return availableSpace;
    }

    public void setAvailableSpace(boolean availableSpace) {
        this.availableSpace = availableSpace;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
        if(this.points < 0)
            this.points = 0;
        System.out.println("You have " + this.points + " points");
    }

    public void resetDownload(){
        this.download = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public double getDownload() {
        return download;
    }

    public void setDownload(double download) {
        this.download = download;
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
        currStateWatchingMovie.exit();
        currStateInternet.exit();
        currStateDownload.exit();
        movieDownloader.setCurrState(movieDownloader.getOff());
    }

    public void turnOn(){
        currStateWatchingMovie.turnOn();
        currStateInternet.turnOn();
        currStateDownload.turnOn();
    }

    public void internetOff(){
        currStateInternet.internetOff();
        currStateWatchingMovie.internetOff();
        currStateDownload.internetOff();
    }

    public void internetOn(){
        currStateInternet.internetOn();
        currStateWatchingMovie.internetOn();
        currStateDownload.internetOn();
    }

    public void fileRequest(){
        currStateDownload.fileRequest();
        currStateWatchingMovie.fileRequest();
        currStateInternet.fileRequest();
    }

    public void downloadAborted(){
        currStateDownload.downloadAborted();
        currStateWatchingMovie.downloadAborted();
        currStateInternet.downloadAborted();
    }

    public void downloadError(){
        currStateDownload.downloadError();
        currStateWatchingMovie.downloadError();
        currStateInternet.downloadError();
    }

    public void errorFixed(){
        currStateDownload.errorFixed();
        currStateWatchingMovie.errorFixed();
        currStateInternet.errorFixed();
    }

    public void movieOn(){
        currStateWatchingMovie.movieOn();
        currStateInternet.movieOn();
        currStateDownload.movieOn();
    }

    public void restartMovie(){
        currStateWatchingMovie.restartMovie();
        currStateInternet.restartMovie();
        currStateDownload.restartMovie();
    }

    public void holdMovie(){
        currStateWatchingMovie.holdMovie();
        currStateInternet.holdMovie();
        currStateDownload.holdMovie();
    }

    public void movieOff(){
        currStateWatchingMovie.movieOff();
        currStateInternet.movieOff();
        currStateDownload.movieOff();
    }

    public void resume(){
        currStateWatchingMovie.resume();
        currStateInternet.resume();
        currStateDownload.resume();
    }
}
