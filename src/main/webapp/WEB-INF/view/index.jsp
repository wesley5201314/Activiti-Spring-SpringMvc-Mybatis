<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h1>用户信息</h1>
<c:forEach items="${userList}" var="user">
    <option>
        <h2>Hello! ${user.username}</h2>
    </option>
</c:forEach>
<hr/>
<a href="/model/create">自动创建创建一个模型</a>
<hr/>
<h2>模型列表</h2>
<table bgcolor="#e0ffff" border="1">
    <tr><th>模型名</th><th>模型ID</th><th>创建时间</th><th>最后更新时间</th><th>操作</th></tr>
    <c:forEach items="${activitiModels}" var="model">
        <tr><td>${model.name}</td><td>${model.id}</td><td>${model.createTime}</td><td>${model.lastUpdateTime}</td><td>
            <a href="/process-editor/modeler.html?modelId=${model.id}">编辑模型</a>|
            <a href="/model/deploy/${model.id}">部署</a>|
            <a href="/model/export/${model.id}">导出为xml文件</a>|
            <a href="/model/delete/${model.id}">删除模型</a>
        </td></tr>
    </c:forEach>
</table>

${message}
</body>
</html>
