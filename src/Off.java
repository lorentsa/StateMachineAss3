public abstract class Off implements IState {

    @Override
    public void entry() {
        System.out.println("enter off state");
    }

    @Override
    public void exit() {
        System.out.println("exit off state");
    }
}
