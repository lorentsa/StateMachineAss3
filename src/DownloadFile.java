import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadFile implements IState,Runnable{

    private On on;
    private Thread downloadFileThread;
    private AtomicBoolean running  = new AtomicBoolean(true);

    public DownloadFile(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter downloadFile state");
        on.setStorage(on.getStorage() - on.getFileSize());
        downloadFileThread = new Thread(this);
        running.set(true);
        downloadFileThread.start();
    }

    @Override
    public void exit() {
        System.out.println("exit downloadFile state");
        running.set(false);
    }

    @Override
    public void run() {
        System.out.println("Downloading from " + on.getDownload() + " to " + on.getFileSize() + " units");
        while(running.get() && on.getDownload() < on.getFileSize()){
            on.setDownload(on.getDownload() + on.getSpeed());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("Download progress: " + on.getDownload()+"/"+on.getFileSize() + " units");
        }
        if(on.getDownload() >= on.getFileSize()){
            System.out.println("Download done - " + on.getFileSize() + " units downloaded");
            on.setPoints(1);
            on.setCurrStateDownload(on.getDownloadIdle());
        }
    }

    @Override
    public void downloadAborted() {
        on.setPoints(-1);
        on.setStorage(on.getStorage() + on.getFileSize());
        on.setCurrStateDownload(on.getDownloadIdle());
    }

    @Override
    public void downloadError() {
        on.setCurrStateDownload(on.getDownloadRepair());
    }

    @Override
    public void internetOff() {
        on.setCurrStateDownload(on.getDownloadWaiting());
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
