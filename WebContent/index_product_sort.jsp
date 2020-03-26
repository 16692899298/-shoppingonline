<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>


	<c:set var="categoryInfo" value="${sessionScope.categoryInfo }"></c:set>

	<c:forEach items="${categoryInfo }" var="c">
		<dl>
			<dt>
				<a href="wwww?cate=parent&hpc_parent_id=${c[0].hpc_id  }">${c[0].hpc_name  }</a>
			</dt>
			<c:forEach items="${c[1] }" var="category">
				<dd>
					<a href="wwww?cate=child&hpc_child_id=${category.hpc_id }">${category.hpc_name }</a>
				</dd>
			</c:forEach>
		</dl>
	</c:forEach>


</div>

