<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Sujet</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <%@include file="authheader.jsp" %>
        <div class="well lead">Sujet Creation Form</div>
        <form:form method="POST" modelAttribute="sujet" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>
             
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="lastName">description</label>
                    <div class="col-md-7">
                        <form:input type="text" path="description" id="description" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="description" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="prix_original">prix original</label>
                    <div class="col-md-7">
                        <c:choose>
                            <c:when test="${edit}">
                                <form:input type="number" path="prix_original" id="prix_original" class="form-control input-sm" disabled="true"/>
                            </c:when>
                            <c:otherwise>
                                <form:input type="number" path="prix_original" id="prix_original" class="form-control input-sm" />
                                <div class="has-error">
                                    <form:errors path="prix_original" class="help-inline"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="nombre_adherent">nombre_adherent</label>
                    <div class="col-md-7">
                        <form:input type="number" path="nombre_adherent" id="nombre_adherent" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="nombre_adherent" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="nombre_max_adherent">nombre_max_adherent</label>
                    <div class="col-md-7">
                        <form:input type="number" path="nombre_max_adherent" id="nombre_max_adherent" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="nombre_max_adherent" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="taux_reduction">taux_reduction</label>
                    <div class="col-md-7">
                        <form:input type="number" path="taux_reduction" id="taux_reduction" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="taux_reduction" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="duree_validite">duree de validité</label>
                    <div class="col-md-7">
                        <form:input type="number" path="duree_validite" id="duree_validite" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="duree_validite" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="sujet_type">Type</label>
                    <div class="col-md-7">
                    	<form:select path="sujet_type" items="${types}" itemValue="id" itemLabel="type" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="sujet_type" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>