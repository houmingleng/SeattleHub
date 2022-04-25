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
import java.util.Map;
@WebServlet("/edithousing")
public class HousingUpdateServlet  extends HttpServlet {
    protected HousingDao houseDao;

    @Override
    public void init() throws ServletException {
        houseDao = HousingDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> messages = new HashMap<>();
        String houseid = req.getParameter("houseId");

        int houseId = Integer.parseInt(houseid);
        try {
            Housing house = houseDao.getHousingByHousingId(houseId);
            String houseName = req.getParameter("HouseName");
            String Price = req.getParameter("price");
            int price = Integer.parseInt(Price);
            String address = req.getParameter("address");
            String ZipCode = req.getParameter("zipcode");
            int zipCode = Integer.parseInt(ZipCode);
            String Latitude = req.getParameter("latitude");
            double latitude = Double.parseDouble(Latitude);
            String Longitude = req.getParameter("longitude");
            double longitude = Double.parseDouble(Longitude);


            house = houseDao.updateHousing(house,houseName,price,address,zipCode,latitude,longitude);
            messages.put("success","Successfully updated");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }
        resp.sendRedirect("edit.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> messages = new HashMap<>();
        String houseid = req.getParameter("houseId");

        int houseId = Integer.parseInt(houseid);
        try {
            Housing house = houseDao.getHousingByHousingId(houseId);
            String houseName = req.getParameter("HouseName");
            String Price = req.getParameter("price");
            int price = Integer.parseInt(Price);
            String address = req.getParameter("address");
            String ZipCode = req.getParameter("zipcode");
            int zipCode = Integer.parseInt(ZipCode);
            String Latitude = req.getParameter("latitude");
            double latitude = Double.parseDouble(Latitude);
            String Longitude = req.getParameter("longitude");
            double longitude = Double.parseDouble(Longitude);


            house = houseDao.updateHousing(house,houseName,price,address,zipCode,latitude,longitude);
            messages.put("success","Successfully updated");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException();
        }
        resp.sendRedirect("edit.jsp");
    }
}
