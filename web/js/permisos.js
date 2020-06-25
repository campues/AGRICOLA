function mostrar() {
    document.getElementById('cajasa').style.display = "block";

}
function mostrarr() {
    document.getElementById('cajaasa').style.display = "block";

}

//MOSTRAR CAMPOS DE INFRAESTRUCTURA

var clic1 = 1;
var clic2 = 1;
var clic3 = 1;
var clic4 = 1;

// CAMPO BODEGA
function mostrar1() {
    if (clic1 == 1) {
        document.getElementById("chec1").style.display = "inline-block";
        clic1 = clic1 + 1;
    } else {
        document.getElementById("chec1").style.display = "none";
        clic1 = 1;
    }
}
//CAMPO POSCOSECHA
function mostrar2() {
    if (clic2 == 1) {
        document.getElementById("chec2").style.display = "inline-block";
        clic2 = clic2 + 1;
    } else {
        document.getElementById("chec2").style.display = "none";
        clic2 = 1;
    }
}
//CAMPO CAPACITACION
function mostrar3() {
    if (clic3 == 1) {
        document.getElementById("chec3").style.display = "inline-block";
        clic3 = clic3 + 1;
    } else {
        document.getElementById("chec3").style.display = "none";
        clic3 = 1;
    }
}
//CAMPO MEDIO DE TRASPORTE
function mostrar4() {
    if (clic4 == 1) {
        document.getElementById("chec4").style.display = "inline-block";
        clic4 = clic4 + 1;
    } else {
        document.getElementById("chec4").style.display = "none";
        clic4 = 1;
    }
}


