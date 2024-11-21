package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(AppInit.class) // application 초기화 인터페이스를 AppInit 으로 지정한다
public class MyContainerInitV2 implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("set = " + set);
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("servletContext = " + servletContext);

        // class hello.container.AppInitV2Servlet
        for (Class<?> appInitClass : set) {
            try {
                AppInit appInit = (AppInit) appInitClass.getDeclaredConstructor().newInstance();
                appInit.onStartUp(servletContext);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}