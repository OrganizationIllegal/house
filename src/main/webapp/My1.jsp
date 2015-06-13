<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="obj" items="${HouseProjectList}"> 
<c:out value="${obj.project_name}"/><br> 
<c:out value="${obj.project_name}"/><br> 
<c:out value="${obj.project_area}"/><br> 
<c:out value="${obj.project_desc}"/><br> 
<c:out value="${obj.project_detail_add}"/><br> 
<c:out value="${obj.project_finish_time}"/><br> 
<c:out value="${obj.project_img}"/><br> 
<c:out value="${obj.project_nation}"/><br> 
<c:out value="${obj.project_price_avg}"/><br> 
<c:out value="${obj.project_sales_remain}"/><br>
<c:out value="${obj.project_style}"/><br> 
</c:forEach> 
<c:forEach var="obj" items="${HouseInfoList}"> 
  <c:out value="${obj.house_name}"/><br> 
 </c:forEach> 
<c:forEach var="obj" items="${BrokerInfoList}"> 
  <c:out value="${obj.broker_name}"/><br> 
 </c:forEach> 
