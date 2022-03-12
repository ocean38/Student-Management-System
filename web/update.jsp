<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
    if (request.getParameter("submit") != null) {

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String course = request.getParameter("course");
        String mob = request.getParameter("mob");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=Australia/Sydney", "root", "");

        PreparedStatement pst = con.prepareStatement("update stu set name=? , course=? , mob=? where id=? ");
        pst.setString(1, name);
        pst.setString(2, course);
        pst.setString(3, mob);
        pst.setString(4, id);
        pst.executeUpdate();
        response.sendRedirect("index.jsp");  
%>

<script>
    alert("Update Success...#");
</script>


<%
    }
    
%>








<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
        <link href="bootstrap/bootstrap-4.5.2-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/bootstrap-4.5.2-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Edit...#</h1>
        <div class="row">
            <div class="col-sm-4">
                <form method="post" action="#">

                    <%
                        
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=Australia/Sydney", "root", "");

                        String id = request.getParameter("id");

                        PreparedStatement pst = con.prepareStatement("select * from stu where id = ?");
                        pst.setString(1, id);
                        System.out.println(pst);
                        ResultSet s = pst.executeQuery();

                        while (s.next()) {


                    %>

                    <div alight="left">
                        <label class="form-label"> Name </label>
                        <input type="text" class="form-control" value="<%= s.getString("name")%>" placeholder="Student Name" name="name" id="name" required>
                    </div>

                    <div alight="left">
                        <label class="form-label"> Course </label>
                        <input type="text" class="form-control" value="<%= s.getString("course")%>" placeholder="Course" name="course" id="course" required>
                    </div>

                    <div alight="left">
                        <label class="form-label"> Mobile no. </label>
                        <input type="text" class="form-control" value="<%= s.getString("mob")%>" placeholder="Mobile No." name="mob" id="mob" required>
                    </div>

                    </br>

                    <% }%>

                    <div alight="right">
                        <input type="submit" class="btn btn-info" value="submit"  id="submit" name="submit">
                        <input type="reset" class="btn btn-warning" value="reset"  id="reset" name="reset">
                    </div>

                    <div align="right">
                        <p> <a href="index.jsp"> CLICK HERE TO GO BACK </a> </p>
                    </div>
                    
                    
                </form>
            </div>
        </div>    
    </body>
</html>
