public class DownloadIdle extends On implements IState{

    private MovieDownloader movieDownloader;

    public DownloadIdle(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }

    @Override
    public void entry() {
        movieDownloader.setChance(0);
        movieDownloader.setAvailableSpace(false);
        movieDownloader.resetDownload();
        System.out.println("enter downloadIdle state");
    }

    @Override
    public void exit() {
        System.out.println("exit downloadIdle state");
    }

    @Override
    public void fileRequest() {
        if(movieDownloader.getCurrStateInternet() instanceof InternetOnline){
            movieDownloader.setCurrStateDownload(movieDownloader.getDownloadCheck());
            setSpeed(movieDownloader.getPoints());
        }
    }

    private void setSpeed(int points){
        if(points > 0 && points < 4){
            movieDownloader.setSpeed(1);
        }
        else if(points >=4 && points < 7){
            movieDownloader.setSpeed(1.2);
        }
        else{
            movieDownloader.setSpeed(1.5);
        }
    }

    @Override
    public void turnOff() {
        super.exit();
    }

    @Override
    public void turnOn() {
        super.entry();
    }

    @Override
    public void internetOff() {

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
}
