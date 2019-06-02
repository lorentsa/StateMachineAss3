public class DownloadFile extends On implements IState,Runnable{

    private MovieDownloader movieDownloader;
    private Thread downloadFileThread;

    public DownloadFile(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void entry() {
        System.out.println("enter downloadFile state");
        movieDownloader.setStorage(movieDownloader.getStorage() - movieDownloader.getFileSize());
        downloadFileThread = new Thread(this);
        downloadFileThread.start();
    }

    @Override
    public void exit() {
        System.out.println("exit downloadFile state");
        downloadFileThread.interrupt();
    }

    @Override
    public void run() {
        while(!Thread.interrupted() && movieDownloader.getDownload() < movieDownloader.getFileSize()){
            movieDownloader.setDownload(movieDownloader.getDownload() + movieDownloader.getSpeed());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(movieDownloader.getDownload() == movieDownloader.getFileSize()){
            movieDownloader.setPoints(1);
            movieDownloader.setCurrStateDownload(movieDownloader.getDownloadIdle());
        }

    }

    @Override
    public void downloadAborted() {
        movieDownloader.setPoints(-1);
        movieDownloader.setStorage(movieDownloader.getStorage() + movieDownloader.getFileSize());
        movieDownloader.setCurrStateDownload(movieDownloader.getDownloadIdle());
    }

    @Override
    public void downloadError() {
        movieDownloader.setCurrStateDownload(movieDownloader.getDownloadRepair());
    }

    @Override
    public void internetOff() {
        movieDownloader.setCurrStateDownload(movieDownloader.getDownloadWaiting());
    }


    //region unused
    @Override
    public void errorFixed() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void turnOn() {

    }



    @Override
    public void internetOn() {

    }

    @Override
    public void fileRequest() {

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
    //endregion


}
