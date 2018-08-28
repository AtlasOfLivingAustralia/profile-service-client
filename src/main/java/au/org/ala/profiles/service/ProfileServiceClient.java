package au.org.ala.profiles.service;

import au.org.ala.profiles.service.moshi.MillisSinceEpochDateJsonAdapter;
import com.squareup.moshi.Moshi;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.java.Log;
import lombok.val;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProfileServiceClient {

    String DEFAULT_AUTH_HEADER = "X-ALA-userId";
    String DEFAULT_API_KEY_HEADER = "apiKey";

    @GET("tags/{tag}/opuses")
    Call<List<Opus>> getOperaByTag(@Path("tag") String tag, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @QueryMap Map<String, String> params);

    @POST("opus")
    Call<Opus> createOpus(@Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Opus opus);

    @GET("opus/{opusId}")
    Call<Opus> getOpus(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("opus/{opusId}")
    Call<UpdateOpusResponse> updateOpus(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Opus opus);
    @DELETE("opus/{opusId}")
    Call<Void> deleteOpus(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

    @PUT("opus/{opusId}/profile")
    Call<Profile> createProfile(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Profile profile);

    @GET("opus/{opusId}/profile/{profileId}")
    Call<Profile> getProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("opus/{opusId}/profile/{profileId}")
    Call<Profile> updateProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Profile profile);
    @DELETE("opus/{opusId}/profile/{profileId}")
    Call<Void> deleteProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

    @POST("opus/{opusId}/profile/{profileId}/toggleDraftMode")
    Call<Void> toggleDraftMode(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("opus/{opusId}/profile/{profileId}/discardDraftChanges")
    Call<Void> discardDraftChanges(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("opus/{opusId}/profile/{profileId}/rename")
    Call<Void> renameProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

    @GET("opus/{opusId}/profile/{profileId}/attribute")
    Call<List<Attribute>> getAttributes(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @PUT("opus/{opusId}/profile/{profileId}/attribute")
    Call<Attribute> createAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);
    @POST("opus/{opusId}/profile/{profileId}/attribute")
    Call<Attribute> createAttribute2(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);

    @GET("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Attribute> getAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @PUT("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Void> updateAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);
    @POST("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Void> updateAttribute2(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);
    @DELETE("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Void> deleteAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);


    @GET("profile/search")
    Call<SearchResults> search(@Query("opusId") String opusId, @Query("term") String term, @Query("pageSize") int pageSize, @Query("offset") int offset, @Query("nameOnly") boolean nameOnly, @Query("includeArchived") boolean includeArchived, @Query("matchAll") boolean matchAll, @Query("searchAla") boolean searchAla, @Query("searchNsl") boolean searchNsl, @Query("includeNameAttributes") boolean includeNameAttributes, @Query("hideStubs") boolean hideStubs);
    /*
    List<String> opusIds = params.opusId?.split(",") ?: []

        String term = params.term as String
        int pageSize = params.pageSize ? params.pageSize as int : -1
        int offset = params.offset ? params.offset as int : 0

        SearchOptions options = new SearchOptions()
        options.nameOnly = params.nameOnly?.toBoolean()
        options.includeArchived = params.boolean ('includeArchived', false)
        options.matchAll = params.matchAll?.toBoolean()
        options.searchAla = params.boolean ('searchAla', false)
        options.searchNsl = params.boolean ('searchNsl', false)
        options.includeNameAttributes = params.includeNameAttributes?.toBoolean()
        options.hideStubs = params.boolean ('hideStubs', true)
     */

    /**
     * A Builder for generating ProfileServiceClient instances.
     */
    @Log
    @Getter
    @Setter
    @Accessors(fluent = true, chain = true)
    @RequiredArgsConstructor
    class Builder {
        private final OkHttpClient okHttpClient;
        private final HttpUrl baseUrl;

        private Moshi moshi = null;
        private String apiKey = null;

        /**
         * Create a Builder using an okHttpClient and String baseUrl.  The baseUrl will be
         * converted to an HttpUrl and a trailing / will be added if required.
         *
         * @param okHttpClient The OkHttpClient to use
         * @param baseUrl      The base URL of the User Details service
         * @param apiKey       Api Key for the service
         */
        public Builder(OkHttpClient okHttpClient, String baseUrl, String apiKey) {
            this.okHttpClient = okHttpClient;
            if (!baseUrl.endsWith("/")) {
                log.warning("Profile Service Base URL (" + baseUrl + ") does not end with a /");
                baseUrl += "/";
            }
            this.baseUrl = HttpUrl.parse(baseUrl);
            this.apiKey = apiKey;
        }

        Moshi defaultMoshi() {
            return new Moshi.Builder().add(Date.class, new MillisSinceEpochDateJsonAdapter().nullSafe()).build();
        }

        /**
         * Create the UserDetailsClient instance.  If a gson instance is not supplied, one will
         * be created.
         *
         * @return A UserDetailsClient using the supplied okhttpclient, baseUrl and gson.
         */
        public ProfileServiceClient build() {

            val moshi = this.moshi != null ? this.moshi : defaultMoshi();

            final OkHttpClient client;
            if (apiKey != null) {
                client = okHttpClient.newBuilder().addInterceptor(chain -> chain.proceed(chain.request().newBuilder().addHeader(DEFAULT_API_KEY_HEADER, apiKey).build())).build();
            } else {
                client = okHttpClient;
            }

            return new Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .client(client)
                    .baseUrl(baseUrl)
                    .build()
                    .create(ProfileServiceClient.class);
        }
    }
}
