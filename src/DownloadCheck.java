public class DownloadCheck implements IState,Runnable {

    private MovieDownloader movieDownloader;
    private Thread downloadCheckThread;

    public DownloadCheck(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void entry() {
        System.out.println("enter downloadCheck state");
        doCheck();
    }

    private void doCheck() {
        if(movieDownloader.getFileSize() < movieDownloader.getStorage()){
            movieDownloader.setAvailableSpace(true);
            movieDownloader.setCurrStateDownload(movieDownloader.getDownloadFile());
        }
        else{
            movieDownloader.setChance(movieDownloader.getChance() + 1);
            downloadCheckThread = new Thread(this);
            downloadCheckThread.start();
        }
    }

    @Override
    public void exit() {
        if(movieDownloader.getChance()>=1)
            downloadCheckThread.interrupt();
        System.out.println("exit downloadCheck state");
    }

    @Override
    public void run() {
        if(!Thread.interrupted()){
            try{
                System.out.println("waiting 4 seconds");
                Thread.sleep(4000);
                if(movieDownloader.getFileSize() < movieDownloader.getStorage()){
                    movieDownloader.setAvailableSpace(true);
                    movieDownloader.setCurrStateDownload(movieDownloader.getDownloadFile());
                }
                else{
                    movieDownloader.setChance(movieDownloader.getChance() + 1);
                    movieDownloader.setPoints(-1);
                    movieDownloader.setCurrStateDownload(movieDownloader.getDownloadIdle());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void turnOn() {
    }



    //region unused
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
