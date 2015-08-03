import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionAttributeListener;

/**
 *
 */
public class SessionListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("add " + httpSessionBindingEvent.getName() + " = " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("remove " + httpSessionBindingEvent.getName() + " = " + httpSessionBindingEvent.getValue());
        System.out.println("remove " + httpSessionBindingEvent.getName() + " = " +httpSessionBindingEvent.getSession().getAttribute(httpSessionBindingEvent.getName()));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("replace " + httpSessionBindingEvent.getName() + " = " + httpSessionBindingEvent.getValue());
        System.out.println("replace " + httpSessionBindingEvent.getName() + " = " +httpSessionBindingEvent.getSession().getAttribute(httpSessionBindingEvent.getName()));
    }
}
