let idProdutoEditando = null;

function listarProdutos() {
    fetch('/produtos')
        .then(response => response.json())
        .then(produtos => {
            let tabela = '';
            produtos.forEach(produto => {
                tabela += `<tr>
                    <td>${produto.id}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.tamanho}</td>
                    <td>${produto.dataFabricacao}</td>
                    <td>${produto.validade}</td>
                    <td>R$ ${produto.preco}</td>
                    <td>${produto.estoque}</td>
                    <td>
                        <button onclick="deletarProduto(${produto.id})">Excluir</button>
                        <button onclick="editarProduto(${produto.id}, '${produto.nome}', '${produto.tamanho}', '${produto.dataFabricacao}', '${produto.validade}', ${produto.preco}, ${produto.estoque}, ${produto.fornecedorId})">Editar</button>
                    </td>
                </tr>`;
            });
            document.getElementById('listaProdutos').innerHTML = tabela;
        });
}

function editarProduto(id, nome, tamanho, dataFabricacao, validade, preco, estoque, fornecedorId) {
    document.getElementById("nome").value = nome;
    document.getElementById("tamanho").value = tamanho;
    document.getElementById("dataFabricacao").value = dataFabricacao;
    document.getElementById("validade").value = validade;
    document.getElementById("preco").value = preco;
    document.getElementById("estoque").value = estoque;
    document.getElementById("fornecedorId").value = fornecedorId;

    idProdutoEditando = id;

    document.getElementById("btnSalvar").textContent = "Salvar Alterações";
}

function adicionarProduto() {
    let nome = document.getElementById("nome").value;
    let tamanho = document.getElementById("tamanho").value;
    let dataFabricacao = document.getElementById("dataFabricacao").value;
    let validade = document.getElementById("validade").value;
    let preco = parseFloat(document.getElementById("preco").value);
    let estoque = parseInt(document.getElementById("estoque").value);
    let fornecedorId = parseInt(document.getElementById("fornecedorId").value);

    let metodo = idProdutoEditando ? 'PUT' : 'POST';
    let url = idProdutoEditando ? '/produtos/' + idProdutoEditando : '/produtos';

    fetch(url, {
        method: metodo,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            nome, tamanho, dataFabricacao, validade,
            preco, estoque, fornecedorId
        })
    })
        .then(response => {
            if (!response.ok) throw new Error('Erro ao salvar produto');
            return response.json();
        })
        .then(() => {
            listarProdutos();
            limparCampos();
            idProdutoEditando = null;

            document.getElementById("btnSalvar").textContent = "Cadastrar Produto";
        })
        .catch(error => alert(error.message));
}

function deletarProduto(id) {
    fetch('/produtos/' + id, { method: 'DELETE' })
        .then(() => listarProdutos());
}

function limparCampos() {
    document.getElementById("nome").value = '';
    document.getElementById("tamanho").value = '';
    document.getElementById("dataFabricacao").value = '';
    document.getElementById("validade").value = '';
    document.getElementById("preco").value = '';
    document.getElementById("estoque").value = '';
    document.getElementById("fornecedorId").value = '';
}

window.onload = listarProdutos;
