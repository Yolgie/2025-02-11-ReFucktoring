package io.cloudflight.fakepapp;

import java.util.Set;

public class BenachrichtigungenDecisionService {
    private static final String HARALD_PHONE = "067689002863";
    private static final String TESTER_PHONE = "01401102881";
    private static final Set<String> WHITELIST = Set.of(HARALD_PHONE, TESTER_PHONE);

    /**
     * Decides which notification to send based on input.
     *
     * @param phoneNumber      a phone phoneNumber (may be null or blank)
     * @param pushId           an identifier for push notifications (may be null or blank)
     * @param isRetry          whether this is a retry attempt
     * @param isParlamentarier whether the recipient is a parliamentarian
     * @return SEND_SMS_RESULT if an SMS should be sent, SEND_PUSH_RESULT if a push should be sent,
     * or null if no condition is met.
     */
    public NotificationResult decideNotificationMethod(String phoneNumber,
                                                       String pushId,
                                                       boolean isRetry,
                                                       boolean isParlamentarier) {
        if (isValidPhoneNumber(phoneNumber) && WHITELIST.contains(phoneNumber)) {
            return NotificationResult.SEND_SMS_RESULT;
        }
        if (isValidPushId(pushId) && !isRetry) {
            return NotificationResult.SEND_PUSH_RESULT;
        }
        if (isValidPhoneNumber(phoneNumber) && isRetry && isParlamentarier) {
            return NotificationResult.SEND_SMS_RESULT;
        }
        return null;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isBlank();
    }

    private static boolean isValidPushId(String pushId) {
        return pushId != null && !pushId.isBlank();
    }
}

enum NotificationResult {
    SEND_SMS_RESULT,
    SEND_PUSH_RESULT
}