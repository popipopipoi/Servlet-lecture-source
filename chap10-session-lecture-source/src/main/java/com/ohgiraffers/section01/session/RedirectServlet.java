package com.ohgiraffers.section01.session;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 세션 객체를 꺼내온다. */
        HttpSession session = request.getSession();
        System.out.println("redirect session id : " + session.getId());

        /* 세션에 담긴 모든 Attribure 키 목록을 반환 받을 수 있다. */
        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }
/*메롱메롱메롱롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메메롱메메롱메롱메롱메롱메롱메롱메롱메롱메메롱메롱메롱메롱
* 메롱메로엠롱메롱메롱메로에몰에모레오메롱메로에모렝모렝메로에모레옴메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱
* 메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메롱메올에모레모도라에몽몽로멩모메오메오메오메오메옴에몽
* 메롱메롱메롱메로메모렘로메롬레*/
        /* setAttribute한 값을 getAttribute로 꺼낼 수 있다. */
        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        /* 꺼내온 값을 이용해 페이지에 응답용 html을 내보낸다. */
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>your first name is")
                .append(firstName)
                .append(" and last name is ")
                .append(lastName)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print(responseBuilder.toString());
        out.close();
    }

}
