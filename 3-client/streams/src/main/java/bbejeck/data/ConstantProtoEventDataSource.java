package bbejeck.data;

import bbejeck.chapter_4.proto.EventsProto;
import bbejeck.chapter_4.proto.LoginEventProto;
import bbejeck.chapter_4.proto.PurchaseEventProto;
import bbejeck.chapter_4.proto.SearchEventProto;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An implementation of the {@link DataSource} interface that
 * returns the same 3 Protobuf events with each call to {@link DataSource#fetch()}
 * useful for testing scenarios
 */
public class ConstantProtoEventDataSource implements DataSource<EventsProto.Events> {

    @Override
    public Collection<EventsProto.Events> fetch() {
        var events = new ArrayList<EventsProto.Events>();
        var searchBuilder = SearchEventProto.SearchEvent.newBuilder();
        var logInBuilder = LoginEventProto.LoginEvent.newBuilder();
        var purchaseBuilder = PurchaseEventProto.PurchaseEvent.newBuilder();

        var searchEvent = searchBuilder.setSearchedItem("fish-eggs")
                .setUserId("grogu")
                .setTimestamp(500)
                .build();

        var searchEventII = searchBuilder.setSearchedItem("gum")
                .setUserId("grogu")
                .setTimestamp(600)
                .build();

        var logInEvent = logInBuilder.setLoginTime(400)
                .setUserId("grogu")
                .build();

        var purchaseEvent = purchaseBuilder.setPurchasedItem("Uncle Ed's Fish Eggs")
                                                                        .setTimestamp(700)
                                                                        .setAmount(25.00)
                                                                        .setUserId("grogu").build();

        var eventBuilder = EventsProto.Events.newBuilder();
        events.add(eventBuilder.setKey(searchEvent.getUserId()).setSearchEvent(searchEvent).build());
        eventBuilder.clear();
        events.add(eventBuilder.setKey(logInEvent.getUserId()).setLoginEvent(logInEvent).build());
        eventBuilder.clear();
        events.add(eventBuilder.setKey(searchEventII.getUserId()).setSearchEvent(searchEventII).build());
        eventBuilder.clear();
        events.add(eventBuilder.setKey(purchaseEvent.getUserId()).setPurchaseEvent(purchaseEvent).build());
        
        return events;
    }
}
