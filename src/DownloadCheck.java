import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadCheck implements IState,Runnable {

    private On on;
    private Thread downloadCheckThread;
    private AtomicBoolean running  = new AtomicBoolean(true);

    public DownloadCheck(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter downloadCheck state");
        doCheck();
    }

    private void doCheck() {
        if(on.getFileSize() < on.getStorage()){
            on.setAvailableSpace(true);
            on.setCurrStateDownload(on.getDownloadFile());
        }
        else{
            System.out.println("Storage not sufficient - first try");
            on.setChance(on.getChance() + 1);
            downloadCheckThread = new Thread(this);
            running.set(true);
            downloadCheckThread.start();
        }
    }

    @Override
    public void exit() {
        if(on.getChance()>=1)
            running.set(false);
        System.out.println("exit downloadCheck state");
    }

    @Override
    public void run() {
        if(!Thread.interrupted()){
            try{
                System.out.println("waiting 4 seconds");
                Thread.sleep(4000);
                if(on.getFileSize() < on.getStorage()){
                    on.setAvailableSpace(true);
                    on.setCurrStateDownload(on.getDownloadFile());
                }
                else{
                    System.out.println("Storage not sufficient - second try");
                    on.setChance(on.getChance() + 1);
                    on.setPoints(-1);
                    on.setCurrStateDownload(on.getDownloadIdle());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    //region unused
    @Override
    public void internetOff() {

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
