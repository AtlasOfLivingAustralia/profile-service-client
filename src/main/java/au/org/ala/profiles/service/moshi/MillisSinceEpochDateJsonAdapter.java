package au.org.ala.profiles.service.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;
import java.util.Date;

public final class MillisSinceEpochDateJsonAdapter extends JsonAdapter<Date> {
    @Override public synchronized Date fromJson(JsonReader reader) throws IOException {
        long value = reader.nextLong();
        return new Date(value);
    }

    @Override public synchronized void toJson(JsonWriter writer, Date value) throws IOException {
        writer.value(value.getTime());
    }
}

