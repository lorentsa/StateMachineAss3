public class MovieDownloader {

    private IState off;
    private IState on;
    private IState currState;

    public MovieDownloader(){
        off = new Off(this);
        on = new On(this);
        currState = off;
        off.entry();
    }

    public void setCurrState(IState currState) {
        this.currState.exit();
        this.currState= currState;
        currState.entry();
    }

    public IState getCurrState() {
        return currState;
    }

    public IState getOff() {
        return off;
    }

    public void setOff(IState off) {
        this.off = off;
    }

    public IState getOn() {
        return on;
    }

    public void setOn(IState on) {
        this.on = on;
    }

    public void turnOff(){
        currState.turnOff();
    }

    public void turnOn(){
        currState.turnOn();
    }

    public void internetOff(){
        currState.internetOff();
    }

    public void internetOn(){
        currState.internetOn();
    }

    public void fileRequest(){
        currState.fileRequest();
    }

    public void downloadAborted(){
        currState.downloadAborted();
    }

    public void downloadError(){
        currState.downloadError();
    }

    public void errorFixed(){
        currState.errorFixed();
    }

    public void movieOn(){
        currState.movieOn();
    }

    public void restartMovie(){
        currState.restartMovie();
    }

    public void holdMovie(){
        currState.holdMovie();
    }

    public void movieOff(){
        currState.movieOff();
    }

    public void resume(){
        currState.resume();
    }

    public void setMovieLength(int movieLength) {
        ((On)(on)).setMovieLength(movieLength);
    }

    public void setFileSize(double fileSize) {
        ((On)(on)).setFileSize(fileSize);
    }

    public void setStorage(double storage) {
        ((On)(on)).setStorage(storage);
    }
}