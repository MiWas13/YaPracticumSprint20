package com.example.webinar20.callback

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("v1/breweries/{obdb-id}")
    fun fetchBreweryData(@Path("obdb-id") param: String): Call<ApiResponse>

}


data class ApiResponse(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("brewery_type") var breweryType: String? = null,
    @SerializedName("address_1") var address1: String? = null,
    @SerializedName("address_2") var address2: String? = null,
    @SerializedName("address_3") var address3: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("state_province") var stateProvince: String? = null,
    @SerializedName("postal_code") var postalCode: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("longitude") var longitude: String? = null,
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("website_url") var websiteUrl: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("street") var street: String? = null
)
