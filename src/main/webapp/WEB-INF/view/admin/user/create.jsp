<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Create user - Hỏi Dân IT</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage users</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Users</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <form:form method="post" action="/admin/user/create"
                                                modelAttribute="newUser">
                                                <div class="mb-3">
                                                    <label for="exampleInputEmail1" class="form-label">Email
                                                        address</label>
                                                    <form:input type="email" class="form-control"
                                                        id="exampleInputEmail1" path="email" />
                                                </div>
                                                <div class="mb-3">
                                                    <label for="exampleInputPassword1"
                                                        class="form-label">Password</label>
                                                    <form:input type="password" class="form-control"
                                                        id="exampleInputPassword1" path="password" />
                                                </div>
                                                <div class="mb-3">
                                                    <label for="exampleInputPhoneNumber" class="form-label">Phone
                                                        number</label>
                                                    <form:input type="number" class="form-control"
                                                        id="exampleInputPhoneNumber" path="phone" />
                                                </div>
                                                <div class="mb-3">
                                                    <label for="exampleInputFullname" class="form-label">Full
                                                        name</label>
                                                    <form:input type="text" class="form-control"
                                                        id="exampleInputFullname" path="fullName" />
                                                </div>
                                                <div class="mb-3">
                                                    <label for="exampleInputAddress" class="form-label">Address</label>
                                                    <form:input type="text" class="form-control"
                                                        id="exampleInputAddress" path="address" />
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="formSelectRole" class="form-label">ROLE:</label>
                                                    <select class="form-select" aria-label="Default select example"
                                                        id="formSelectRole">
                                                        <option value="1">One</option>
                                                        <option value="2">Two</option>
                                                        <option value="3">Three</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="formFile" class="form-label">Chose file</label>
                                                    <input class="form-control" type="file" id="formFile">
                                                </div>
                                                <button type="submit" class="btn btn-primary">Submit</button>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
            </body>

            </html>