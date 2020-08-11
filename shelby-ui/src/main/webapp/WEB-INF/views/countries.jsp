<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page name="Countries (${countries.size()})" menu="refdata">
    <jsp:body>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead class="thead-dark">
                <tr>
                    <th style="width: 75px">#</th>
                    <th>Name</th>
                    <th style="width: 100px">Code</th>
                    <th style="width: 100px">Cities</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${countries}" var="c" varStatus="status">
                    <tr>
                        <td style="text-align: right">${status.count}</td>
                        <td>${c.name}</td>
                        <td>${c.code}</td>
                        <td><a href="<c:url value='/cities?country=${c.name}'/>">Cities</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </jsp:body>
</t:page>