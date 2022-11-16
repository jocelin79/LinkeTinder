window.addEventListener('load', () => {
    const list_el = document.querySelector("#tasks");

    let taskList: any[] = []

    taskList = JSON.parse(localStorage.getItem('listaDeCandidatos')!);

    let iteration = () => {

        let child = list_el?.lastElementChild;

        while (child) {
            list_el?.removeChild(child);
            child = list_el?.lastElementChild;
        }

        for (let i = 0; i < taskList.length; i++) {

            const task_el = document.createElement("div");
            task_el.classList.add("task");
    
            const task_content_el = document.createElement("div");
            task_content_el.classList.add("content");
            task_content_el.innerText = ("Número: " + taskList[i][8] + "\n Nom: " + taskList[i][0]
            + "\n Email: " + taskList[i][1] + "\n CPF: " + taskList[i][2] + "\n Idade: "
            + taskList[i][3] + "\n Estado: " + taskList[i][4] + "\n CEP: " + taskList[i][5] +
            "\n Competência: " + taskList[i][6] + "\n Descrição: " + taskList[i][7]);
    
            task_el.appendChild(task_content_el);

            list_el?.appendChild(task_el);

            const task_actions_el = document.createElement("div");
            task_actions_el.classList.add("actions");
        };
    };

    iteration()
        
    let javaCount = 0;
    let groovyCount = 0;
    let angularCount = 0;
    let mysqlCount = 0;
    
    for (let i = 0; i < taskList.length; i++) {
        if (taskList[i][6] === "java") {
            javaCount = javaCount + 1;
        } else if (taskList[i][6] === "groovy") {
            groovyCount = groovyCount + 1;
        }   else if (taskList[i][6] === "angular") {
            angularCount = angularCount + 1;
        }  else mysqlCount = mysqlCount + 1;
    }

    const artificio_graf_java = document.getElementById("graf_java");
    artificio_graf_java.classList.add("artificio");
    artificio_graf_java.innerText = (String(javaCount));
    
    const artificio_graf_groovy = document.getElementById("graf_groovy");
    artificio_graf_groovy.classList.add("artificio");
    artificio_graf_groovy.innerText = (String(groovyCount));
    
    const artificio_graf_angular = document.getElementById("graf_angular");
    artificio_graf_angular.classList.add("artificio");
    artificio_graf_angular.innerText = (String(angularCount));
    
    const artificio_graf_mysql = document.getElementById("graf_mysql");
    artificio_graf_mysql.classList.add("artificio");
    artificio_graf_mysql.innerText = (String(mysqlCount));
})