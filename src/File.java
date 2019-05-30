public class File {

    private int status;
    private double size;
    private String fileName;


    public File(double size, String fileName) {
        status = 0;
        this.size = size;
        this.fileName = fileName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
