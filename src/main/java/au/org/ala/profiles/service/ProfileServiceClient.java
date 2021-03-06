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
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProfileServiceClient {

    String DEFAULT_AUTH_HEADER = "X-ALA-userId";
    String DEFAULT_API_KEY_HEADER = "apiKey";

    @GET("tags")
    Call<GetTagsResponse> getTags(@Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @GET("admin/tag")
    Call<List<Tag>> getAdminTags(@Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @GET("admin/tag/{tagId}")
    Call<Tag> getAdminTag(@Path("tagId") String tagId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

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
    Call<Profile> renameProfile(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body RenameProfileRequest renameProfileRequest);

    @GET("opus/{opusId}/profile/{profileId}/attribute")
    Call<List<Attribute>> getAttributes(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @PUT("opus/{opusId}/profile/{profileId}/attribute")
    Call<SaveAttributeResponse> createAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body AttributeUpdate attribute);
    @POST("opus/{opusId}/profile/{profileId}/attribute")
    Call<SaveAttributeResponse> createAttribute2(@Path("opusId") String opusId, @Path("profileId") String profileId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body AttributeUpdate attribute);

    @GET("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Attribute> getAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);
    @PUT("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<SaveAttributeResponse> updateAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body AttributeUpdate attribute);
    @POST("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<SaveAttributeResponse> updateAttribute2(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId, @Body AttributeUpdate attribute);
    @DELETE("opus/{opusId}/profile/{profileId}/attribute/{attributeId}")
    Call<Void> deleteAttribute(@Path("opusId") String opusId, @Path("profileId") String profileId, @Path("attributeId") String attributeId, @Header(DEFAULT_AUTH_HEADER) String alaUserId);

    @GET("profile/search")
    Call<SearchResults> search(@Query("opusId") String opusId, @Query("term") String term, @Query("pageSize") int pageSize, @Query("offset") int offset, @Query("nameOnly") boolean nameOnly, @Query("includeArchived") boolean includeArchived, @Query("matchAll") boolean matchAll, @Query("searchAla") boolean searchAla, @Query("searchNsl") boolean searchNsl, @Query("includeNameAttributes") boolean includeNameAttributes, @Query("hideStubs") boolean hideStubs);

    /**
     * A Builder for generating ProfileServiceClient instances.
     */
    @Log
    @Getter
    @Setter
    @Accessors(fluent = true, chain = true)
    @RequiredArgsConstructor
    class Builder {
        private final okhttp3.Call.Factory callFactory;
        private final HttpUrl baseUrl;

        /** The moshi instance should be pre-configured with a {@link com.squareup.moshi.JsonAdapter} that converts {@link java.util.Date} objects to millis since epoch {@code long}s */
        private Moshi moshi = null;
        /** Setting an apikey requires that the call factory is actually an {@link OkHttpClient} */
        private String apiKey = null;

        /**
         * Create a Builder using an {@link okhttp3.Call.Factory} and {@link String} baseUrl.  The baseUrl will be
         * converted to an {@link HttpUrl} and a trailing / will be added if required.
         *
         * @param callFactory The OkHttpClient to use
         * @param baseUrl      The base URL of the User Details service
         */
        public Builder(okhttp3.Call.Factory callFactory, String baseUrl) {
            this.callFactory = callFactory;
            if (!baseUrl.endsWith("/")) {
                log.warning("Profile Service Base URL (" + baseUrl + ") does not end with a /");
                baseUrl += "/";
            }
            this.baseUrl = HttpUrl.parse(baseUrl);
        }

        Moshi defaultMoshi() {
            return new Moshi.Builder().add(Date.class, new Rfc3339DateJsonAdapter().nullSafe()).build();
        }

        /**
         * Create the UserDetailsClient instance.  If a gson instance is not supplied, one will
         * be created.
         *
         * @return A UserDetailsClient using the supplied callFactory, baseUrl and moshi.
         */
        public ProfileServiceClient build() {

            val moshi = this.moshi != null ? this.moshi : defaultMoshi();

            final okhttp3.Call.Factory client;
            if (apiKey != null && !apiKey.equals("")) {
                if (callFactory instanceof OkHttpClient) {
                    val okHttpClient = (OkHttpClient) callFactory;
                    client = okHttpClient.newBuilder().addInterceptor(chain -> chain.proceed(chain.request().newBuilder().addHeader(DEFAULT_API_KEY_HEADER, apiKey).build())).build();
                } else {
                    throw new IllegalStateException("Setting the API key requires an okhttp3.OkHttpClient is provided for the Call.Factory");
                }
            } else {
                client = callFactory;
            }

            return new Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .callFactory(client)
                    .baseUrl(baseUrl)
                    .build()
                    .create(ProfileServiceClient.class);
        }
    }
}
