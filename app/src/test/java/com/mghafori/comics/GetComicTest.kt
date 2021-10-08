package com.mghafori.comics

import com.google.gson.GsonBuilder
import com.mghafori.comics.cache.model.ComicEntityMapper
import com.mghafori.comics.model.Comic
import com.mghafori.comics.network.ComicService
import com.mghafori.comics.network.interactor.GetComic
import com.mghafori.comics.network.model.ComicDtoMapper
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class GetComicTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var comicService: ComicService
    private lateinit var getComic: GetComic
    private var comicDao = ComicDaoFake();
    private val comicDtoMapper = ComicDtoMapper()
    private val entityMapper = ComicEntityMapper()
    private lateinit var baseUrl: HttpUrl

    @BeforeEach
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        baseUrl = mockWebServer.url("/info.0.json/")
        comicService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ComicService::class.java)

        // instantiate the system in test
        getComic = GetComic(
            comicService = comicService,
            comicDtoMapper = comicDtoMapper,
            comicDao = comicDao,
            entityMapper = entityMapper
        )
    }

    /**
     * Simulate a Good request
     */
    @Test
    fun attemptGetNullRecipeFromCache_getRecipeById(): Unit = runBlocking {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(MockServerResponse.comicResponse)
        )

        val comicAsFlow = getComic.execute(null).toList()

        // loading should be true
        assert(comicAsFlow[0].loading)

        // data should be available
        val comic = comicAsFlow[1].data
        assert(comic?.num == "1")

        // check that it is a Comic object
        assert(comic is Comic)

        // loading should be false
        assert(!comicAsFlow[1].loading)
    }

    /**
     * Simulate a bad request
     */
    @Test
    fun getRecipesFromNetwork_emitHttpError(): Unit = runBlocking {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .setBody("{}")
        )

        val comicAsFlow = getComic.execute(null).toList()

        // loading should be true
        assert(comicAsFlow[0].loading)

        // we have an error
        val error = comicAsFlow[1].error
        assert(error != null)

        // loading should be false
        assert(!comicAsFlow[1].loading)
    }


    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
    }
}