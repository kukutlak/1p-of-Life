package oneper.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import oneper.req.Sponser;
import oneper.req.Problems;

@ApplicationPath("/rest")
public class OnePApp extends Application {
    public OnePApp() {}
    public Set<Class<?>> getClasses(){
      Set<Class<?>> classes = new HashSet();
      classes.add(Sponser.class);
      classes.add(Problems.class);
      

      return classes;
   }
}