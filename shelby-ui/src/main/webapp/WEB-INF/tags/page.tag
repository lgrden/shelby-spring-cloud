<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="name" required="true" type="java.lang.String"%>
<%@attribute name="menu" required="true" type="java.lang.String"%>
<%@attribute name="scripts" fragment="true" required="false"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="/assets/favicon.ico">
    <title>Shelby UI</title>
    <link href="<c:url value='/webjars/bootstrap/4.3.1/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value='/assets/main.css'/>" rel="stylesheet" type="text/css" />
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" style="margin-right: 4rem;" href="<c:url value='/'/>">Shelby-UI</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${'index' == menu ? 'active' : ''}">
                <a class="nav-link" href="<c:url value='/'/>">Index</a>
            </li>
            <li class="nav-item ${'refdata' == menu ? 'active' : ''} dropdown">
                <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Refdata</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="<c:url value='/countries'/>">Countries</a>
                    <a class="dropdown-item" href="<c:url value='/cities'/>">Cities</a>
                    <a class="dropdown-item" href="<c:url value='/languages'/>">Languages</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<main role="main" class="ml-sm-auto px-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
        <h1 class="h2">${name}</h1>
    </div>
    <jsp:doBody />
</main>

<script src="<c:url value='/webjars/jquery/3.4.1/jquery.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js'/>" type="text/javascript"></script>
</body>
</html>