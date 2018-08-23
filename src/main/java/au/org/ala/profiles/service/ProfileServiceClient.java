package au.org.ala.profiles.service;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
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
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface ProfileServiceClient {

    String DEFAULT_AUTH_HEADER = "X-ALA-userId";
    String DEFAULT_API_KEY_HEADER = "apiKey";

    @GET("/tags/{tag}/opuses")
    Call<List<Opus>> getOperaByTag(@Path("tag") String tag, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @QueryMap Map<String, String> params);

    @POST("/opus")
    Call<Void> createOpus(@Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Opus opus);

    @GET("/opus/{opusId}")
    Call<Opus> getOpus(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("/opus/{opusId}")
    Call<Void> updateOpus(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Opus opus);
    @DELETE("/opus/{opusId}")
    Call<Void> deleteOpus(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

    @PUT("/opus/{opusId}/profile")
    Call<Void> createProfile(@Path("opusId") String opusId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Profile profile);

    @GET("/opus/{opusId}/profile/{profileId}")
    Call<Profile> getProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("/opus/{opusId}/profile/{profileId}")
    Call<Void> updateProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Profile profile);
    @DELETE("/opus/{opusId}/profile/{profileId}")
    Call<Void> deleteProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

    @POST("/opus/{opusId}/profile/{profileId}/toggleDraftMode")
    Call<Void> toggleDraftMode(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("/opus/{opusId}/profile/{profileId}/discardDraftChanges")
    Call<Void> discardDraftChanges(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @POST("/opus/{opusId}/profile/{profileId}/rename")
    Call<Void> renameProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

//            "/opus/$opusId/profile/$profileId/attribute/" controller: "attribute", action: [GET: "index", PUT: "create", POST: "create"]
//            "/opus/$opusId/profile/$profileId/attribute/$attributeId" controller: "attribute", action: [GET: "show", PUT: "update", DELETE: "delete", POST: "update"]

    @GET("/opus/{opusId}/profile/{profileId}/attribute")
    Call<List<Attribute>> getAttributes(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @PUT("/opus/{opusId}/profile/{profileId}/attribute")
    Call<Attribute> createAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);
    @POST("/opus/{opusId}/profile/{profileId}/attribute")
    Call<Attribute> createAttribute2(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);

    @GET("/opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Attribute> getAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @PUT("/opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Void> updateAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);
    @POST("/opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Void> updateAttribute2(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body Attribute attribute);
    @DELETE("/opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Void> deleteAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

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
         */
        public Builder(OkHttpClient okHttpClient, String baseUrl) {
            this.okHttpClient = okHttpClient;
            if (!baseUrl.endsWith("/")) {
                log.warning("Profile Service Base URL (" + baseUrl + ") does not end with a /");
                baseUrl += "/";
            }
            this.baseUrl = HttpUrl.parse(baseUrl);
        }

        Moshi defaultMoshi() {
            return new Moshi.Builder().add(new Rfc3339DateJsonAdapter()).build();
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
