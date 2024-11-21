package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit{

    @Override
    public void onStartUp(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartUp");

        // 스프링 컨테이너 생성
        // AnnotationConfigWebApplicationContext(애노테이션 config 설정 기반 객체)
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(HelloConfig.class); // HelloConfig.class 라는 객체를 컨테이너에 스프링 설정을 추가한다

        // 스프링 MVC 디스페처 서블릿 생성, 스프링 컨테이너 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // 디스패처 서블릿을 서블릿 컨테이너에 등록
        servletContext
                .addServlet("dispatcherV2", dispatcherServlet)
                .addMapping("/spring/*");
    }
}
