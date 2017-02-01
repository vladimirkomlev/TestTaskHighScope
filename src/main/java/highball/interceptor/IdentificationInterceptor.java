package highball.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import highball.domain.Employee;

import java.util.Map;

public class IdentificationInterceptor implements  Interceptor{

    @Override
    public void destroy() {
        System.out.println("CustomInterceptor destroy() is called.");
    }

    @Override
    public void init() {
        System.out.println("CustomInterceptor init() is called.");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("CustomInterceptor, before invocation.invoke().");

        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        String employeeKey="employee";
        Employee employee = (Employee) session.get(employeeKey);
        if(employee==null){
            System.out.println("IdentificationInterceptor login");
            return "login";
        }

        return actionInvocation.invoke();
    }
}
