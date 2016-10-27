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

		$("#newClass").hide();
		$("#viewCourse").hide();
		$("#weeklySchedule").hide();
		$("#menues")
				.html(
						"<td class='teacherButtons'><a href='#' onclick='newCourse()'>درس جدید</a></td>");
		$("#menues")
				.append(
						"<td class='teacherButtons'><a href='#' onclick='getSchedule()'>برنامه هفتگی</a></td>");
		$("#menues")
				.append(
						"<td class='teacherButtons'><a href='#' onclick='getCourse()'>درس </a></td>");
		$("#menues")
				.append(
						"<td class='teacherButtons'><a href='#' onclick='getCourse()'>درس دوم </a></td>");
		// $("#menues").append("");
	}
	function newCourse() {
		$("#newClass").show();
		$("#viewCourse").hide();
		$("#weeklySchedule").hide();
	}
	function getSchedule() {
		$("#newClass").hide();
		$("#viewCourse").hide();
		$("#weeklySchedule").show();
		$("#scheduleTable").hide();
	}
	function getCourse() {

		$("#newClass").hide();
		$("#viewCourse").show();
		$("#weeklySchedule").hide();
	}
	function getScheduleTable(){
		$("#scheduleTable").show();
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>Teacher</title>
</head>
<body onload="init()">
<table>
	<tr id="menues"></tr>
</table>
<div id="newClass">
<form method="POST" action="AddCourse">
<table>
	<tr>
		<td>عنوان دوره:</td>
		<td><input type="text" name="courseTitle"></td>
	</tr>
	<tr>
		<td>شروع دوره:</td>
		<td><select name="Cstart" >
			<option value="1">فروردین</option>
			<option value="2">اردیبهشت</option>
			<option value="3">خرداد</option>
			<option value="4">تیر</option>
			<option value="5">مرداد</option>
			<option value="6">شهریور</option>
			<option value="7">مهر</option>
			<option value="8">آبان</option>
			<option value="9">آذر</option>
			<option value="10">دی</option>
			<option value="11">بهمن</option>
		</select></td>
	</tr>
	<tr>
		<td>ساعت کلاس:</td>
		<td><select name="hstart" id="hstart">
			<option value="8">8-10</option>
			<option value="10">10-12</option>
			<option value="14">14-16</option>
			<option value="16">16-18</option>
		</select></td>
	</tr>
	<tr>
		<td><input type="submit" value="افزودن درس"></td>
	</tr>
</table>

</form>
</div>
<div id="viewCourse">
<form method="POST" action="ResetMarks">
<table id="classMembers">
	<tr>
		<th>نام دانشجو</th>
		<th>نمره</th>
	</tr>
	<tr>
		<td>بهاره</td>
		<td><input type="text" value="20"></td>
	</tr>
	<tr>
		<td>بهاره</td>
		<td><input type="text" value="20"></td>
	</tr>
	<tr>
		<td>بهاره</td>
		<td><input type="text" value="20"></td>
	</tr>
</table>

<input type="submit" value="ثبت" onclick="getCourse()"></form>

</div>
<div id="weeklySchedule">
<form>
<table>
	<tr>
		<td>انتخاب ماه:</td>
		<td><select>
			<option value="1" selected="selected">فروردین</option>
			<option value="2">اردیبهشت</option>
			<option value="3">خرداد</option>
			<option value="4">تیر</option>
			<option value="5">مرداد</option>
			<option value="6">شهریور</option>
			<option value="7">مهر</option>
			<option value="8">آبان</option>
			<option value="9">آذر</option>
			<option value="10">دی</option>
			<option value="11">بهمن</option>
			<option value="12">اسفند</option>
		</select></td>
	</tr>
	<tr>
		<td>هفته:</td>
		<td><select>
			<option value="1" selected="selected">اول</option>
			<option value="2">دوم</option>
			<option value="3">سوم</option>
			<option value="4">چهارم</option>
		</select>
		</td>
		<tr>
</table>
<input type="button" value="دریافت برنامه" onclick="getScheduleTable()">
</form>

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
		<td><a href="#"> ریاضی مهندسی </a></td>
	</tr>
	<tr>
		<td>یکشنبه</td>
		<td>-</td>
		<td><a href="#"> ریاضی مهندسی </a></td>
		<td>-</td>
		<td>-</td>
	</tr>
</table>
</div>


</body>
</html>