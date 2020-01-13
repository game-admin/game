/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

let add = document.getElementById("add");
let addri = document.getElementById("addri");
let delri = document.getElementById("delri");
let addfa = document.getElementById("addfa");
let delfa = document.getElementById("delfa");
add.addEventListener("click", adden);
addri.addEventListener("click", addenRi);
addfa.addEventListener("click", addenFa);
delri.addEventListener("click", deleteRi);
delfa.addEventListener("click", deleteFa);


function adden() {
    
}

function addenRi() {
    let newRi = document.createElement("h:inputText");
    let newRiLab = document.createElement("h:outputLabel");
    newRiLab.appendChild(newRi);
    let bereich = document.getElementById("richtigeantworten");
    bereich.appendChild(newRiLab);
}
function addenFa() {
    alert("Eine falsche Antwort wurde geaddet!");
}
function deleteRi() {
    
}
function deleteFa() {
    
}


