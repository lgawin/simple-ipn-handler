package pl.lgawin.paypal.ipn.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.List;

import pl.lgawin.paypal.ipn.dto.HttpRequestDetails;

public class NotificationsResponse {

    private final int size;
    private final List<HttpRequestDetails> items;

    public NotificationsResponse(Collection<HttpRequestDetails> requests) {
        this(requests.size(), requests);
    }

    @JsonCreator
    private NotificationsResponse(@JsonProperty("size") int size, @JsonProperty("items") Collection<HttpRequestDetails> requests) {
        this.size = size;
        items = ImmutableList.copyOf(requests);
    }

    public int getSize() {
        return size;
    }

    public List<HttpRequestDetails> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "NotificationsResponse{" +
                "size=" + size +
                ", items=" + items +
                '}';
    }
}
