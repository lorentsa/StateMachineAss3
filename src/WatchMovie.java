public class WatchMovie implements IState,Runnable {

    private On on;
    private Thread watchMovieThread;

    public WatchMovie(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter watchingMovieIdle state");
        System.out.println("watch movie from " + on.getTime() + " seconds");
        watchMovieThread = new Thread();
        watchMovieThread.start();
    }

    @Override
    public void exit() {
        System.out.println("exit watchingMovieIdle state");
    }

    @Override
    public void restartMovie() {
        on.setCurrStateWatchingMovie(this);
        on.setTime(0);
    }

    @Override
    public void run() {
        while(!Thread.interrupted() && on.getTime() < on.getMovieLength()){
            on.setTime(on.getTime()+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void holdMovie() {
        on.setCurrStateWatchingMovie(on.getPauseMovie());
    }

    @Override
    public void downloadError() {
        on.setCurrStateWatchingMovie(on.getPauseMovie());
    }

    @Override
    public void internetOff() {
        on.setCurrStateWatchingMovie(on.getPauseMovie());
    }

    //region unused
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
    public void errorFixed() {

    }

    @Override
    public void movieOn() {

    }



    @Override
    public void movieOff() {

    }

    @Override
    public void resume() {

    }
    //endregion
}
