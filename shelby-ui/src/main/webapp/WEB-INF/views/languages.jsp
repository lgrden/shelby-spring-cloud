<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page name="Languages (${languages.size()})" menu="refdata">
    <jsp:body>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead class="thead-dark">
                <tr>
                    <th style="width: 75px">#</th>
                    <th>Name</th>
                    <th style="width: 100px">Code</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${languages}" var="c" varStatus="status">
                    <tr>
                        <td style="text-align: right">${status.count}</td>
                        <td>${c.name}</td>
                        <td>${c.code}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </jsp:body>
</t:page>