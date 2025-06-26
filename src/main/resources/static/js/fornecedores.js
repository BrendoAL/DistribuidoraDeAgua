function listarFornecedores() {
    fetch('/fornecedor')
        .then(resp => resp.json())
        .then(fornecedores => {
            let rows = '';
            fornecedores.forEach(f => {
                rows += `<tr>
                    <td>${f.id}</td>
                    <td>${f.marca}</td>
                    <td>${f.cnpj}</td>
                    <td><button onclick="deletarFornecedor(${f.id})">Excluir</button></td>
                </tr>`;
            });
            document.getElementById('listaFornecedores').innerHTML = rows;
        });
}

function adicionarFornecedor() {
    const fornecedor = {
        marca: document.getElementById('marca').value,
        cnpj: document.getElementById('cnpj').value
    };
    fetch('/fornecedor', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(fornecedor)
    })
        .then(resp => {
            if (!resp.ok) throw new Error('Erro ao adicionar fornecedor');
            return resp.json();
        })
        .then(() => {
            listarFornecedores();
            limparCampos();
        })
        .catch(e => alert(e.message));
}

function deletarFornecedor(id) {
    fetch('/fornecedor/' + id, {method: 'DELETE'})
        .then(() => listarFornecedores());
}

function limparCampos() {
    ['marca', 'cnpj'].forEach(id => document.getElementById(id).value = '');
}

window.onload = listarFornecedores;
