package seattlerHub.Servlet;

import seattlerHub.dal.UsersDao;
import seattlerHub.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    protected UsersDao usersDao;
    protected Users user;

    @Override
    public void init() throws ServletException {
        usersDao = UsersDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> messages =  new HashMap<>();
        req.setAttribute("messages",messages);
        req.getRequestDispatcher("/Login.jsp").forward(req,resp);
//    	doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> messages = new HashMap<>();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            user = usersDao.getUserByEmail(email);
            System.out.println(user.toString());
            //here may need change later. if email fo not exit in the database
            //just concern if it is there
            if(user!=null&&user.getPassword().equals(password)){
                req.setAttribute("username",user.getUserName());
                req.getRequestDispatcher("Home.jsp").forward(req, resp);
                resp.sendRedirect("Home.jsp");
                
            }else{
                throw new Exception("wrong user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        req.getSession().setAttribute("username",user.getUserName());
       
//        resp.sendRedirect("Home.jsp");
//    	String name = "alan1";
//        req.setAttribute("username",name);
//        req.getRequestDispatcher("Home.jsp").forward(req, resp);
//        resp.sendRedirect("Home.jsp");
    }
}
