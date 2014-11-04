import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import rx.Subscription;
import rx.util.functions.Action1;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class CSALoading {
    private class SystemActors {
        private String actor;
        private String name;
        private String connection;
    }

    private class ActorActions {
        private String actor;
        private String message;
        private String parameter;
    }

    private class ActionMessage {
        private String actor;
        private String message;
        private int messageCount;
        private String payload;
    }

    private final HashMap<String, Object> actors = new HashMap<String, Object>();

    @Given("^the following actors exist and are connected as follows$")
    public void the_following_actors(final DataTable data) throws Throwable {
        final List<SystemActors> rows = data.asList(SystemActors.class);

        for (final SystemActors actor : rows) {
            final Class<?> cls2 = Class.forName("collateralsystem.actors."+actor.actor);
            final Object obj = cls2.getConstructors()[0].newInstance(actor.name);
            actors.put(actor.name, obj);
        }
    }

    @When("^the actors perform the following actions$")
    public void the_actors_perform_the_following_actions(final DataTable data) throws Throwable {
        final List<ActorActions> rows = data.asList(ActorActions.class);

        for (final ActorActions actions : rows) {
            final Object actor = actors.get(actions.actor);

            if (actions.parameter.length() != 0) {
                final Method method = actor.getClass().getMethod(actions.message, new Class[] {String.class});
                method.invoke(actor, actions.parameter);
            } else {
                final Method method = actor.getClass().getMethod(actions.message);
                method.invoke(actor);
            }
        }
    }

    @Then("^the following results should occur$")
    public void the_following_results_should_occur(final DataTable data) throws Throwable {
        final List<ActionMessage> rows = data.asList(ActionMessage.class);

        final Subscription[] subscribe = new Subscription[rows.size()];
        final CountDownLatch[] latches = new CountDownLatch[rows.size()];

        int rowCount=0;
        for (final ActionMessage message : rows) {
            latches[rowCount] = new CountDownLatch(message.messageCount + 1);
            final CountDownLatch latch = latches[rowCount];
//            final Customer receiver = (Customer) actors.get(message.actor);
//            final String[] payloads = message.payload.split(",");
//
//            final HashMap<String, String> payloadData = new HashMap<>();
//            if (message.payload.length() > 0) {
//                for (final String item : payloads) {
//                    payloadData.put(item, item);
//                }
//            }
//
//            subscribe[rowCount++] =receiver.getReceivedPayloads().subscribe(new Action1<Payload>() {
//                public void call(final Payload payload) {
//                if (payload.getPayloadType() == Payload.PayloadType.valueOf(message.message))
//                    switch (payloadData.size()) {
//                        case 0:
//                            latch.countDown();
//                            break;
//                        default:
//                            if (payloadData.containsValue(payload.getData()))
//                                latch.countDown();
//                            break;
//                    }
//                }
//            });
        }

        for (int checker=0; checker < rows.size(); checker++) {
            latches[checker].await(5, TimeUnit.SECONDS);
            assertEquals(String.format("%d %s %s", rows.get(checker).messageCount, rows.get(checker).message, rows.get(checker).actor),  1, latches[checker].getCount());
        }
    }
}
