public class InternetOffline implements IState {

    private On on;

    public InternetOffline(On on) {
        this.on = on;
    }

    @Override
    public void internetOn() {
        on.setCurrStateInternet(on.getOnline());
    }

    @Override
    public void entry() {
        System.out.println("enter internetOffline state");
    }

    @Override
    public void exit() {
        System.out.println("exit internetOffline state");
    }


    //region unused
    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
    @Override
    public void internetOff() {

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
