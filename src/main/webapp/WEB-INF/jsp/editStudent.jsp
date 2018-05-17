<%--
  Created by IntelliJ IDEA.
  User: Scott Lee
  Date: 2018/5/10
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<div style="margin:0px auto; width:500px">

    <form action="updateTStudent" method="post">

        name: <input type="text" name="stuname" value="${t.stuname}">
        age:<input type="number" name="age" value="${t.age}">
        <br>
        sex:<input type="text" name="sex" value="${t.sex}">
        gradeName:<input type="text" name="gradeName" value="${t.gradename}">
        <br>

        <input name="id" type="hidden" value="${t.id}">
        <button type="submit">提交</button>

    </form>
</div>