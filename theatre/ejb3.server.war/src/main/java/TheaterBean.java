import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "theaterBean")
@SessionScoped
public class TheaterBean {

    @EJB
    private ITestBeanCounter testBeanCounter;

    public long getCounter() {
        return testBeanCounter.getNumber();
    }

    public void incrementCounter() {
        testBeanCounter.increment();
    }
}
