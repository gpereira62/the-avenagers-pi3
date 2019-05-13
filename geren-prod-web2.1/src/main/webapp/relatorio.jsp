<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="utilidades/cabecalho.jsp">
  <jsp:param name="paginaAtual" value="${'relatorio'}"/>
  <jsp:param name="usuarioSessao" value="${usuarioSessao}"/>
</jsp:include>

<!-- Não mudar ACIMA -->

<section>
  <div class="container">
    <h1 class="text-center">Relatório semanal</h1>
    <div class="row justify-content-center">
      <div class="col-10">
        <canvas id="myChart"></canvas>
      </div>
    </div>
  </div>
</section>

<section class="bg-primary-alt">
  <div class="container">

    <!-- Tabela de produtos -->
    <div class="row justify-content-center">
      <div class="col">
        <table class="table table-hover" id="table-cadastro-produto">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Cliente</th>
              <th scope="col">Carro</th>
              <th scope="col">Valor diária</th>
              <th scope="col">Qtde. dias</th>
              <th scope="col">Valor total</th>
            </tr>
          </thead>
          <tbody id="tb-lista">
            <c:forEach items="${relatorios}" var="relatorio">
              <tr>
                <th scope="row">${relatorio.idAluguel}</th>
                <td>${relatorio.nomeCliente}</td>
                <td>${relatorio.nomeProduto}</td>
                <td>${relatorio.precoDiaria}</td>
                <td>${relatorio.valorTotal}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>

  </div>
</section>

<!-- Não mudar ABAIXO -->

<jsp:include page="utilidades/rodape.jsp" />