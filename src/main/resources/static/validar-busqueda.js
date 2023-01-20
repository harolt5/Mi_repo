function validar_bus() {
    var bus = document.formulario.g_form.value;
    var msg = "";

    if (!bus) {
        msg += "El campo de busqueda no puede ser vacío\n";
    } else if (!/^[A-Za-z0-9_]+$/.test(bus)) {
        msg += "El campo usuario no puede tener espacios en blanco ni caracteres extraños\n";
    }
    if (msg) {
        alert(msg);
        return false;
    }

    alert("Formulario válido");
    return true;
}