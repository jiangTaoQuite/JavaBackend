<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询商品列表</title>
    <script>
        function deleteItems() {
            document.itemsForm.action = "${pageContext.request.contextPath}/items/deleteItems.action";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
<form name="itemsForm" action="${pageContext.request.contextPath}/items/queryItem.action" method="post">
    <table width="100%" border=1>
        商品类别：
        <tr>
            <select>
                <c:forEach var="item" items="${itemsType}">
                    <option value="${item.key}">${item.value}</option>
                </c:forEach>
            </select>
        </tr>
        <tr>
            查询条件：
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
            <td>操作</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${itemsList }" var="item">
            <tr>
                <td>${item.name }</td>
                <td>${item.price }</td>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH-mm-ss"/></td>
                <td>${item.detail }</td>
                <td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>
                <td><a href="${pageContext.request.contextPath }/items/viewItems/${item.id}">商品信息</a></td>
                <td><label>
                    <input type="checkbox" name="delete_id" value="${item.id}">
                </label></td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="批量删除" onclick="deleteItems()">
</form>
</body>

</html>