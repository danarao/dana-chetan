package com.sample.login;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		String csvFile = "/C:/users/test.csv";
		FileWriter fileWriter = new FileWriter(csvFile);
		fileWriter.write("username: ");
		fileWriter.append(name);
		fileWriter.append("\n");
		fileWriter.append("password:");
		fileWriter.append(pwd);
		fileWriter.flush();
		fileWriter.close();
		if (!name.equals("chetan") && !pwd.equals("ram")) {
			HttpSession session = request.getSession();
			session.setAttribute("userName", name);
			response.sendRedirect("hello.jsp");
		}

		else {
			response.sendRedirect("bus.html");
		}

	

	}

}
