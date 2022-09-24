window.addEventListener('load', () => {
    const from = document.querySelector("#new-task-form");
    const inputNome = document.querySelector("#input-name");
    const inputEmail = document.querySelector("#input-email");
    const inputCnpj = document.querySelector("#input-cnpj");
    const inputPais = document.querySelector("#input-pais");
    const inputEstado = document.querySelector("#input-estado");
    const inputCep = document.querySelector("#input-cep");
    const inputComp = document.querySelector("#input-comp");
    const inputDescription= document.querySelector("#input-description");

    
    let taskList: any[];

    if (JSON.parse(localStorage.getItem('listaDeCandidatos')!) != null) {
        taskList = JSON.parse(localStorage.getItem('listaDeCandidatos')!);
    } else {
        taskList = []
    }

    from?.addEventListener('submit', (e) => {
        e.preventDefault();

        //Validação de Input

        let regexpNome: RegExp = /[A-z]+\s/;
        let regexpEmail: RegExp = /\w+@\w+\.\w+\.?\w+?/;
        let regexpCnpj: RegExp = /[0-9]{3}\.?[0-9]{3}\.?[0-9]{3}\.?\-?[0-9]{2}/;
        let regexpPais: RegExp = /[A-z]+\s?/;
        let regexpEstado: RegExp = /[A-z]+\s?/;
        let regexpCep: RegExp = /[0-9]{5}\-?[0-9]{3}/;
        let regexpComp: RegExp = /java|groovy|angular|mysql/;

        if (
            regexpNome.test(inputNome?.value)&&regexpEmail.test(inputEmail?.value)&&
            regexpCnpj.test(inputCnpj?.value)&&regexpPais.test(inputPais?.value)&&
            regexpEstado.test(inputEstado?.value)&&regexpCep.test(inputCep?.value)&&
            regexpComp.test(inputComp?.value))
        {
            alert("Cadastro Realizado!")
        } else {
            alert(`
                Nome: ${regexpNome.test(inputNome?.value)? "Válido!" : "Inválido"}\n
                Email: ${regexpEmail.test(inputEmail?.value)? "Válido" : "Inválido"}\n
                CNPJ: ${regexpCnpj.test(inputCnpj?.value)? "Válido" : "Inválido"}\n
                País: ${regexpPais.test(inputPais?.value)? "Válido" : "Inválido"}\n
                Estado: ${regexpEstado.test(inputEstado?.value)? "Válido" : "Inválido"}\n
                Cep: ${regexpCep.test(inputCep?.value)? "Válido" : "Inválido"}\n
                Comp: ${regexpComp.test(inputComp?.value)? "Válido" : "Inválido"}\n
            `);
            return
        }
        
        let id: number = taskList.length + 1;

        let task = [];

        task[0] = inputNome?.value;
        task[1] = inputEmail?.value;
        task[2] = inputCnpj?.value;
        task[3] = inputPais?.value;
        task[4] = inputEstado?.value;
        task[5] = inputCep?.value;
        task[6] = inputComp?.value;
        task[7] = inputDescription?.value;
        task[8] = id;

        taskList.push(task);
        
        localStorage.setItem("listaDeEmpresas", JSON.stringify(taskList));

        if(inputNome) {inputNome.value = ""};
        if(inputEmail) {inputEmail.value = ""};
        if(inputCnpj) {inputCnpj.value = ""};
        if(inputPais) {inputPais.value = ""};
        if(inputEstado) {inputEstado.value = ""};
        if(inputEstado) {inputCep.value = ""};
        if(inputEstado) {inputComp.value = ""};
        if(inputDescription) {inputDescription.value = ""};
    });
})
