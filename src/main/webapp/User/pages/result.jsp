<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:set name="result" value="selectedCountry"/>
<s:if test="%{#result!=null}">
    <table border="1">
        <tr>
            <th>LastName</th>
            <th>Region</th>
            <th>Amount</th>
        </tr>
        <s:iterator value="listOrdersByCountry">
            <tr>
                <td>
                    <s:property value="lastName"/>
                </td>
                <td>
                    <s:property value="regionId"/>
                </td>
                <td>
                    <s:property value="amount"/>
                </td>
            </tr>
        </s:iterator>
    </table>
</s:if>
