package hello.container;

import jakarta.servlet.ServletContext;

public interface AppInit {

    /**
     * @param servletContext : 어플리케이션에서 실행 환경에 대한 정보 제공 (어플리케이션이 시작될 때 초기화를 수행하거나, 설정을 구성)
     *  -> ServletContext 애플리케이션의 전역 컨텍스트를 나타내며, 모든 서블릿과 필터에서 공유됨
     */
    void onStartUp(ServletContext servletContext);
}
