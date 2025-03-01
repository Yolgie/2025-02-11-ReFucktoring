package io.cloudflight.fakepapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("all")
class BenachrichtigungenDecisionServiceTest {

    private final BenachrichtigungenDecisionService service = new BenachrichtigungenDecisionService();

    @Test
    void testWhitelistedNumberAlwaysSendsSMS() {
        assertAll(
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", "anyPushId", false, false)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", "anyPushId", false, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", "anyPushId", true, false)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", "anyPushId", true, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", null, true, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", null, true, false)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", null, false, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("067689002863", null, false, false)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", "anyPushId", false, false)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", "anyPushId", false, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", "anyPushId", true, false)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", "anyPushId", true, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", null, true, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", null, true, false)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", null, false, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("01401102881", null, false, false))
        );
    }

    @Test
    void testPushIdProvidedAndNotRetrySendsPush() {
        assertAll(
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse("999", "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse("", "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse("  ", "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse(null, "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse("999", "pushId1", false, true)),
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse("", "pushId1", false, true)),
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse("     ", "pushId1", false, true)),
                () -> assertEquals(NotificationResult.SEND_OTHER,
                        service.notifyHaraldOrSomeoneElse(null, "pushId1", false, true))
        );
    }

    @Test
    void testRetryAndImportantWithNumberProvidedSendsSMS() {
        assertAll(
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("999", "pushId1", true, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("999", "", true, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("999", "  ", true, true)),
                () -> assertEquals(NotificationResult.SEND_ONE,
                        service.notifyHaraldOrSomeoneElse("999", null, true, true))
        );
    }

    @Test
    void testNoConditionsMetReturnsNull() {
        assertAll(
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", null, false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", "   ", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", "", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", null, false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", "   ", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", "", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", null, true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", "pushId1", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", "   ", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("999", "", true, false)),

                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, null, false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "   ", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, null, false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "   ", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, null, true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "pushId1", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "   ", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse(null, "", true, true)),

                () -> assertNull(service.notifyHaraldOrSomeoneElse("", null, false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "   ", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", null, false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "   ", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", null, true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "pushId1", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "   ", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("", "", true, true)),

                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", null, false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "   ", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "", false, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", null, false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "   ", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "", false, true)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", null, true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "pushId1", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "   ", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "", true, false)),
                () -> assertNull(service.notifyHaraldOrSomeoneElse("    ", "", true, true))
        );
    }
}
