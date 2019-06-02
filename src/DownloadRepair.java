import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadRepair implements IState,Runnable{

    private On on;
    private Thread downloadRepairThread;
    private AtomicBoolean running  = new AtomicBoolean(true);

    public DownloadRepair(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter downloadRepair state");
        downloadRepairThread = new Thread(this);
        running.set(true);
        downloadRepairThread.start();
    }

    @Override
    public void exit() {
        running.set(false);
        System.out.println("exit downloadRepair state");
    }

    @Override
    public void run() {
        try{
            System.out.println("Waiting 3 seconds");
            Thread.sleep(3000);
            if(running.get()){
                on.setPoints(-1);
                on.setCurrStateDownload(on.getDownloadIdle());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadAborted() {
        on.setPoints(-1);
        on.setStorage(on.getStorage() + on.getFileSize());
        on.setCurrStateDownload(on.getDownloadIdle());
    }


    @Override
    public void errorFixed() {
        running.set(false);
        on.setCurrStateDownload(on.getDownloadFile());
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
