<%@page import="java.sql.*" %>
<%
    String id = request.getParameter("id");
    ResultSet rs;

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=Australia/Sydney", "root", "");

    PreparedStatement pst = con.prepareStatement("delete from stu where id = ?");
    pst.setString(1, id);
    pst.executeUpdate();
    response.sendRedirect("index.jsp"); 
%>

<script>

    alert("Record Deletee");

</script>