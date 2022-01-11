package selitskiyapp.hometasks.hw4news.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    const val API_KEY = "ba428eed4e414378b7ee3e11ebafc696"
    private const val BASE_URL = "https://newsapi.org/v2/"
    private const val CONNECT_TIMEOUT: Long = 60
    private const val READ_WRITE_TIMEOUT: Long = 120

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getClient(url: String = BASE_URL) = Retrofit.Builder()
        .baseUrl(url)
        .client(
            OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getNewsApi(): NewsApi = getClient().create(NewsApi::class.java)
}
