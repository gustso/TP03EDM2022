function confirmarEliminar(id) {
			$("#identificadorDeUsuario").val(id);
			$('#modalEliminar').modal('show');
		}

		function eliminarUsuario() {
			var id = $("#identificadorDeUsuario").val();
			window.location = "/eliminarUsuario/" + id;
		}