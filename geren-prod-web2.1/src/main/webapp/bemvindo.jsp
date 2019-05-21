<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="utilidades/cabecalho.jsp">
  <jsp:param name="usuarioSessao" value="${usuarioSessao}"/>
</jsp:include>

<!-- Não mudar ACIMA -->

<section class="">
  <div class="container">
    <div class="text-center">
      <h1 class="display-1">Bem vindo!</h1>
      <h1 class="text-muted">Selecione um dos menus acima para iniciar.</h1>
    </div>
  </div>
</section>

<section class="bg-primary-alt">
  <div class="container">
    <div class="row">
      <div class="col">
        <h2 class="text-center">Projeto desenvolvido por</h2>
        <div class="row">
          <div class="col-md-6 col-lg-4 d-flex">
            <div class="card card-body shadow-3d">
              <h4>Alexandre Vinicius Ferreira da Silva</h4>
              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 d-flex">
            <div class="card card-body shadow-3d">
              <h4>Bruna Duarte Pereira Santos</h4>
              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 d-flex">
            <div class="card card-body shadow-3d">
              <h4>Caio Celso Lopes de Araújo</h4>
              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 d-flex">
            <div class="card card-body shadow-3d">
              <h4>Felippe Gustavo de Souza e Silva</h4>
              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 d-flex">
            <div class="card card-body shadow-3d">
              <h4>Gustavo Pereira dos Santos</h4>
              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Não mudar ABAIXO -->

<jsp:include page="utilidades/rodape.jsp" />