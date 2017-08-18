 <%@ page session="false" %> 
 <%	
	String url = request.getContextPath() + "/loginLocale.action";	
	response.sendRedirect(response.encodeURL(url));
%>