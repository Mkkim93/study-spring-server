package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class AppInitV1Servlet implements AppInit{

    @Override
    public void onStartUp(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartUp");

        // 순수 서블릿 코드 등록
        // 서블릿을 등록(addServlet)하면 Dynamic 이라는 것으로 반환하고 addMapping 으로 url 과 매핑할 수 있게 된다.
        ServletRegistration.Dynamic helloServlet =
                servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello-servlet");

    }
}
