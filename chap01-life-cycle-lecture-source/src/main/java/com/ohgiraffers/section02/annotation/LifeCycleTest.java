package com.ohgiraffers.section02.annotation;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

/* loadOnStartup 속성으로 우선 순위를 지정할 수 있으며 (숫자가 낮을수록 우선순위가 높다)
* 서버가 start 될 때 인스턴스를 생성하고 init()을 호출하도록 한다. */
@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTest extends HttpServlet {

    /* 각 메소드의 호출 횟수를 카운트 할 목적의 필드 */
    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    /* 기본 생성자 */
    public LifeCycleTest(){}

    /* 최초 서블릿 요청 시에 동작하는 메소드 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 매핑 init() 메소드 호출 : " + initCount++);
    }

    /* 서블린 컨테이너에 의해 호출 되며 최초 요청시에는 init() 이후에 동작하고,
     * 두 번째 요청부터는 init() 호출 없이 바로 service()를 호출한다. */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);

    }

    /* 컨테이너가 종료 될 때 호출 되는 메소드이며 주로 자원을 반납하는 용도로 사용한다. */
    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destroy() 메소드 호출 : " + destroyCount++);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
