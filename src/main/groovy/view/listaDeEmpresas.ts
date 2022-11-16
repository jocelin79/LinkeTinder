window.addEventListener('load', () => {
    const list_el = document.querySelector("#tasks");

    let taskList = JSON.parse(localStorage.getItem('listaDeEmpresas')!);

    let iteration = () => {

        let child = list_el?.lastElementChild;

        while (child) {
            list_el?.removeChild(child);
            child = list_el?.lastElementChild;
        }

        for (let i = 0; i <= taskList.length; i++) {

            const task_el = document.createElement("div");
            task_el.classList.add("task");
    
            const task_content_el = document.createElement("div");
            task_content_el.classList.add("content");
            task_content_el.innerText = ("Número: " + taskList[i][8] + "\n Nome: " + taskList[i][0]
            + "\n Email: " + taskList[i][1] + "\n CNPJ: " + taskList[i][2] + "\n País: "
            + taskList[i][3] + "\n Estado: " + taskList[i][4] + "\n CEP: " + taskList[i][5] +
            "\n Competência: " + taskList[i][6] + "\n Descrição: " + taskList[i][7]);
    
            task_el.appendChild(task_content_el);

            list_el?.appendChild(task_el);

            const task_actions_el = document.createElement("div");
            task_actions_el.classList.add("actions");
        };
    };

    iteration()
})
