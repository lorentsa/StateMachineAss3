public interface IState {
    void turnOff();
    void turnOn();
    void internetOff();
    void internetOn();
    void fileRequest();
    void downloadAborted();
    void downloadError();
    void errorFixed();
    void movieOn();
    void restartMovie();
    void holdMovie();
    void movieOff();
    void resume();
}
