import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton
@Remote(IRemoteTestBeanCounter.class)
public class TestBeanCounter implements ITestBeanCounter {
    private long number = 0;

    public long getNumber() {
        return number;
    }

    public void increment() {
        this.number++;
    }
}
