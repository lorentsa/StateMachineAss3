public class DownloadIdle implements IState{

    private int chance;
    private boolean freeStorage;

    public DownloadIdle() {
        chance = 0;
        freeStorage = false;
    }
}
