<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>

<div class="container">
<div class="navbar">
   <p class="brand">Current Category List</p>
    	</div><br/><br/>
    <div class="datagrid">
        
        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>Category</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="2">
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="category" items="${categoryList}" varStatus="rowCounter">
        
                <tr >
                    <td>${category.name}</td>                    
                </tr>
            </c:forEach>
       
            </tbody>
        </table>
        <div class="navbar">
   			<p class="brand">Add A New Category</p>
    	</div>
    	<br /><br />
    	<form  action="/createCategory.do" method="post">
    	<br />
        <input type="text" name="category"><br />
        <input type="submit" value="Add Category">
        </form>
    </div>

</div>


