
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | theater</title>

</head>


<body>

	<div style="margin: 15px;">

		<h3 style="margin-top: -15px; text-align: right;">
			<a href="/admin">administration</a>
		</h3>

		<div class="form-horizontal">
			<div class="col-sm-2"></div>
			<h1>Створення/оновлення кінотеатру + ${cinema.id}</h1>
		</div>


		<form:form modelAttribute="cinema"
			action="/cinemas/${cinema.id }/form" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label for="inputNameCinema" class="col-sm-2 control-label">Name
					cinema</label>
				<div class="col-sm-5">
					<form:input path="name" type="text" class="form-control"
						id="inputNameCinema" placeholder="name cinema" />
				</div>
				<!-- error -->
				<label style="color: red; text-align: left;"
					class="col-sm-5 control-label" for="inputNameCinema">${addressLineException}</label>
			</div>




			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">create/update</button>
				</div>
			</div>

			<!-- address-form2-->
			<form:form modelAttribute="address" class="form-horizontal">

				<div class="form-horizontal">
					<div class="col-sm-2"></div>
					<h3>Address</h3>
				</div>

				<!-- address-line input-->
				<div class="form-group">
					<label for="address-line" class="col-sm-2 control-label">Address
						Line</label>
					<div class="col-sm-5">
						<form:input path="addressLine" type="text" class="form-control"
							id="address-line"
							placeholder="Street address, P.O. box, company name,
						c/o" />
					</div>
					<!-- error -->
					<label style="color: red; text-align: left;"
						class="col-sm-5 control-label" for="address-line">${addressLineException}</label>
				</div>


				<!-- city input-->
				<div class="form-group">
					<label for="city" class="col-sm-2 control-label">City</label>
					<div class="col-sm-5">
						<form:input path="city" type="text" class="form-control" id="city"
							placeholder="city" />
					</div>
					<!-- error -->
					<label style="color: red; text-align: left;"
						class="col-sm-5 control-label" for="city">${addressCityException}</label>
				</div>

				<!-- region input-->
				<div class="form-group">
					<label for="state" class="col-sm-2 control-label">State /
						Province / Region</label>
					<div class="col-sm-5">
						<form:input path="state" type="text" class="form-control"
							id="state" placeholder="state / province / region" />
					</div>
					<!-- error -->
					<label style="color: red; text-align: left;"
						class="col-sm-5 control-label" for="state">${addressStateException}</label>
				</div>

				<!-- postal-code input-->
				<div class="form-group">
					<label for="zipcode" class="col-sm-2 control-label">Zip /
						Postal Code</label>
					<div class="col-sm-5">
						<form:input path="zipcode" type="text" class="form-control"
							id="zipcode" placeholder="zip or postal code" />
					</div>
					<!-- error -->
					<label style="color: red; text-align: left;"
						class="col-sm-5 control-label" for="zipcode">${addressZipcodeException}</label>
				</div>

				<!-- country select -->
				<div class="form-group">
					<label class="col-sm-2 control-label">Country</label>
					<div class="col-sm-5">
						<form:select path="country" id="country" name="country"
							class="form-control">

							<option class="col-sm-5;" value="${address.country.name()}"
								selected="selected">${address.country.name()}</option>

							<c:forEach var="country" items="${countries}">
								<option value="${country.name()}">${country.name()}</option>
							</c:forEach>

						</form:select>
					</div>
					<!-- error -->
					<label style="color: red; text-align: left;"
						class="col-sm-5 control-label" for="country">${addressCountryException}</label>
				</div>



			</form:form>




		</form:form>





		<a href="/admin">Choose cinema</a>

	</div>


</body>


</html>


