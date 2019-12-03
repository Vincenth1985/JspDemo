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

        adressServiceImpl.registerAdress(adressBean);

        req.setAttribute("adressBean", adressBean.getName());

        req.getRequestDispatcher("/WEB-INF/pages/AdressResult.jsp").forward(req, resp);
    }
}
