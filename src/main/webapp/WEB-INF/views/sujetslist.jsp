<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sujets List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Sujets</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>prix original</th>
                        <th>nombre adherent</th>
                        <th>nbr max adherent</th>
                        <th>Créateur</th>
                        <th>duree validité</th>
                        <th>type</th>
                        <th>taux_reduction</th>
                        <th>prix_diminue</th>
                        <th>date création</th>
                        <th>show details</th> 
                        <th>delete</th>
                        <th>adherer</th>            
                    </tr>
                </thead>
                <tbody>
                
	                <c:forEach items="${sujets}" var="sujet">
	                    <tr>
	                        <td>${sujet.name}</td>
	                        <td>${sujet.description}</td>
	                        <td>${sujet.prix_original}</td>
	                        <td>${sujet.nombre_adherent}</td>
	                        <td>${sujet.nombre_max_adherent}</td>
	                        <td>${sujet.user.firstName}</td>
	                        <td>${sujet.duree_validite}</td>
	                        <td>${sujet.sujet_type.type}</td>
	                        <td>${sujet.taux_reduction}</td>
	                        <td>${sujet.prix_diminue}</td>
	                        <td>${sujet.date_creation}</td>
	                        <td><a href="<c:url value='/sujet/${sujet.id}/show' />">show details</a></td>
	                        <td>
	                        	<sec:authorize access="hasRole('USER')">
	                        		<c:if test="${current_user_sujet_ids.contains(sujet.id)}">
		                        	<c:url var="deleteUrl" value="/sujet/${sujet.id}/delete" />
		                        	<form:form method="POST" action="${deleteUrl}">
		                        		<input type="submit" class="btn btn-block btn-primary btn-default" value="delete">
		                        	</form:form>
		                        	</c:if>
	                        	</sec:authorize>
	                        	<sec:authorize access="hasRole('ADMIN')">
	                        		<c:url var="deleteUrl" value="/sujet/${sujet.id}/delete" />
		                        	<form:form method="POST" action="${deleteUrl}">
		                        		<input type="submit" class="btn btn-block btn-primary btn-default" value="delete">
		                        	</form:form>
	                        	</sec:authorize>
	                        </td>
	                    	<td>
	                    		<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
	                    			<c:if test="${!current_user_sujets_adheres_ids.contains(sujet.id) && !current_user_sujet_ids.contains(sujet.id)}">
			                        	<c:if test="${sujet.nombre_adherent < sujet.nombre_max_adherent}">
											<c:url var="adhererUrl" value="/sujet/${sujet.id}/adherer" />
				                        	<form:form method="POST" action="${adhererUrl}">
				                        		<input type="submit" class="btn btn-block btn-success btn-default" value="adherer">
				                        	</form:form>
			                        	</c:if>
			                        	<c:if test="${sujet.nombre_adherent == sujet.nombre_max_adherent}">
			                        		<span>nbre max atteint</span>
			                        	</c:if>
		                        	</c:if>
		                        	<c:if test="${current_user_sujets_adheres_ids.contains(sujet.id)}">
		                        		<span>Déjà adheré</span>
		                        	</c:if>
	                        	</sec:authorize>
	                    	</td>
	                    </tr>
	                </c:forEach>
                
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>