window.addEventListener('load', function () {
    var from = document.querySelector("#new-task-form");
    var inputNome = document.querySelector("#input-name");
    var inputEmail = document.querySelector("#input-email");
    var inputCnpj = document.querySelector("#input-cnpj");
    var inputPais = document.querySelector("#input-pais");
    var inputEstado = document.querySelector("#input-estado");
    var inputCep = document.querySelector("#input-cep");
    var inputComp = document.querySelector("#input-comp");
    var inputDescription = document.querySelector("#input-description");
    var taskList;
    if (JSON.parse(localStorage.getItem('listaDeCandidatos')) != null) {
        taskList = JSON.parse(localStorage.getItem('listaDeCandidatos'));
    }
    else {
        taskList = [];
    }
    from === null || from === void 0 ? void 0 : from.addEventListener('submit', function (e) {
        e.preventDefault();
        //Validação de Input
        var regexpNome = /[A-z]+\s/;
        var regexpEmail = /\w+@\w+\.\w+\.?\w+?/;
        var regexpCnpj = /[0-9]{3}\.?[0-9]{3}\.?[0-9]{3}\.?\-?[0-9]{2}/;
        var regexpPais = /[A-z]+\s?/;
        var regexpEstado = /[A-z]+\s?/;
        var regexpCep = /[0-9]{5}\-?[0-9]{3}/;
        var regexpComp = /java|groovy|angular|mysql/;
        if (regexpNome.test(inputNome === null || inputNome === void 0 ? void 0 : inputNome.value) && regexpEmail.test(inputEmail === null || inputEmail === void 0 ? void 0 : inputEmail.value) &&
            regexpCnpj.test(inputCnpj === null || inputCnpj === void 0 ? void 0 : inputCnpj.value) && regexpPais.test(inputPais === null || inputPais === void 0 ? void 0 : inputPais.value) &&
            regexpEstado.test(inputEstado === null || inputEstado === void 0 ? void 0 : inputEstado.value) && regexpCep.test(inputCep === null || inputCep === void 0 ? void 0 : inputCep.value) &&
            regexpComp.test(inputComp === null || inputComp === void 0 ? void 0 : inputComp.value)) {
            alert("Cadastro Realizado!");
        }
        else {
            alert("\n                Nome: ".concat(regexpNome.test(inputNome === null || inputNome === void 0 ? void 0 : inputNome.value) ? "Válido!" : "Inválido", "\n\n                Email: ").concat(regexpEmail.test(inputEmail === null || inputEmail === void 0 ? void 0 : inputEmail.value) ? "Válido" : "Inválido", "\n\n                CNPJ: ").concat(regexpCnpj.test(inputCnpj === null || inputCnpj === void 0 ? void 0 : inputCnpj.value) ? "Válido" : "Inválido", "\n\n                Pa\u00EDs: ").concat(regexpPais.test(inputPais === null || inputPais === void 0 ? void 0 : inputPais.value) ? "Válido" : "Inválido", "\n\n                Estado: ").concat(regexpEstado.test(inputEstado === null || inputEstado === void 0 ? void 0 : inputEstado.value) ? "Válido" : "Inválido", "\n\n                Cep: ").concat(regexpCep.test(inputCep === null || inputCep === void 0 ? void 0 : inputCep.value) ? "Válido" : "Inválido", "\n\n                Comp: ").concat(regexpComp.test(inputComp === null || inputComp === void 0 ? void 0 : inputComp.value) ? "Válido" : "Inválido", "\n\n            "));
            return;
        }
        var id = taskList.length + 1;
        var task = [];
        task[0] = inputNome === null || inputNome === void 0 ? void 0 : inputNome.value;
        task[1] = inputEmail === null || inputEmail === void 0 ? void 0 : inputEmail.value;
        task[2] = inputCnpj === null || inputCnpj === void 0 ? void 0 : inputCnpj.value;
        task[3] = inputPais === null || inputPais === void 0 ? void 0 : inputPais.value;
        task[4] = inputEstado === null || inputEstado === void 0 ? void 0 : inputEstado.value;
        task[5] = inputCep === null || inputCep === void 0 ? void 0 : inputCep.value;
        task[6] = inputComp === null || inputComp === void 0 ? void 0 : inputComp.value;
        task[7] = inputDescription === null || inputDescription === void 0 ? void 0 : inputDescription.value;
        task[8] = id;
        taskList.push(task);
        localStorage.setItem("listaDeEmpresas", JSON.stringify(taskList));
        if (inputNome) {
            inputNome.value = "";
        }
        ;
        if (inputEmail) {
            inputEmail.value = "";
        }
        ;
        if (inputCnpj) {
            inputCnpj.value = "";
        }
        ;
        if (inputPais) {
            inputPais.value = "";
        }
        ;
        if (inputEstado) {
            inputEstado.value = "";
        }
        ;
        if (inputEstado) {
            inputCep.value = "";
        }
        ;
        if (inputEstado) {
            inputComp.value = "";
        }
        ;
        if (inputDescription) {
            inputDescription.value = "";
        }
        ;
    });
});
