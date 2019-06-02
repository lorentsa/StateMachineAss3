public class WatchingMovieIdle implements IState {

    private On on;

    public WatchingMovieIdle(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter watchingMovieIdle state");
        System.out.println("watch movie from " + on.getTime() + "seconds");
        on.setTime(0);
    }

    @Override
    public void exit() {
        System.out.println("exit watchingMovieIdle state");
    }

    @Override
    public void movieOn() {
        if(on.getCurrStateDownload() instanceof DownloadFile && (on.getDownload()/on.getFileSize()) >= 0.2){
            on.setCurrStateWatchingMovie(on.getWatchMovie());
        }
    }

    //region unused
    @Override
    public void turnOff() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void movieOff() {

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
    public void downloadAborted() {

    }

    @Override
    public void downloadError() {

    }

    @Override
    public void errorFixed() {

    }



    @Override
    public void restartMovie() {

    }

    @Override
    public void holdMovie() {

    }


    @Override
    public void resume() {

    }
    //endregion
}
