public class DownloadIdle implements IState{

    private On on;

    public DownloadIdle(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        on.setChance(0);
        on.setAvailableSpace(false);
        on.resetDownload();
        System.out.println("enter downloadIdle state");
    }

    @Override
    public void exit() {
        System.out.println("exit downloadIdle state");
    }

    @Override
    public void fileRequest() {
        if(on.getCurrStateInternet() instanceof InternetOnline){
            on.setCurrStateDownload(on.getDownloadCheck());
            setSpeed(on.getPoints());
        }
        else
            System.out.println("Download not available - internet is offline");
    }

    private void setSpeed(int points){
        if(points >= 0 && points < 4){
            on.setSpeed(1);
        }
        else if(points >=4 && points < 7){
            on.setSpeed(1.2);
        }
        else{
            on.setSpeed(1.5);
        }
        System.out.println("Downloading in x"+on.getSpeed()+ " speed");
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
