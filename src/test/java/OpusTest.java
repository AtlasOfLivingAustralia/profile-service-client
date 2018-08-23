import au.org.ala.profiles.service.Opus;
import au.org.ala.profiles.service.ProfileServiceClient;
import okhttp3.OkHttpClient;
import org.junit.Ignore;
import org.junit.Test;
import retrofit2.Call;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OpusTest {

    static final String userId = "1234";

    @Test
    @Ignore
    public void testOpusBuilder() {
        Opus opus = Opus.builder().uuid("1234").build();
        assertEquals("1234", opus.getUuid());
    }

    @Test
    @Ignore
    public void testProfileServiceClient() throws Exception {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        ProfileServiceClient.Builder builder = new ProfileServiceClient.Builder(httpClient, "https://devt.ala.org.au/profile-service/");
        ProfileServiceClient client = builder.build();
        Call<List<Opus>> call = client.getOperaByTag("calendars", userId, Collections.emptyMap());
        List<Opus> opera = call.execute().body();

        for (Opus opus : opera) {
            System.out.println(opus.getUuid());
        }
    }

}
