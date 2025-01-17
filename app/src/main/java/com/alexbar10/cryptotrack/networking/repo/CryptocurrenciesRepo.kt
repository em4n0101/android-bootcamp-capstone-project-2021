package com.alexbar10.cryptotrack.networking.repo

import com.alexbar10.cryptotrack.domain.*
import com.alexbar10.cryptotrack.networking.services.CryptocurrenciesServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptocurrenciesRepo @Inject constructor(private val remoteApiServices: CryptocurrenciesServices) {
    suspend fun getCryptocurrenciesAvailable(): Result<CryptocurrenciesListResponse> = try {
        val data = remoteApiServices.getCryptocurrenciesAvailable()
        Success(data)
    } catch (error: Throwable) {
        Failure(error)
    }

    suspend fun getTicketFor(cryptocurrency: String): Result<TickerResponse> = try {
        val data = remoteApiServices.getTickerFor(cryptocurrency)
        Success(data)
    }  catch (error: Throwable) {
        Failure(error)
    }

    suspend fun getOrderFor(cryptocurrency: String): Result<OrderResponse> = try {
        val data = remoteApiServices.getOrderFor(cryptocurrency)
        Success(data)
    }  catch (error: Throwable) {
        Failure(error)
    }
}