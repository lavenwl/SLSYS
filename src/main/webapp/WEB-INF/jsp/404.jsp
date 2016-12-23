<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<%@include file="common/head.jsp" %>
	</head>
	
	<body>

    <!-- Main content -->
    <section class="page-error">
        <div class="error-page">
            <h2 class="headline text-info">404</h2>
            <div class="error-content">
                <h3><i class="fa fa-warning text-yellow"></i> Oops! Page not found.</h3>
                <p>
                    We could not find the page you were looking for. Meanwhile, you may <a class="error-link" href='index.jsp'>return to dashboard</a> or try using the search form.
                </p>
                <form class='search-form'>
                    <input type="text" name="search" class='form-control' placeholder="Search">
                </form>
            </div>
            <!-- /.error-content -->
        </div>
        <!-- /.error-page -->
    </section>
    <!-- MAIN EFFECT -->
	</body>
</html>

