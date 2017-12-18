<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Upload/Download/Delete Documents</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div align="center">
        <h1>Spring MVC - Hibernate File Upload to Database Demo</h1>
        <c:url var="upload" value="/image/doUpload" />
        <form method="post" action="${upload}"  enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
               
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                    <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
                </tr> 

             </table> 
        </form>

 <%--  <form:form method="POST"  action="${upload}" enctype="multipart/form-data" class="form-horizontal">
             
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="file">Upload a document</label>
                            <div class="col-md-7">
                                <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="file" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>
              
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                        </div>
                    </div>
   					  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form:form> --%>
    </div>
</body>
</html>