package com.frandom;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: amrit
 * Date: 5/3/14
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
@ApplicationPath("/resources")
public class ApplicationTestRest extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(MyResource.class);
        return s;
    }
}
