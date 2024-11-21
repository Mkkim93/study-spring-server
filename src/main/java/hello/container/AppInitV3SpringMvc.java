package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV3SpringMvc implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("AppInitV3SpringMvc.onStartup");

        // 스프링 컨테이너 생성
        // AnnotationConfigWebApplicationContext(애노테이션 config 설정 기반 객체)
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(HelloConfig.class); // HelloConfig.class 라는 객체를 컨테이너에 스프링 설정을 추가한다

        // 스프링 MVC 디스페처 서블릿 생성, 스프링 컨테이너 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // 모든 요청이 디스패처 서블릿을 통하도록 설정
        servletContext
                .addServlet("dispatcherV3", dispatcherServlet)
                .addMapping("/");

    }
}
