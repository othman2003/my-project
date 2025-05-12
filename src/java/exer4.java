
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserServlet")
public class exer4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");

        
        String[] languages = request.getParameterValues("languages");
        List<String> languagesList = new ArrayList<>();
        if (languages != null) {
            for (String language : languages) {
                languagesList.add(language);
            }
        }

      
        String ageStatus = (age >= 18) ? "بالغ" : "قاصر";

       
        String genderPrefix = (gender.equals("ذكر")) ? "السيد" : "السيدة";

      
        StringBuilder message = new StringBuilder();
        message.append("مرحبًا بـ ").append(genderPrefix).append(" ").append(firstName).append(" ").append(lastName)
               .append(", لغاتك المفضلة هي ");
        
        if (languagesList.isEmpty()) {
            message.append("لا توجد لغات مفضلة.");
        } else {
            for (int i = 0; i < languagesList.size(); i++) {
                message.append(languagesList.get(i));
                if (i < languagesList.size() - 1) {
                    message.append(" و ");
                }
            }
        }
        
        message.append(". أنت ").append(ageStatus).append(".");

       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message.toString() + "</h1>");
        out.println("<a href='index.html'>رجوع</a>");
        out.println("</body></html>");
    }
}
