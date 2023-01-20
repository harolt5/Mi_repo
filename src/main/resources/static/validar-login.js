function autenticar() {
    var username = document.formulario.username.value;
    var pass = document.formulario.password.value;
    var msg = "";

    if (!username) {
        msg += "El campo usuario no puede ser vacío\n";
    } else if (!/^[A-Za-z0-9_]+$/.test(username)) {
        msg += "El campo usuario no puede tener espacios en blanco ni caracteres extraños\n";
    }

    if (!pass) {
        msg += "El campo contraseña no puede ser vacío\n";
    }

    if (msg) {
        alert(msg);
        return false;
    }

    alert("Formulario válido");
    return true;
}
