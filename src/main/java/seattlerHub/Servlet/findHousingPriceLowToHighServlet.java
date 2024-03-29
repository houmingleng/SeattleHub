package seattlerHub.Servlet;

import seattlerHub.dal.HousingDao;
import seattlerHub.model.Housing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/findHousingPriceLowToHigh")
public class findHousingPriceLowToHighServlet extends HttpServlet {

    HousingDao housingDao= HousingDao.getInstance();
    List<Housing> results;
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);
        try {
            results = housingDao.getTopTenHousingPriceLowToHigh();
            if (results == null) {
                messages.put("title", "no more list" + results);
            } else {
                messages.put("title", "works");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("housings", results);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);
        try {
            results = housingDao.getTopTenHousingPriceLowToHigh();
            if (results == null) {
                messages.put("title", "no more list" + results);
            } else {
                messages.put("title", "works");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("housings", results);
    }
}
