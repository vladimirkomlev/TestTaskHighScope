<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sq" uri="/struts-jquery-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form action="ResultAction">
        <s:select label="Select country "
                  list="listNamesCountries"
                  name="selectedCountry"/>
        <sq:submit tergets="leftDiv"
                   value="Submit"
                   button="true"/>
    </s:form>
    <br>
    <div id="leftDiv">
        <s:include value="result.jsp"></s:include>
    </div>

</body>
</html>
