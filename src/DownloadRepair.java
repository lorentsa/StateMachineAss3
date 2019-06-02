public class DownloadRepair extends On implements IState,Runnable{

    private MovieDownloader movieDownloader;
    private Thread downloadRepairThread;

    public DownloadRepair(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void entry() {
        super.entry();
        System.out.println("enter downloadRepair state");
        downloadRepairThread = new Thread(this);
        downloadRepairThread.start();
    }

    @Override
    public void exit() {
        downloadRepairThread.interrupt();
        System.out.println("exit downloadRepair state");
    }

    @Override
    public void run() {
        try{
            Thread.sleep(3000);
            if(!Thread.interrupted()){
                movieDownloader.setPoints(-1);
                movieDownloader.setCurrStateDownload(movieDownloader.getDownloadIdle());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadAborted() {
        movieDownloader.setPoints(-1);
        movieDownloader.setStorage(movieDownloader.getStorage() + movieDownloader.getFileSize());
        movieDownloader.setCurrStateDownload(movieDownloader.getDownloadIdle());
    }




    //region unused
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
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

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
