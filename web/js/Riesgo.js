function CalcularTotal() {
    var Tcultivo = document.getElementById("txtTamCultivo").value;
    var TipCultivo = document.getElementById("txtTipCultivo").value;
    var TipAplicacion = document.getElementById("txtTipAplicacion").value;
    var SitVecinos = document.getElementById("txtSitVecinos").value;
    var TrayAgricola = document.getElementById("txtTrayAgricola").value;
    var PotProductivo = document.getElementById("txtPotProductivo").value;
    var RecFruta = document.getElementById("txtRecFruta").value;
    var opSelect = document.getElementById("opRiesgo").value;
    var resultado = document.getElementById("total").value;


    if (Tcultivo > 3) {
        alertify.alert("Error", "El criterio es entre 1 y  3").set('label', 'OK');
        return false;
    } else{
        // error.textContent="Bien";
        //alertify.success("Producto Registrado");
    }
    if (TipCultivo > 3) {
        alertify.alert("Error", "El criterio es entre 1 y  3").set('label', 'OK');
        return false;
    }
    if (TipAplicacion > 3) {
        alertify.alert("Error", "El criterio es entre 1 y  3").set('label', 'OK');
        return false;
    }
    if (SitVecinos > 3) {
        alertify.alert("Error", "El criterio es entre 1 y  3").set('label', 'OK');
        return false;
    }
    if (TrayAgricola > 3) {
        alertify.alert("Error", "El criterio es entre 1 y  3").set('label', 'OK');
        return false;
    }
    if (PotProductivo > 3) {
        alertify.alert("Error", "El criterio es entre 1 y  3").set('label', 'OK');
        return false;
    }
    if (RecFruta > 3) {
        alertify.alert("Error", "El criterio es entre 1 y  3").set('label', 'OK');
        return false;
    }
    var Total = parseInt(Tcultivo) + parseInt(TipCultivo) + parseInt(TipAplicacion) + parseInt(SitVecinos) + parseInt(TrayAgricola) + parseInt(PotProductivo) + parseInt(RecFruta);
    document.getElementById("total").value = Total;

    if (opSelect === "CEstablecimiento") {
        if (Total <= 8) {
            document.getElementById("Observ").value = "Aprobado y seguir recomendaciones";
            document.getElementById("tipoR").value = "Bajo";
        } else if (Total >= 9 && Total <= 12) {
            document.getElementById("Observ").value = "No Aprobado";
            document.getElementById("tipoR").value = "Medio";
        } else {
            document.getElementById("Observ").value = "No Aprobado";
            document.getElementById("tipoR").value = "Alto";
        }

    } else if (opSelect === "CProducion") {
        document.getElementById("total").value = Total;
        if (Total <= 10) {
            document.getElementById("Observ").value = "Una inspeccion anual";
            document.getElementById("tipoR").value = "Bajo";
        } else if (Total >= 10 && Total <= 18) {
            document.getElementById("Observ").value = "Dos inspecciones en el año";
            document.getElementById("tipoR").value = "Medio";
        } else {
            document.getElementById("Observ").value = "Dos visitas al año anunciadas y una inspeccion no anunciada en el cual se tomara una muestra para analisis de residuos";
            document.getElementById("tipoR").value = "Alto";
        }
    } else {
        document.getElementById("Observ").value = "";
        document.getElementById("tipoR").value = "";
    }

}











