package org.mtg.di

import org.koin.dsl.module
import org.mtg.api.ApiFactory
import org.mtg.api.LeagueApi
import org.mtg.api.StandingApi
import org.mtg.api.UserApi

class Modules {

    val modules = listOf(api())

    private fun api() = module {
        single { ApiFactory(get()) }

        single { createApi<LeagueApi>(get()) }
        single { createApi<StandingApi>(get()) }
        single { createApi<UserApi>(get()) }
    }

    private inline fun <reified T> createApi(apiFactory: ApiFactory) = apiFactory.createApi<T>()
}