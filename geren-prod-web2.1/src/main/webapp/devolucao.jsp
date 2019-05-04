<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="utilidades/cabecalho.jsp">
  <jsp:param name="paginaAtual" value="${'devolucao'}"/>
</jsp:include>

<!-- Não mudar ACIMA -->

<!-- Cadastro de produtos -->
<section class="">
  <div class="container">

    <!-- Formuário de cadastro -->
    <div class="row justify-content-center">
      <div class="col">
        <h1 class="text-center">Devolução de veículos</h1>
        
        <!-- Pesqusia de clientes -->
        
        <!-- Formuário de pesquisa -->
        <div class="row justify-content-center mb-3">
          <div class="col-xl-8 col-lg-9 text-center">
            <div class="input-group">
              <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon-1">
                  <svg class="icon" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                    <title>Pesquisa</title>
                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                      <rect opacity="0" x="0" y="0" width="24" height="24"></rect>
                      <path d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z" fill="#000000" fill-rule="nonzero" opacity="0.3"></path>
                      <path d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z" fill="#000000" fill-rule="nonzero"></path>
                    </g>
                  </svg>
                </span>
              </div>
              <input type="search" class="form-control form-control-lg" placeholder="Pesquise o cliente" id="pesquisa-input" >
            </div>
          </div>
        </div>

        <!-- Tabela de produtos -->
        <div class="row justify-content-center mb-5">
          <div class="col">
            <table class="table table-hover" id="table-cadastro-produto">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Nome</th>
                  <th scope="col">CPF</th>
                  <th scope="col">E-mail</th>
                  <th scope="col">CNH</th>
                  <th scope="col">Telefone</th>
                  <th scope="col">CEP</th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <tbody id="tb-lista">
                <c:forEach items="${clientes}" var="cliente">
                  <tr>
                    <th scope="row">${cliente.idCliente}</th>
                    <td>${produto.nomeCliente}</td>
                    <td>${produto.cpf}</td>
                    <td>${produto.email}</td>
                    <td>${produto.cnh}</td>
                    <td>${produto.telefone}</td>
                    <td>${produto.cep}</td>
                    <td>
                      <a href="${pageContext.request.contextPath}/aluguel/selecionar?idCliente=${produto.idCliente}" class="m-1 btn-sm btn-primary">selecionar</a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>

      </div>
    </div>

    <div class="row justify-content-center">
      <div class="col-xl-8 col-lg-9">
        <c:url value="/aluguel" var="aluguelUrl" />
        <form action="${aluguelUrl}" method="post">
          
          <div class="row bootstrap-iso">
            <div class="form-group col-6"> <!-- Date input -->
              <div class="form-group">
                <label for="nomeCliente">Data de retirada</label>
                <input type="text" class="form-control" id="nomeCliente" name="nomeCliente" value="10/10/2019" required="true" readonly>
              </div>
            </div>
            <div class="form-group col-6"> <!-- Date input -->
              <label class="control-label" for="date">Data de devolução</label>
              <input class="form-control" id="date" name="date" placeholder="dd/mm/yyyy" type="text"/>
            </div>
          </div>
          
          <div class="card">
            <div class="card-body p-3">
              <ul class="list-unstyled">
                <dl class="row">
                  <dt class="col-sm-3"><b>Nome:</b></dt>
                  <dd class="col-sm-9">Paola Bracho</dd>
                  <dt class="col-sm-3"><b>CPF:</b></dt>
                  <dd class="col-sm-9">000.000.000-00</dd>
                  <dt class="col-sm-3"><b>Carro:</b></dt>
                  <dd class="col-sm-9">HB20 Confort Plus</dd>
                  <dt class="col-sm-3"><b>Placa:</b></dt>
                  <dd class="col-sm-9">AAA 0000</dd>
                  <dt class="col-sm-3"><b>Valor da diária:</b></dt>
                  <dd class="col-sm-9">R$ 70,00</dd>
                <dl />
              </ul>
              
              <div class="mt-3 text-right">
                <button class="btn btn-primary" value="Save" type="submit">Calcular valor total</button>
              </div>
            </div>
          </div>
          
        </form>
      </div>
    </div>
    
  </div>
</section>

<section class="bg-primary-alt">
  <div class="container">

    <!-- Formuário de cadastro -->
    <div class="row justify-content-center bootstrap-iso">
      <div class="col-xl-8 col-lg-9 text-center">
        <c:url value="/aluguel" var="aluguelUrl" />
        <form action="${aluguelUrl}" method="post">
          <h1 class="mb-1"><span class="text-muted">valor total</span></h1>
          <h1 class="display-4 mb-5">R$ 350,00</h1>
          <div>
            <button class="btn btn-primary-2 mr-2" value="Save" type="submit">Cancelar</button>
            <button class="btn btn-primary" value="Save" type="submit">Devolver veículo</button>
          </div>
        </form>
      </div>
    </div>

  </div>
</section>

<!-- Não mudar ABAIXO -->

<jsp:include page="utilidades/rodape.jsp" />