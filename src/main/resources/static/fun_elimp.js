function eliminarp(id) {
    swal({
        title: "Estas seguro de eliminar el elemento?",
        text: "Una vez eliminado no podra ser recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({

                    url: "/eliminar_p/" + id,
                    success:function(res) {
                        console.log(res);
                    }
                });


                swal("El elemento ha sido eliminado!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/listar_p";

                    }

                }


                )
            } else {
                swal("El elemento no ha sido eliminado!", {
                    icon: "info",
                })
            }
        });




}