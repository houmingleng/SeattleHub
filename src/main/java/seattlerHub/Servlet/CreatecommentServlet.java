package seattlerHub.Servlet;


import seattlerHub.dal.HousingDao;
import seattlerHub.dal.ReviewsDao;
import seattlerHub.dal.UsersDao;
import seattlerHub.model.Housing;
import seattlerHub.model.Reviews;
import seattlerHub.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/createcomment")
public class CreatecommentServlet extends HttpServlet {
    protected HousingDao housingDao;
    protected ReviewsDao reviewsDao;
    protected UsersDao usersDao;
    @Override
    public void init() throws ServletException {
        housingDao = HousingDao.getInstance();
        reviewsDao = ReviewsDao.getInstance();
        usersDao = UsersDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 Map<String,String> messages = new HashMap<>();
         String Rating = req.getParameter("ratinghouse");
         double rating = Double.parseDouble(Rating);
         String userName = req.getParameter("username");
         String comments = req.getParameter("comment");
         String housingid = req.getParameter("housingId");
         int housingId =Integer.parseInt(housingid);
         try {
             Housing house = housingDao.getHousingByHousingId(housingId);
             Timestamp timestamp=new Timestamp(System.currentTimeMillis());
             Users user= usersDao.getUserByUserName(userName);
             Reviews reviews = new Reviews(timestamp,comments, rating,user,house);
             reviewsDao.create(reviews);
             messages.put("title","works!");
         } catch (SQLException e) {
             e.printStackTrace();
         }
         req.getRequestDispatcher("Home.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> messages = new HashMap<>();
        String Rating = req.getParameter("ratinghouse");
        double rating = Double.parseDouble(Rating);
        String userName = req.getParameter("username");
        String comments = req.getParameter("comment");
        String housingid = req.getParameter("housingId");
        int housingId =Integer.parseInt(housingid);
        try {
            Housing house = housingDao.getHousingByHousingId(housingId);
            Timestamp timestamp=new Timestamp(System.currentTimeMillis());
            Users user= usersDao.getUserByUserName(userName);
            Reviews reviews = new Reviews(timestamp,comments, rating,user,house);
            reviewsDao.create(reviews);
            messages.put("title","works!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("Home.jsp").forward(req,resp);


    }
}
