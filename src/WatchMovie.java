import java.util.concurrent.atomic.AtomicBoolean;

public class WatchMovie implements IState,Runnable {

    private On on;
    private Thread watchMovieThread;
    private AtomicBoolean running  = new AtomicBoolean(true);

    public WatchMovie(On on) {
        this.on = on;
    }

    @Override
    public void entry() {
        System.out.println("enter watchMovie state");
        System.out.println("watch movie from " + on.getTime() + " seconds");
        watchMovieThread = new Thread(this);
        running.set(true);
        watchMovieThread.start();
    }

    @Override
    public void exit() {
        System.out.println("exit watchMovie state");
        running.set(false);
    }

    @Override
    public void restartMovie() {
        on.setTime(0);
        on.setCurrStateWatchingMovie(this);
    }

    @Override
    public void run(){
        System.out.println("Watching from " + on.getTime() + " to " + on.getMovieLength() + " seconds");
        while(running.get() && on.getTime() < on.getMovieLength()){
            on.setTime(on.getTime()+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("Watching " + on.getTime() + "/" + on.getMovieLength() + " seconds");
        }
        if(on.getTime() >= on.getMovieLength())
            System.out.println("Watching done.");

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
