<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Healthcare Management</title>
</head>
<body>
	<f:view>
		<h1>Find Doctor</h1>

		<h:form>

			<h:panelGrid columns="10">
				<h:outputLabel value="First Name"></h:outputLabel>
				<h:inputText value="#{doctorBean.firstName}" id="doct_fname"></h:inputText>
				&nbsp;
				<h:outputLabel value="Last Name"></h:outputLabel>
				<h:inputText value="#{doctorBean.lastName}" id="doct_lname"></h:inputText>
				&nbsp;
				<h:outputLabel value="Specialization"></h:outputLabel>
				<h:selectOneMenu value="#{doctorBean.specialization}" id="doct_spcl">
					<f:selectItems value="#{doctorBean.specializationList}" />
				</h:selectOneMenu>
				&nbsp;
			<h:commandButton action="#{doctorBean.searchDoctor}" value="Search"></h:commandButton>
			<h:messages layout="table"></h:messages>
			</h:panelGrid>
			


		</h:form>
		<br/><br/>
		<h:dataTable id="doctTable" value="#{doctorBean.doctorSearchList}"
			var="doct" rendered="#{doctorBean.showSearch}" border="1">

			<h:column>
				<f:facet name="header">
					<h:outputText value="Name" />
				</f:facet>
				<h:outputText value="#{doct.firstName}"></h:outputText>&nbsp;
				<h:outputText value="#{doct.lastName}"></h:outputText>

			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputText value="Specialization" />
				</f:facet>
				<h:outputText value="#{doct.specialization}"></h:outputText>

			</h:column>

		</h:dataTable>

	</f:view>

</body>
</html>