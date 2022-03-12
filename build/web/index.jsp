<%--<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>

<%
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
%>

<script>
    alert("RECORD SUBMITED...#");
</script>


<%
    }

%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="bootstrap/bootstrap-4.5.2-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/bootstrap-4.5.2-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background: url(img/1236480.jpg) ; background-size: cover ; background-attachment: fixed ;" >
        <h1> Student Management System...# </h1>

        </br>
        <div class="row">
            <div class="col-sm-4">
                <form method="post" action="#">

                    <div alight="left">
                        <label class="form-label"> Name </label>
                        <input type="text" class="form-control" placeholder="Student Name" name="name" id="name">
                    </div>

                    </br>
                    <div alight="left">
                        <select class="browser-default custom-select custom-select-md mb-3" name="course" id="course">
                            <option selected>Course</option>
                            <option value="Javascript">JavaScript</option>
                            <option value="Java">Java</option>
                            <option value="C++">C++</option>
                            <option value="Python">Python</option>
                            <option value="C">C</option>
                        </select>                       
                    </div>

                    <div alight="left">
                        <label class="form-label"> Mobile no. </label>
                        <input type="number" class="form-control" placeholder="Mobile No." name="mob" id="mob">

                    </div>

                    </br>

                    <div alight="right">
                        <input type="submit" class="btn btn-info" value="submit"  id="submit" name="submit">
                        <input type="reset" class="btn btn-warning" value="reset"  id="reset" name="reset">
                    </div>
                </form>
            </div>

            <div class="col-sm-8">        
                <div class="panel-body">
                    <table id="tbl-student" class="table table-responsive table-bordered" cellpadding="0" width="100%">
                        <thead>
                            <tr>
                                <th>Student Name</th>
                                <th>Course</th>
                                <th>Mobile</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>


                            <%  
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=Australia/Sydney", "root", "");

                                String query = "select * from stu";
                                Statement st = con.createStatement();
                                ResultSet s = st.executeQuery(query);

                                while (s.next()) {
                                    String id = s.getString("id");

                            %>
                            <tr>
                                <td><%=s.getString("name")%></td>
                                <td><%=s.getString("course")%></td>
                                <td><%=s.getString("mob")%></td>
                                <td><a href="update.jsp?id=<%=id%>">Update</a></td>
                                <td><a href="delete.jsp?id=<%=id%>">Delete</a></td>



                            </tr>

                            <% }%>

                        </thead>
                    </table>
                </div>
            </div>

        </div>

    </body>
</html>
