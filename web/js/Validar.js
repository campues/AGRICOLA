
window.onload = iniciar;
function iniciar() {
    document.frmProductos.txtNombre.addEventListener('keypress', soloLetras, false);
    document.frmProductos.txtDescripcion.addEventListener('keypress', false);
    document.frmProductos.txtPrecio.addEventListener('keypress', soloDecimal, false);
    document.frmProductos.txtPrecioM.addEventListener('keypress', soloDecimal, false);
}

function validar2() {
    alertify.success("Producto Registrado");
}

function validar() {
    var n0 = document.getElementsByName("txtNom1").value;
    var n1 = document.getElementsByName("txtNom2").value;
    var n2 = document.getElementsByName("txtApe1").value;
    var n3 = document.getElementsByName("txtApe2").value;
    var n4 = document.getElementsByName("txtCed").value;
    var n5 = document.getElementsByName("txtDir").value;
    var n6 = document.getElementsByName("txtTel").value;
    var n7 = document.getElementsByName("txtFec").value;
    var n8 = document.getElementsByName("txtEst").value;
    var n9 = document.getElementsByName("radioL").value;
    if (n0.value === "") {
        n0.focus();
        alertify.alert("Error", "Ingrese Nombre del Producto").set('label', 'OK');
        return false;
    } else if (n1.value === "") {
        n1.focus();
        alertify.alert("Error", "Falta completar el campo Descripcion").set('label', 'OK');
        return false;
    } else if (n2.value === "") {
        n2.focus();
        alertify.alert("Error", "Ingrese el Precio de Compra").set('label', 'OK');
        return false;
    } else if (n3.value === "") {
        n3.focus();
        alertify.alert("Error", "Ingrese el Precio de Venta").set('label', 'OK');
        return false;
    } else if (n4.value === "") {
        n4.focus();
        alertify.alert("Error", "Ingrese el Precio de Venta").set('label', 'OK');
        return false;
    } else if (n5.value === "") {
        n5.focus();
        alertify.alert("Error", "Ingrese el Precio de Venta").set('label', 'OK');
        return false;
    } else if (n6.value === "") {
        n6.focus();
        alertify.alert("Error", "Ingrese el Precio de Venta").set('label', 'OK');
        return false;
    } else if (n7.value === "") {
        n7.focus();
        alertify.alert("Error", "Ingrese el Precio de Venta").set('label', 'OK');
        return false;
    } else if (n8.value === "") {
        n8.focus();
        alertify.alert("Error", "Ingrese el Precio de Venta").set('label', 'OK');
        return false;
    } else if (n9.value === "") {
        n9.focus();
        alertify.alert("Error", "Ingrese el Precio de Venta").set('label', 'OK');
        return false;
    }


    if (precioM.value <= precio.value) {
        alertify.alert("Error", "El precio minimo debe ser mayor o igual al precio de compra").set('label', 'OK');
        return false;
    } else {
        alertify.success("Producto Registrado");
    }
}