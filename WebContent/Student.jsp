<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript" src="jquery.js"></script>
<%!public void executeTest() {

		System.out.println("huraaaaaaa");
	}%>
<script type="text/javascript">
	function init() {

		$("#allCourses").hide();
		$("#searchCourses").hide();
		$("#weeklySchedule").hide();
		$("#course").hide();
		$("#menues")
				.html(
						"<td class='teacherButtons'><a href='#' onclick='courseList()'>لیست دروس</a></td>");
		$("#menues")
				.append(
						"<td class='teacherButtons'><a href='#' onclick='searchCourse()'>جستجوی درس</a></td>");
		$("#menues")
				.append(
						"<td class='teacherButtons'><a href='#' onclick='getSchedule()'>برنامه هفتگی</a></td>");
		// $("#menues").append("");
	}
	function courseList() {
		$("#allCourses").show();
		$("#searchCourses").hide();
		$("#weeklySchedule").hide();
		$("#course").hide();
	}
	function searchCourse() {
		$("#allCourses").hide();
		$("#searchCourses").show();
		$("#weeklySchedule").hide();
		$("#course").hide();
	}
	function getSchedule() {

		$("#allCourses").hide();
		$("#searchCourses").hide();
		$("#weeklySchedule").show();
		$("#course").hide();
	}
	function getCourseInf(){
		$("#course").show();
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>Student</title>
</head>
<body onload="init()">
<table>
	<tr id="menues"></tr>
</table>
<div id="content"></div>
<div id="allCourses">
<table id="coursesTable">
	<tr>
		<th>نام درس</th>
		<th>استاد درس</th>
		<th>تاریخ شروع</th>
		<th>ساعت کلاس</th>
		<th>اخذ درس</th>
	</tr>
	<tr>
		<td>ریاضی مهندسی</td>
		<td>فخار عزیزم</td>
		<td>شهریور</td>
		<td>15-17</td>
		<td><a href="#">اخذ</a></td>
	</tr>
</table>
</div>
<div id="searchCourses">
<form method="POST" action="SearchCourse">
<table>
<tr>
<td>جستجو در:</td>
<td>
<select>
	<option value="techerName" selected="selected">نام استاد</option>
	<option value="CourseName">نام درس</option>
	<option value="Date">تاریخ شروع</option>
</select>
</td>
</tr>
<tr>
<td>عبارت جستجو:</td>
<td><input type="text" /></td>
</tr>
</table>
<input type="submit" value="جستجو" onclick="getCourse()"></form>

</div>
<div id="weeklySchedule">
<table id="scheduleTable">
	<tr>
		<th></th>
		<th>8 - 10</th>
		<th>10 - 12</th>
		<th>14 - 16</th>
		<th>16 - 18</th>
	</tr>
	<tr>
		<td>شنبه</td>
		<td>-</td>
		<td>-</td>
		<td>-</td>
		<td><a href="#" onclick="getCourseInf()"> ریاضی مهندسی </a></td>
	</tr>
	<tr>
		<td>یکشنبه</td>
		<td>-</td>
		<td><a href="#" onclick="getCourseInf()"> ریاضی مهندسی </a></td>
		<td>-</td>
		<td>-</td>
	</tr>
</table>


</div>


</body>
<div id="course">
<table>
	<tr>
		<td>نام درس:</td>
		<td>ریاضیات مهندسی</td>
	</tr>
	<tr>
		<td>استاد:</td>
		<td>فخار عزیز</td>
	</tr>
	<tr>
		<td>نمره:</td>
		<td>20</td>
	</tr>
</table>
</div>


</html>