package opdracht4;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/sessionservlet")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        PrintWriter printWriter = resp.getWriter();
        String newFriend = "";
        String oldFriend = "";
        String firstname = req.getParameter("firstname");


        httpSession.setAttribute("firstname", firstname);

        if (httpSession.isNew()) {
            int counter = 1;
            newFriend = "hello new friend";
            httpSession.setAttribute("newfriend", newFriend);
            httpSession.setAttribute("counter", counter);
            req.getRequestDispatcher("WEB-INF/pages/FirstLoginSession.jsp").forward(req, resp);


        } else {
            Integer counter = (Integer) httpSession.getAttribute("counter");
            counter++;
            oldFriend = "hello old friend";
            firstname = (String) httpSession.getAttribute("firstname");

            httpSession.setAttribute("newfriend", oldFriend);
            httpSession.setAttribute("counter", counter);
            httpSession.setAttribute("firstname", firstname);
            req.getRequestDispatcher("WEB-INF/pages/OldUser.jsp").forward(req, resp);


        }


    }
}
