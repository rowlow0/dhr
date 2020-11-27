package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String custno=req.getParameter("custno")==null?"":req.getParameter("custno");
		String custname=req.getParameter("custname")==null?"":req.getParameter("custname");
		String phone=req.getParameter("phone")==null?"":req.getParameter("phone");
		String address=req.getParameter("address")==null?"":req.getParameter("address");
		String joindate=req.getParameter("joindate")==null?"":req.getParameter("joindate");
		String city=req.getParameter("city")==null?"":req.getParameter("city");
		String grade=req.getParameter("grade")==null?"":req.getParameter("grade");
		if(custno.equals("")||custname.equals("")||phone.equals("")||address.equals("")||joindate.equals("")||city.equals("")||grade.equals("")) {
			int check=1;req.setAttribute("check", check);req.setAttribute("custno", custno);
			RequestDispatcher dis=req.getRequestDispatcher("insert.jsp");
			dis.forward(req, res);
		}
		else {
		Dao dao=new Dao();
			dao.update(Integer.parseInt(custno), custname, phone, address, joindate, grade, city);
		RequestDispatcher dis=req.getRequestDispatcher("Select");
		dis.forward(req, res);}

}
}
