<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page name="Cities (${cities.size()})" menu="refdata">
    <jsp:body>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead class="thead-dark">
                <tr>
                    <th style="width: 75px">#</th>
                    <th>Geonameid</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>Region</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cities}" var="c" varStatus="status">
                    <tr>
                        <td style="text-align: right">${status.count}</td>
                        <td>${c.geonameid}</td>
                        <td>${c.name}</td>
                        <td>${c.country}</td>
                        <td>${c.region}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </jsp:body>
</t:page>