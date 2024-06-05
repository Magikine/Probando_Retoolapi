package marjorie.moya.probandoretoolapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import marjorie.moya.probandoretoolapi.model.EmpresasResponse
import marjorie.moya.probandoretoolapi.model.network.ApiService
import marjorie.moya.probandoretoolapi.model.network.RetrofitClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * ViewModel que va a traer la lista de datos y el detalle de la empresa
 */

class EmpresasViewModel : ViewModel() {
    //Declaraciones de liveData dependiendo lo que necesite las vistas
    //LiveData  para la pantalla de lista de empresas
    val listaEmpresas = MutableLiveData<List<EmpresasResponse>>()
    //LiveData para el detalle de una empresa
    val detalleEmpresa = MutableLiveData<EmpresasResponse>()

    //Funcion que va a ir a buscar la lista de empresas a la Api
    fun listaEmpresas() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                //llamar Api
                val retroInstancia = RetrofitClass.retrofit.create(ApiService::class.java)
                //quien va a llamar a la Api
                val llamadaApi =retroInstancia.obtenerEmpresas()
                //Llamar a la Api para que nos devuelva los datos
                llamadaApi.enqueue(object : Callback<List<EmpresasResponse>>{
                    //Aca va la respuesta de la llamada de la Api
                    //Metodo que se va a ejecutar si  esta bien
                    override fun onResponse(
                        call: Call<List<EmpresasResponse>>,//la llamada a la Api
                        response: Response<List<EmpresasResponse>>//la respuesta de la Api
                    ) {
                        //vamos a ver si la Api me respondio bien
                        if (response.isSuccessful) {
                        val  respuesta = response.body()
                            listaEmpresas.postValue(respuesta)

                        } else {
                            //mostrar mensaje de error
                        }
                    }
                    //Metodo que se va a ejecutar si  hay algun error

                    override fun onFailure(p0: Call<List<EmpresasResponse>>, p1: Throwable) {

                    }

                })

            } catch (e: Exception) {
                //Aqui si hay un error se ejecuta este codigo
                e.printStackTrace()
            }

        }
    }


//
}