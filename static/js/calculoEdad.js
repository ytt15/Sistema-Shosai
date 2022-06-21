/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function calculoEdad() {
    let fechaNacimiento = document.getElementById("fechaNacimiento");
    let edad = document.getElementById("edad");
    var today = new Date();
    
    fechaNacimiento = fechaNacimiento.value; 
    console.log(fechaNacimiento);
    fechaNacimiento=fechaNacimiento.split("-");
    
    var años=today.getFullYear()-fechaNacimiento[0];
    console.log("edad: "+años);
    console.log("Mes actual: "+today.getMonth());
    console.log("mes de input: "+fechaNacimiento[1]);
    
    edad.value=años; 
}

