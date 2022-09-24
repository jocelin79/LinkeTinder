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
        if (!task[0]) {
            alert("Please fill out the task");
            return;
        }
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
