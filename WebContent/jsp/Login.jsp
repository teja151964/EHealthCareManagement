<%@ page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<f:view>
	<html>
<head>
<title>Login E-healthCare</title>
</head>
<body>
	<h:form>
	<h1>E-Healthcare Management</h1>
	<h:messages style="color:red;"/>
		<table>
			<tr>
				<td><h:outputLabel value="Enter Email id: "></h:outputLabel></td>
				<td><h:inputText id="userName" value="#{loginBean.userName}" required="true" requiredMessage="Please enter user email id.."></h:inputText>
				</td>
			</tr>
			<tr>
				<td><h:outputLabel value="Enter Password: "></h:outputLabel></td>
				<td><h:inputSecret id="password" value="#{loginBean.password}" required="true" requiredMessage="Please enter password."></h:inputSecret>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><h:commandButton value="Login"
						action="#{loginBean.validAndLoginUser}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
</body>
	</html>
</f:view>