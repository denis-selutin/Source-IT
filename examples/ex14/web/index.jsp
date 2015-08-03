<%@ page import="java.util.Date" %>
<%@ page contentType="text/html" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
  <head>
    <title>This is my page</title>
      <style>
        .test {
            color: red;
            background-color: aqua;
        }
        .test2 {
            color: white;
        }
        h1 {

        }
        #id1 {
          color: red !important;
        }

      </style>
  </head>
  <body class="test">
  <%!
      Date getDate() {
          System.out.println("Executed getDate");
          return new Date();
      }
      %>
  <%=request.getCookies()%>
    This is index page with counter <%=session.getAttribute("counter")%> on <%= getDate()%>

  <%@include file="simplePage.jsp"%>

  <%
      if(request.getCookies() != null)
      for(Cookie c: request.getCookies()) {
          out.write(c.getName() + " = " + c.getValue());
      }
  %>
  <form action="WEB-INF/pages/formAciton.jsp" method="post">
      <input id="id1" name="a1" type="text" class="test2">
      <input type="submit">
  </form>
  </body>
</html>
