<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 注意：ShowCalendar.js所在文件夹应放在WebRoot里，WEB-INF外！！！！！！！！ -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>

<title>添加简历的视图</title>
</head>
<body style="text-align: center;">
	<br />
	<form id="form"
		action="${pageContext.request.contextPath }/AddCustomerServlet"
		method="post" onsubmit="return makepre()">
		<table border="1" width="50%" align="center">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<!-- 
                页面到底输出几个性别，不是在页面中显示的，而是由一个程序维护的，这个程序有几个性别，页面中就输出几个性别 
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
                --> <c:forEach var="gender" items="${genders }">
						<input type="radio" name="gender" value="${gender }">${gender }
                </c:forEach>
				</td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthday" id="birthday"
					onclick="showCalendar(this.id)"> <!-- <input type="text" name="birthday" id="birthday" title="点击选择" onclick="showCalendar(this.id)"> -->
				</td>
			</tr>

			<tr>
				<td>手机</td>
				<td><input type="text" name="cellphone"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><c:forEach var="p" items="${preferences }">
						<input type="checkbox" name="pre" value="${p }">${p }
                </c:forEach></td>
			</tr>
			<tr>
				<td>客户类型</td>
				<td><c:forEach var="type" items="${types }">
						<input type="radio" name="type" value="${type }">${type }
                </c:forEach></td>
			</tr>
			<tr>
				<td>客户备注</td>
				<td><textarea rows="5" cols="60" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="reset" value="重置"></td>
				<td><input type="submit" value="添加简历"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function makepre() {
			var pres = document.getElementsByName("pre");
			var preference = "";
			for (var i = 0; i < pres.length; i++) {
				var input = pres[i];
				if (input.checked == true) {
					preference = preference + input.value + ",";
				}
			}
			preference = preference.substring(0, preference.length - 1); // preference="唱歌,跳舞,夜生活";

			// 在form表单创建一个input隐藏输入项，如：<input type="hidden" name="preference" value="唱歌,跳舞,夜生活,...">
			var form = document.getElementById("form");
			var input = document.createElement("input");
			input.type = "hidden";
			input.name = "preference";
			input.value = preference;

			form.appendChild(input);
			return true;
		}
		
	</script>
</body>
</html>
