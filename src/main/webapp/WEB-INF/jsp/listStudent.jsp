<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>stuName</td>
            <td>age</td>
            <td>sex</td>
            <td>gradeName</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="t" varStatus="st">
            <tr>
                <td>${t.id}</td>
                <td>${t.stuname}</td>
                <td>${t.age}</td>
                <td>${t.sex}</td>
                <td>${t.gradename}</td>
                <td><a href="editTStudent?id=${t.id}">编辑</a></td>
                <td><a href="deleteTStudent?id=${t.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <a href="?start=1">[首 页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末 页]</a>
    </div>
    <br>
    <form action="addTStudent" method="post">
        stuname: <input type="text" name="stuname" placeholder="stuname"/>
        age:<input type="number" name="age" placeholder="age"/>
        <br>
        sex:<input type="text" name="sex" placeholder="sex"/>
        gradename:<input type="text" name="gradename" placeholder="gradename"/>
        <br>
        <input type="submit" value="提交"/>
    </form>
</div>