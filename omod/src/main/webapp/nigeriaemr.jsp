<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<br/>
<br/>
<table>
  <tr>
   <th>User Id</th>
   <th>User name</th>
  </tr>
  <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.userId}</td>
        <td>${user.username}</td>
      </tr>		
  </c:forEach>
</table>


