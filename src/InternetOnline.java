public class InternetOnline implements IState{

    private On on;

    public InternetOnline(On on) {
        this.on = on;
    }

    @Override
    public void internetOff() {
        on.setCurrStateInternet(on.getOffline());
    }

    @Override
    public void entry() {
        System.out.println("enter internetOnline state");
    }

    @Override
    public void exit() {
        System.out.println("exit internetOnline state");
    }


    //region unused
    @Override
    public void internetOn() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

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
