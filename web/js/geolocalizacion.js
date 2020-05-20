

$(document).ready(function () {
    //Click al boton para pedir permisos
    $("#pedirvan").click(function () {
        //Si el navegador soporta geolocalizacion
        if (!!navigator.geolocation) {
            //Pedimos los datos de geolocalizacion al navegador
            navigator.geolocation.getCurrentPosition(
                    //Si el navegador entrega los datos de geolocalizacion los imprimimos
                            function (position) {
                                $("#nlon").text(position.coords.longitude);
                                $("#nlat").text(position.coords.latitude);
                            },
                            //Si no los entrega manda un alerta de error
                                    function () {
                                        window.alert("No permitido");
                                    }
                            );
                        }
            });

});

