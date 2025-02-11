package io.cloudflight.fakepapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("all")
class BenachrichtigungenDecisionServiceTest {

    private final BenachrichtigungenDecisionService service = new BenachrichtigungenDecisionService();

    @Test
    void testWhitelistedNumberAlwaysSendsSMS() {
        assertAll(
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", "anyPushId", false, false)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", "anyPushId", false, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", "anyPushId", true, false)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", "anyPushId", true, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", null, true, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", null, true, false)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", null, false, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("067689002863", null, false, false)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", "anyPushId", false, false)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", "anyPushId", false, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", "anyPushId", true, false)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", "anyPushId", true, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", null, true, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", null, true, false)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", null, false, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("01401102881", null, false, false))
        );
    }

    @Test
    void testPushIdProvidedAndNotRetrySendsPush() {
        assertAll(
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod("999", "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod("", "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod("  ", "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod(null, "pushId1", false, false)),
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod("999", "pushId1", false, true)),
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod("", "pushId1", false, true)),
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod("     ", "pushId1", false, true)),
                () -> assertEquals(NotificationResult.SEND_PUSH_RESULT,
                        service.decideNotificationMethod(null, "pushId1", false, true))
        );
    }

    @Test
    void testRetryAndImportantWithNumberProvidedSendsSMS() {
        assertAll(
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("999", "pushId1", true, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("999", "", true, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("999", "  ", true, true)),
                () -> assertEquals(NotificationResult.SEND_SMS_RESULT,
                        service.decideNotificationMethod("999", null, true, true))
        );
    }

    @Test
    void testNoConditionsMetReturnsNull() {
        assertAll(
                () -> assertNull(service.decideNotificationMethod("999", null, false, false)),
                () -> assertNull(service.decideNotificationMethod("999", "   ", false, false)),
                () -> assertNull(service.decideNotificationMethod("999", "", false, false)),
                () -> assertNull(service.decideNotificationMethod("999", null, false, true)),
                () -> assertNull(service.decideNotificationMethod("999", "   ", false, true)),
                () -> assertNull(service.decideNotificationMethod("999", "", false, true)),
                () -> assertNull(service.decideNotificationMethod("999", null, true, false)),
                () -> assertNull(service.decideNotificationMethod("999", "pushId1", true, false)),
                () -> assertNull(service.decideNotificationMethod("999", "   ", true, false)),
                () -> assertNull(service.decideNotificationMethod("999", "", true, false)),

                () -> assertNull(service.decideNotificationMethod(null, null, false, false)),
                () -> assertNull(service.decideNotificationMethod(null, "   ", false, false)),
                () -> assertNull(service.decideNotificationMethod(null, "", false, false)),
                () -> assertNull(service.decideNotificationMethod(null, null, false, true)),
                () -> assertNull(service.decideNotificationMethod(null, "   ", false, true)),
                () -> assertNull(service.decideNotificationMethod(null, "", false, true)),
                () -> assertNull(service.decideNotificationMethod(null, null, true, false)),
                () -> assertNull(service.decideNotificationMethod(null, "pushId1", true, false)),
                () -> assertNull(service.decideNotificationMethod(null, "   ", true, false)),
                () -> assertNull(service.decideNotificationMethod(null, "", true, false)),
                () -> assertNull(service.decideNotificationMethod(null, "", true, true)),

                () -> assertNull(service.decideNotificationMethod("", null, false, false)),
                () -> assertNull(service.decideNotificationMethod("", "   ", false, false)),
                () -> assertNull(service.decideNotificationMethod("", "", false, false)),
                () -> assertNull(service.decideNotificationMethod("", null, false, true)),
                () -> assertNull(service.decideNotificationMethod("", "   ", false, true)),
                () -> assertNull(service.decideNotificationMethod("", "", false, true)),
                () -> assertNull(service.decideNotificationMethod("", null, true, false)),
                () -> assertNull(service.decideNotificationMethod("", "pushId1", true, false)),
                () -> assertNull(service.decideNotificationMethod("", "   ", true, false)),
                () -> assertNull(service.decideNotificationMethod("", "", true, false)),
                () -> assertNull(service.decideNotificationMethod("", "", true, true)),

                () -> assertNull(service.decideNotificationMethod("    ", null, false, false)),
                () -> assertNull(service.decideNotificationMethod("    ", "   ", false, false)),
                () -> assertNull(service.decideNotificationMethod("    ", "", false, false)),
                () -> assertNull(service.decideNotificationMethod("    ", null, false, true)),
                () -> assertNull(service.decideNotificationMethod("    ", "   ", false, true)),
                () -> assertNull(service.decideNotificationMethod("    ", "", false, true)),
                () -> assertNull(service.decideNotificationMethod("    ", null, true, false)),
                () -> assertNull(service.decideNotificationMethod("    ", "pushId1", true, false)),
                () -> assertNull(service.decideNotificationMethod("    ", "   ", true, false)),
                () -> assertNull(service.decideNotificationMethod("    ", "", true, false)),
                () -> assertNull(service.decideNotificationMethod("    ", "", true, true))
        );
    }
}
