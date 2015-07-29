<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%!
      Date getDate() {
          System.out.println("Executed getDate");
          return new Date();
      }
      %>
    This is index page with counter <%=session.getAttribute("counter")%> on <%= getDate()%>

  <form action="formAciton.jsp" method="post">
      <input name="a1" type="text">
      <input type="submit">
  </form>
  </body>
</html>
