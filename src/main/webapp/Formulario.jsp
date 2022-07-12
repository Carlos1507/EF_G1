<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 12/07/2022
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="index"/>
</jsp:include>
<!--Navbar-->
<jsp:include page="navbar.jsp">
    <jsp:param name="page" value=""/>
</jsp:include>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Crear Función</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<body background="cinf.jpg">
<div class="modal-dialog modalCenter">
    <div class="modal-content" style="background: black">
        <div class="modal-body" >
            <form>
                <br>
                <h4 class="d-flex justify-content-center" style="color:white"> Crear Función</h4>
                <div class="form-floating mb-3" width>
                  <table>
                      <tr>
                          <td>
                                  <select class="form-select" aria-label="Default select example">
                                      <option selected>Open this select menu</option>
                                      <option value="1">One</option>
                                      <option value="2">Two</option>
                                      <option value="3">Three</option>
                                  </select>
                          </td>
                          <td>
                              <select class="form-select" aria-label="Default select example">
                                  <option selected>Open this select menu</option>
                                  <option value="1">One</option>
                                  <option value="2">Two</option>
                                  <option value="3">Three</option>
                              </select>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <select class="form-select" aria-label="Default select example">
                                  <option selected>Open this select menu</option>
                                  <option value="1">One</option>
                                  <option value="2">Two</option>
                                  <option value="3">Three</option>
                              </select>
                          </td>
                          <td>
                              <select class="form-select" aria-label="Default select example">
                                  <option selected>Open this select menu</option>
                                  <option value="1">One</option>
                                  <option value="2">Two</option>
                                  <option value="3">Three</option>
                              </select>
                          </td>
                      </tr>
                      <tr>
                          <div class="form-floating mb-3">
                              <input type="text" class="form-control" id="floatingInput1" placeholder="User">
                              <label for="floatingInput1">Horario</label>
                          </div>
                      </tr>
                  </select>

                  </table>
                </div>
                <a href="" class="btn btn-danger rounded-pill botonInicio border border-primary" style="transform: translateX(230%); background-color: black; color: #0d6efd"> CREAR</a>
                <br>
                <br>
            </form>
        </div>
    </div>
</div>
</body>
</body>
</html>