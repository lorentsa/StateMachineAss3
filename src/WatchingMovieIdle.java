public class WatchingMovieIdle implements IState {

    private On on;

    public WatchingMovieIdle(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter watchingMovieIdle state");

        on.setTime(0);
    }

    @Override
    public void exit() {
        System.out.println("exit watchingMovieIdle state");
    }

    @Override
    public void movieOn() {
        if(on.getCurrStateDownload() instanceof DownloadFile){
            if((on.getDownload()/on.getFileSize()) >= 0.2)
                on.setCurrStateWatchingMovie(on.getWatchMovie());
            else
                System.out.println("Please wait until at least 20% is downloaded");
        }
        else
            System.out.println("You can't watch a movie if you are not downloading it");
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
