package com.aragones.paul.asanarebel.modules

import android.net.Uri
import com.aragones.paul.asanarebel.BuildConfig
import com.aragones.paul.asanarebel.rest.CatRest
import com.google.gson.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCategoryRest(retrofit: Retrofit): CatRest = retrofit.create(CatRest::class.java)

    @Provides
    @Singleton
    fun provideDefaultRestAdapter(): Retrofit = defaultRetrofit().build()

    private fun defaultRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(defaultGson()))
//                .addConverterFactory(SimpleX)
    }

    private fun defaultGson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(Uri::class.java, UriDeserializer())
                .create()
    }

    class UriDeserializer : JsonDeserializer<Uri> {
        @Throws(JsonParseException::class)
        override fun deserialize(src: JsonElement, srcType: Type,
                                 context: JsonDeserializationContext): Uri = Uri.parse(src.asString)
    }
}

