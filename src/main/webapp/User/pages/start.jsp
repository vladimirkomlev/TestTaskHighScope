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
                  name="selectedCountry"
                  id="selecedCountryId"/>
    </s:form>
    <br>
    <s:submit id="resultId" value="Result"/>
    <br>
    <div id="resultDiv"></div>
</body>
</html>
