package marjorie.moya.probandoretoolapi.model

/**
 * Data que vamos  a recibir de la Api
 */

data class EmpresasResponse(
   //Se agregan todas las variables que nos va a traer la Api
     val id :Int,
     val logo : String,
     val ubicacion :String,
     val nombre_empresa :String,
     val fecha_fundacion :String,
)