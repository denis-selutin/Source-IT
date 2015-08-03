<%@ page import="java.util.Date" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="application/img" language="java" %>

<%
    String s = "";
    for(Cookie c : request.getCookies()){
        s += c.getName() + "=" + c.getValue();
    }
    out.println(s);

    s = "";
    Enumeration<String> e = session.getAttributeNames();
    while(e.hasMoreElements()){
        String name = e.nextElement();
        s += session.getAttribute(name);
    }
    out.println(s);
%>

