package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
/* Service 로 deleteEmp 메소드 호출하여 결과 반환 받고
 * 삭제 완료 시 Employee 목록을 조회하는 화면으로 처리*/

@WebServlet("/employee/delete")
public class DeleteEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String empId = request.getParameter("empId");

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);

        System.out.println("delete request emp : " + emp);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.deleteEmp(emp);

        if(result > 0) {
            response.sendRedirect(request.getContextPath() + "/employee/list");
        } else {
            request.setAttribute("message", "삭제에 실패했습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }


    }
}
