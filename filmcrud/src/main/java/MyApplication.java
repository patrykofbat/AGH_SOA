import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public MyApplication()
    {
        singletons.add(new Films());
        singletons.add(new Users());
        singletons.add(new Osoby());
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return empty;
    }

    @Override
    public Set<Object> getSingletons()
    {
        return singletons;
    }

    private void init() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[] {"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/jee-swagger/api");
    }


}
