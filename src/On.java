public abstract class On implements IState{

    @Override
    public void entry() {
        System.out.println("enter on state");
    }

    @Override
    public void exit() {
        System.out.println("exit on state");
    }
}
