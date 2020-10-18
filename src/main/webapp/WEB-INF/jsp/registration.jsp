<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Registration</title>
    <style>
        .error {
            color: #FF0000
        }
        .errorBlock {
            color: #000;
            background-color: #FFEEEE;
            border: 3px solid #FF0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
    <h1><spring:message code="welcome.text" /></h1>
    <form:form modelAttribute="registration" method="POST">
          <form:errors path="*" cssClass="errorBlock" element="div" />
          <table>
            <tr>
                <td><spring:message code="name.first" />:</td>
                <td><form:input path="firstName" name="firstName" type="text" placeholder="My First Name"/></td>
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="name.last" />:</td>
                <td><form:input path="lastName" name="lastName" type="text" placeholder="My Last Name"/></td>
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="OK" /></td>
            </tr>
          </table>
      </form:form>
      <h3>${message}</h3>
</body>
</html>