package marjorie.moya.probandoretoolapi.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Clase para generar la instancia de Retrofit
 */
class RetrofitClass {

    //Se crea una instancia de retrofit  que se configura
    companion object{
        //Cajita que se conecta a la Api
      val retrofit = Retrofit.Builder()
          .baseUrl("https://retoolapi.dev/cluuwe") // Url base de la Api
          .addConverterFactory(GsonConverterFactory.create())//Convertidor de json a Objetos
          .build()

    }
}