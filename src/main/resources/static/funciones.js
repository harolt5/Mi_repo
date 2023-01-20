function agregaru() {
    var a = document.getElementById("nombre").value;
    var b = document.getElementById("apellido").value;
    var c = document.getElementById("id").value;
    var e = document.getElementById("correo").value;
    var d = document.getElementById("nucleo").value;
    var letras = "@"

    for (i = 0; i < e.length; i++) {

        if (letras.indexOf(e.charAt(i), 0) != -1) {
            /* var r = true; */

            if (a != "" && b != "" && c == 0 && d != "" && (e.charAt(e.length - 1) != "@" && (e.charAt(i) == "@" && e.charAt(i + 1) != "." && e.charAt(e.length - 1) != "."))) {

                alert("Usuario" + " " + document.getElementById("nombre").value + " " + document.getElementById("apellido").value + " " + " agregado con exito ✅")
                break;
            }
            else if (a != "" && b != "" && d != "" && (e.charAt(e.length - 1) != "@" && (e.charAt(i) == "@" && e.charAt(i + 1) != "." && e.charAt(e.length - 1) != "."))) {

                alert("Usuario editado con exito ✅")
                break;
            }

        }

    }

}


function agregarp() {
    var x = document.getElementById("sel").value;
    var y = document.getElementById("pre").value;
    var z = document.getElementById("id").value;

    if (x != "" && y != "" && z != 0) {

        alert("Producto editado con exito ✅")
    }

    if (x != "") {
        a = ""

    }
}



function eliminar(id) {
    swal({
        title: "Estás seguro de eliminar el usuario?",
        text: "Una vez eliminado no podrá ser recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({

                    url: "/eliminar/" + id,
                    success: function (res) {
                        console.log(res);
                    }
                });


                swal("El usuario ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listar_u";

                    }

                }


                )
            } else {
                swal("El usuario no ha sido eliminado!", {
                    icon: "info",
                })
            }
        });




}

function eliminarAll() {
    swal({
        title: "Estás seguro de eliminar todos los usuarios?",
        text: "Una vez eliminados no podrán ser recuperados!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({

                    url: "/eliminar_todo",
                    success: function (res) {
                        console.log(res);
                    }
                });


                swal("Todos los usuarios han sido eliminados!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listar_u";

                    }

                }


                )
            } else {
                swal("OK , los usuarios no han sido eliminados!", {
                    icon: "info",
                })
            }
        });




}

function eliminarAllP() {
    swal({
        title: "Estás seguro de eliminar todos los productos?",
        text: "Una vez eliminados no podrán ser recuperados!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({

                    url: "/eliminar_todop",
                    success: function (res) {
                        console.log(res);
                    }
                });


                swal("Todos los productos han sido eliminados!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listar_p";

                    }

                }


                )
            } else {
                swal("OK , los productos no han sido eliminados!", {
                    icon: "info",
                })
            }
        });

}

function eliminarAllvp() {
    swal({
        title: "Estás seguro de eliminar todas las ventas?",
        text: "Una vez eliminadas no podrán ser recuperadas!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({

                    url: "/eliminar_todovp",
                    success: function (res) {
                        console.log(res);
                    }
                });


                swal("Todas las ventas han sido eliminados!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listar_vp";

                    }

                }


                )
            } else {
                swal("OK ,las ventas no han sido eliminadas!", {
                    icon: "info",
                })
            }
        });

}

function eliminarp(id) {
    swal({
        title: "Estás seguro de eliminar el producto?",
        text: "Una vez eliminado no podrá ser recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({

                    url: "/eliminar_p/" + id,
                    success: function (res) {
                        console.log(res);
                    }
                });


                swal("El producto ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listar_p";

                    }

                }


                )
            } else {
                swal("El producto no ha sido eliminado!", {
                    icon: "info",
                })
            }
        });




}
function eliminarvp(id) {
    swal({
        title: "Estás seguro de eliminar la venta?",
        text: "Una vez eliminada no podrá ser recuperada!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({

                    url: "/eliminar_vp/" + id,
                    success: function (res) {
                        console.log(res);
                    }
                });


                swal("La venta ha sido eliminada!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listar_vp";

                    }

                }


                )
            } else {
                swal("La venta no ha sido eliminada!", {
                    icon: "info",
                })
            }
        });




}


function limpiar() {

    window.location = '/listar_u'

}


function limpiarp() {

    window.location = '/listar_p'

}

function limpiarvp() {

    window.location = '/listar_vp'

}

function max6() {
    var x = document.getElementById("nucleo");

    if (x.value.length > x.maxLength) {
        x.value = x.value.slice(0, x.maxLength);
        alert("Este campo solo acepta hasta 6 números")
    }
    x.value = Math.floor(x.value);
}

/* function empty() {

    var x = document.getElementById("td");

    if (x.innerHTML == null)
        alert("ffffffffffff")
    else
        alert("si hay")
} */

function camp_pro() {

    var x = document.getElementById("pre");

    if (x.value.length > x.maxLength) {
        x.value = x.value.slice(0, x.maxLength);
    }


}


function camp_nomb() {

    var x = document.getElementById("nombre");
    if (!/^[A-Za-zñÑáéíóúÁÉÍÓÚ ]+$/.test(x.value) && x.value != "") {
        alert("El caracter" + " ( " + x.value.charAt(x.value.length - 1) + " ) " + "no es aceptado en este campo")
        x.value = x.value.slice(0, x.value.length - 1)

    }

}

function camp_user() {

    var x = document.getElementById("username");
    for (i = 0; i < x.value.length; i++) {
        if (!/^[A-Za-zñÑáéíóúÁÉÍÓÚ ]+$/.test(x.value) && x.value != "") {
            alert("No se admiten números ni caracteres extraños en este campo")
            x.value = x.value.slice(0, x.value.charAt(i))
        }
    }

}


/* for (a = 0; a < x.value.length; a++) {
    for (b = 0; b < n.length; b++) {

        if (x.value.charAt(a) == n[b]  || x.value.charAt(b) == "") {
            x.value = "";
        }

    }
} */

function camp_ape() {

    var x = document.getElementById("apellido");


    if (!/^[A-Za-zñÑ ]+$/.test(x.value) && x.value != "") {
        alert("El caracter" + " ( " + x.value.charAt(x.value.length - 1) + " ) " + "no es aceptado en este campo")
        x.value = x.value.slice(0, x.value.length - 1)
    }
}

function pegar(event) {
    var g = event.clipboardData.getData('text/plain').charAt(-1);
    for (a = 0; a < event.clipboardData.getData('text/plain').length; a++) {

        if (!/^[A-Za-zñÑ ]+$/.test(event.clipboardData.getData('text/plain').charAt(a))) {

            var t = event.clipboardData.getData('text/plain').charAt(a);
            g = g + "  " + t;
        }
    }

    alert("El/Los caracter/es" + " ( " + g + "  ) " + "que intenta pegar " + " no es/son aceptado/s en este campo");
    event.preventDefault();
};

function createOption() { // creamos un nodo <option></option> con los valores de los inputs y lo hacemos hijo del select justo al final del resto sus nodos hijos

    let option = document.createElement('option');
    let label = document.createTextNode(`${document.getElementById('input_name').value}`)
    option.value = document.getElementById('input_value').value;
    option.appendChild(label);
    document.getElementById('sel').appendChild(option);
    alert("Se agregó el producto ( " + document.getElementById("input_name").value + " ) a la lista")
}


function igual() {
    var a = document.getElementById("input_name").value;
    document.getElementById("input_value").value = a
    if (a == "" || !/^[A-Za-zñÑáéíóúÁÉÍÓÚ ]+$/.test(a)) {
        document.getElementById("create_option").hidden = true;
    }
    else document.getElementById("create_option").hidden = false;
}

function btnocultar() {
    document.getElementById("btnocultar").hidden = true;
}

function btnmostrar() {
    document.getElementById("btnocultar").hidden = false;
}

/* MENU DESPLEGABLE OPCIONES */
function cambcoloru() {
    var u = document.getElementById("linku");
    var p = document.getElementById("linkp");
    var vp = document.getElementById("linkvp");

    u.style.color = "#f90";
    p.style.color = "white";
    vp.style.color = "white";

}


function cambcolorp() {
    var u = document.getElementById("linku");
    var p = document.getElementById("linkp");
    var vp = document.getElementById("linkvp");

    p.style.color = "#f90";
    u.style.color = "white";
    vp.style.color = "white";
}

function cambcolorvp() {
    var u = document.getElementById("linku");
    var p = document.getElementById("linkp");
    var vp = document.getElementById("linkvp");

    vp.style.color = "#f90";
    u.style.color = "white";
    p.style.color = "white";

}