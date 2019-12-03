package opdracht4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/adressservlet")
public class AdressServlet extends HttpServlet {

    AdressServiceImpl adressServiceImpl = new AdressServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/AdressForm.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AdressBean adressBean = new AdressBean();
        adressBean.setName(req.getParameter("name"));
        adressBean.setFirstName(req.getParameter("firstname"));
        adressBean.setStreet(req.getParameter("street"));
        adressBean.setEmail(req.getParameter("email"));
        adressBean.setHouseNumber(req.getParameter("housenumber"));
        adressBean.setPhoneNumber(req.getParameter("phonenumber"));
        adressBean.setPostalCode(req.getParameter("postalcode"));
        adressBean.setCountry(req.getParameter("country"));


        adressServiceImpl.registerAdress(adressBean);

        req.setAttribute("adressBeanName", adressBean.getName());
        req.setAttribute("adressBeanFirstname", adressBean.getFirstName());
        req.setAttribute("adressBeanStreet", adressBean.getStreet());
        req.setAttribute("adressBeanPostalcode", adressBean.getPostalCode());
        req.setAttribute("adressBeanCountry", adressBean.getCountry());
        req.setAttribute("adressBeanPhonenumber", adressBean.getPhoneNumber());
        req.setAttribute("adressBeanEmail", adressBean.getEmail());




        req.getRequestDispatcher("/WEB-INF/pages/AdressResult.jsp").forward(req, resp);
    }
}
