import java.io.Serializable;

public class Counter implements Serializable {
    private static final long serialVersionUID = 1L;
    private long currentCounter;
    public Counter(){
        this.currentCounter = 0L;
    }

    public long getCurrentCounter() {
        return currentCounter;
    }
    public void setCurrentCounter(long currentCounter){
        this.currentCounter = currentCounter;
    }

    @Override
    public String toString(){
        return "Счетчик";
    }
}
