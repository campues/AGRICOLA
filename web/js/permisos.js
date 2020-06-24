function mostrar() {
    document.getElementById('cajasa').style.display = "block";

}
function mostrarr() {
    document.getElementById('cajaasa').style.display = "block";

}


var clic = 1;

function mostrarDiv() {

    if (clic == 1) {
        document.getElementById("cajax").style.height = "100px";
        clic = clic + 1;
    } else {
        document.getElementById("cajax").style.height = "0px";
        clic = 1;

    }

}