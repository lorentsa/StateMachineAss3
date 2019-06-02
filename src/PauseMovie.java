public class PauseMovie implements IState {

    private On on;

    public PauseMovie(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter pauseMovie state");
    }

    @Override
    public void exit() {
        System.out.println("exit pauseMovie state");
    }

    @Override
    public void internetOn() {
        on.setCurrStateWatchingMovie(on.getWatchMovie());
    }

    @Override
    public void turnOff() {

    }
    @Override
    public void turnOn() {

    }

    @Override
    public void errorFixed() {
        on.setCurrStateWatchingMovie(on.getWatchMovie());
    }

    @Override
    public void resume() {
        on.setCurrStateWatchingMovie(on.getWatchMovie());
    }

    @Override
    public void movieOff() {
        on.setCurrStateWatchingMovie(on.getWatchingMovieIdle());
    }


    //region unused
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
    public void movieOn() {

    }

    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }//endregion
}