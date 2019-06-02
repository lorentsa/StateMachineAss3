public class DownloadWaiting extends On implements IState{

    private MovieDownloader movieDownloader;

    public DownloadWaiting(MovieDownloader movieDownloader) {
        this.movieDownloader = movieDownloader;
    }


    @Override
    public void internetOn() {
        movieDownloader.setCurrStateDownload(movieDownloader.getDownloadFile());
    }

    @Override
    public void entry() {
        super.entry();
        System.out.println("enter downloadWaiting state");
    }

    @Override
    public void exit() {
        System.out.println("exit downloadWaiting state");
    }

    @Override
    public void downloadAborted() {
        movieDownloader.setPoints(-1);
        movieDownloader.setStorage(movieDownloader.getStorage() + movieDownloader.getFileSize());
        movieDownloader.setCurrStateDownload(movieDownloader.getDownloadIdle());
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void turnOn() {

    }


    //region unused
    @Override
    public void internetOff() {

    }



    @Override
    public void fileRequest() {

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
