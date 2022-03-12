package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    if (request.getParameter("submit") != null) {

        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String mob = request.getParameter("mob");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=Australia/Sydney", "root", "");

        PreparedStatement pst = con.prepareStatement("insert into stu( name , course , mob) values( ? , ? , ?) ");
        pst.setString(1, name);
        pst.setString(2, course);
        pst.setString(3, mob);
        pst.executeUpdate();

      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    alert(\"RECORD SUBMITED...#\");\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");

    }


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("        <link href=\"bootstrap/bootstrap-4.5.2-dist/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"bootstrap/bootstrap-4.5.2-dist/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background: url(img/1236480.jpg) ; background-size: cover ; background-attachment: fixed ;\" >\n");
      out.write("        <h1> Student Management System...# </h1>\n");
      out.write("\n");
      out.write("        </br>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <form method=\"post\" action=\"#\">\n");
      out.write("\n");
      out.write("                    <div alight=\"left\">\n");
      out.write("                        <label class=\"form-label\"> Name </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Student Name\" name=\"name\" id=\"name\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    </br>\n");
      out.write("                    <div alight=\"left\">\n");
      out.write("                        <select class=\"browser-default custom-select custom-select-md mb-3\" name=\"course\" id=\"course\">\n");
      out.write("                            <option selected>Course</option>\n");
      out.write("                            <option value=\"Javascript\">JavaScript</option>\n");
      out.write("                            <option value=\"Java\">Java</option>\n");
      out.write("                            <option value=\"C++\">C++</option>\n");
      out.write("                            <option value=\"Python\">Python</option>\n");
      out.write("                            <option value=\"C\">C</option>\n");
      out.write("                        </select>                       \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div alight=\"left\">\n");
      out.write("                        <label class=\"form-label\"> Mobile no. </label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" placeholder=\"Mobile No.\" name=\"mob\" id=\"mob\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    </br>\n");
      out.write("\n");
      out.write("                    <div alight=\"right\">\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-info\" value=\"submit\"  id=\"submit\" name=\"submit\">\n");
      out.write("                        <input type=\"reset\" class=\"btn btn-warning\" value=\"reset\"  id=\"reset\" name=\"reset\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-sm-8\">        \n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <table id=\"tbl-student\" class=\"table table-responsive table-bordered\" cellpadding=\"0\" width=\"100%\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Student Name</th>\n");
      out.write("                                <th>Course</th>\n");
      out.write("                                <th>Mobile</th>\n");
      out.write("                                <th>Edit</th>\n");
      out.write("                                <th>Delete</th>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");
  
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=Australia/Sydney", "root", "");

                                String query = "select * from stu";
                                Statement st = con.createStatement();
                                ResultSet s = st.executeQuery(query);

                                while (s.next()) {
                                    String id = s.getString("id");

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(s.getString("name"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(s.getString("course"));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(s.getString("mob"));
      out.write("</td>\n");
      out.write("                                <td><a href=\"update.jsp?id=");
      out.print(id);
      out.write("\">Update</a></td>\n");
      out.write("                                <td><a href=\"delete.jsp?id=");
      out.print(id);
      out.write("\">Delete</a></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                        </thead>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
