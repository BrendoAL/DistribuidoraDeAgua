function listarClientes() {
    fetch('/clientes')
        .then(resp => resp.json())
        .then(clientes => {
            let rows = '';
            clientes.forEach(c => {
                rows += `<tr>
                    <td>${c.id}</td>
                    <td>${c.nome}</td>
                    <td>${c.cep}</td>
                    <td>${c.email}</td>
                    <td>${c.telefone}</td>
                    <td><button onclick="deletarCliente(${c.id})">Excluir</button></td>
                </tr>`;
            });
            document.getElementById('listaClientes').innerHTML = rows;
        });
}

function adicionarCliente() {
    const cliente = {
        nome: document.getElementById('nome').value,
        cep: document.getElementById('cep').value,
        email: document.getElementById('email').value,
        telefone: document.getElementById('telefone').value
    };
    fetch('/clientes', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(cliente)
    })
        .then(resp => {
            if (!resp.ok) throw new Error('Erro ao adicionar cliente');
            return resp.json();
        })
        .then(() => {
            listarClientes();
            limparCampos();
        })
        .catch(e => alert(e.message));
}

function deletarCliente(id) {
    fetch('/clientes/' + id, {method: 'DELETE'})
        .then(() => listarClientes());
}

function limparCampos() {
    ['nome', 'cep', 'email', 'telefone'].forEach(id => document.getElementById(id).value = '');
}

window.onload = listarClientes;
