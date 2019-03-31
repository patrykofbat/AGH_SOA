import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton
@Remote(IRemoteTestBeanCounter.class)
@Local(ILocalTestBeanCounter.class)
public class TestBeanCounter implements ITestBeanCounter{
    private long number = 0;

    @Override
    public void increment() {
        this.number++;
    }

    @Override
    public long getNumber() {
        return this.number;
    }
}
