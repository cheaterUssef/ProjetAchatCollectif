<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sujet Show</title>
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
                        <th>nombre maximum d'adherent</th>
                        <th>Créateur</th>
                        <th>duree de validité</th>
                        <th>type</th>
                        <th>taux_reduction</th>
                        <th>prix_diminue</th>
                        <th>date création</th>                        
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>contenu</th>
                        <th>date creation</th>
                        <th>sujet name</th>
                        <th>user name</th>
                        <th>delete</th>                     
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${comments}" var="comment">
                    <tr>
                        <td>${comment.contenu}</td>
                        <td>${comment.date_creation}</td>
                        <td>${comment.sujet.name}</td>
                        <td>${comment.user.firstName}</td>
                        <td>
                        		<sec:authorize access="hasRole('USER')">
	                        		<c:if test="${current_user_comments_ids.contains(comment.id)}">
		                        	<c:url var="deleteUrl" value="/comment/${comment.id}/delete" />
		                        	<form:form method="POST" action="${deleteUrl}">
		                        		<input type="submit" class="btn btn-block btn-primary btn-default" value="delete">
		                        	</form:form>
		                        	</c:if>
	                        	</sec:authorize>
	                        	<sec:authorize access="hasRole('ADMIN')">
	                        		<c:url var="deleteUrl" value="/comment/${comment.id}/delete" />
		                        	<form:form method="POST" action="${deleteUrl}">
		                        		<input type="submit" class="btn btn-block btn-primary btn-default" value="delete">
		                        	</form:form>
	                        	</sec:authorize>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
             </table>
        </div>
        <c:url var="newComment" value="/comment/${sujet.id}/newcomment"/>
        <form:form method="POST" modelAttribute="commentaire" class="form-horizontal" action="${newComment}">
            <form:input type="hidden" path="id" id="id"/>
            
            <div class="row">
                <div class="form-group col-md-12">
                    <div class="col-md-7">
                        <form:input type="text" path="contenu" id="contenu" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="contenu" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-actions floatRight">
                    
                 <input type="submit" value="ajouter" class="btn btn-primary btn-sm"/>
                </div>
            </div>
            
        </form:form>
            
    </div>
</body>
</html>