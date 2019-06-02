public class DownloadWaiting implements IState{

    private On on;

    public DownloadWaiting(On on) {
        this.on = on;
    }


    @Override
    public void internetOn() {
        on.setCurrStateDownload(on.getDownloadFile());
    }

    @Override
    public void entry() {
        System.out.println("enter downloadWaiting state");
    }

    @Override
    public void exit() {
        System.out.println("exit downloadWaiting state");
    }

    @Override
    public void downloadAborted() {
        on.setPoints(-1);
        on.setStorage(on.getStorage() + on.getFileSize());
        on.setCurrStateDownload(on.getDownloadIdle());
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
