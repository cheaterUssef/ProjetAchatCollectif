<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <th>sujet id</th>
                        <th>user id</th>                       
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${comments}" var="comment">
                    <tr>
                        <td>${comment.contenu}</td>
                        <td>${comment.date_creation}</td>
                        <td>${comment.sujet.name}</td>
                        <td>${comment.user.firstName}</td>
                    </tr>
                </c:forEach>
                </tbody>
             </table>
        </div>
        
        
            
    </div>
</body>
</html>