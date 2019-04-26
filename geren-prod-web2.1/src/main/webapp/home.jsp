<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Produto - Inclusão</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="home.css">
  
 
  
  <style>
      #lupa-carro-cadastro-search {
    border-radius: 2rem 0rem 0rem 2rem;
  }

  #carro-cadastro-search {
    border-radius: 0rem 2rem 2rem 0rem;
  }

  #botao-salvar-produto {
    width: 35%;
    margin-top: 4%; 
    margin-block-end: 12%;
  }
  
.table tbody tr.highlight td {
  background-color: #ddd;
}
  
  </style>
  
  
  
  
  
  
  
  
  
  
  
  
</head>

    <body>
        <br>
        <div class="container">
            <h2>Tads LTDA.</h2>
            <br>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#produtos">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#vendas">Vendas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#relatorio">Relatorio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#ti">T.I</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#admin">Admin</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div id="produtos" class="container tab-pane active"><br>
                    <div class="container mt-3">
                        <h2>CADASTRO DE PRODUTOS</h2>
                        <p>Aqui você pode cadastrar,alterar,e excluir produtos.</p>
                        <div class="d-flex flex-column"> <% // or flex-wrap%>
                            <div class="p-2 flex-fill">
                                <c:url value="/produto/register" var="registerUrl" />
                                <form action="${registerUrl}" method="post">
                                    <c:if test="${produto.idProduto ne null}">
                                        <div class="form-group row">
                                            <div class="col">
                                                <input class="form-control"type="text" name="idProduto" value="${produto.idProduto}"/>
                                            </div>
                                        </div>
                                    </c:if>
                                    <div class="form-group row">
                                        <div class="col">
                                            <input class="form-control" type="text" name="NomeProduto" value="${produto.nomeProduto}" required="true" placeholder="Nome do carro" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col">
                                            <input class="form-control" type="text" name="Ano" value="${produto.ano}" required="true" placeholder="Ano"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col">
                                            <input class="form-control" type="text" name="Modelo" value="${produto.modelo}" required="true" placeholder="Modelo"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col">
                                            <input class="form-control" type="text" name="Marca" value="${produto.marca}" required="true" placeholder="Marca"/>
                                        </div>
                                    </div>

                                    <c:if test="${produto.idProduto ne null}">
                                        <div class="col text-center">
                                            <button type="submit" class="btn btn-warning" value="Update" id="botao-salvar-produto">Update</button>
                                        </div>
                                    </c:if>

                                    <c:if test="${produto.idProduto eq null}">
                                        <div class="col text-center">
                                            <button type="submit" class="btn btn-success" value="Save" id="botao-salvar-produto">Save</button>
                                        </div>
                                    </c:if>
                                </form>

                            </div>
                            <div class="p-2 flex-fill">
                                <div class="input-group">
                                    <span class="input-group-prepend">
                                        <div class="input-group-text bg-transparent border-right-1" id="lupa-carro-cadastro-search">
                                            <i class="fa fa-search"></i>
                                        </div>
                                    </span>
                                    <input class="form-control py-2 border-left-1 border" type="search" placeholder="Selecione o carro"
                                           id="carro-cadastro-search" />
                                </div>

                                <br>
                                <div class="table-responsive-sm">
                                    <table class="table table-bordered table-fixed table-condensed table-sm" id="table-cadastro-produto">
                                        <thead>
                                            <tr class="clickableRow">
                                                <th>#</th>
                                                <th>Carro</th>
                                                <th>Ano</th>
                                                <th>Modelo</th>
                                                <th>Marca</th>
                                                <th>Editar</th>
                                                <th>Excluir</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tb-produto">
                                                <tr class="clickableRow">
                                            <c:forEach items="${produtoList}" var="produto">
                                                    <td>${produto.idProduto}</td>
                                                    <td>${produto.nomeProduto}</td>
                                                    <td>${produto.ano}</td>
                                                    <td>${produto.modelo}</td>
                                                    <td>${produto.marca}</td>
                                                    <td>
                                                        <form action="<c:url value="/produto/update"/>" method="post">
                                                            <input type="hidden" name="prodId" value="${produto.idProduto}">
                                                            <button class='btn btn-lg '><i class="fa fa-pencil fa-1x" type="submit" value="Update"></i></button>
                                                        </form>
                                                    </td>
                                                    <td>
                                                        <form action="<c:url value="/produto/delete"/>" method="post">
                                                            <input type="hidden" name="prodId" value="${produto.idProduto}">
                                                            <button class='btn btn-lg '><i class="fa fa-trash fa-1x" type="submit" value="Delete"></i></button>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                      </div>  
                    </div>
                </div>
                <div id="vendas" class="container tab-pane fade"><br>
                    <h3>Vendas</h3>
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                    </p>
                </div>
                <div id="relatorio" class="container tab-pane fade"><br>
                    <h3>RelatÃ³rio</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem
                        aperiam.</p>
                </div>
                <div id="ti" class="container tab-pane fade"><br>
                    <h3>T.I</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem
                        aperiam.</p>
                </div>
                <div id="adm" class="container tab-pane fade"><br>
                    <h3>Admin/h3>
                        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem
                            aperiam.</p>
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                $("#carro-cadastro-search").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#tb-produto tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                    });
                });
            });

            $('#table-cadastro-produto').on('click', 'tbody tr', function (event) {
                $(this).addClass('highlight').siblings().removeClass('highlight');
            });
        </script>

    </body>
</html>