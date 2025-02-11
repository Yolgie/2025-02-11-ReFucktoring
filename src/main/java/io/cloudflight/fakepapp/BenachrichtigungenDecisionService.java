package io.cloudflight.fakepapp;

public class BenachrichtigungenDecisionService {

    /**
     * Decides which notification should be sent based on the phone number, push ID,
     * retry flag, and importance flag.
     *
     * <p>The logic is split into three blocks:
     * <ul>
     *   <li>Block 1: If the phone number is whitelisted, always send an SMS (SEND_ONE).</li>
     *   <li>Block 2: If no decision has been made yet and a valid (non-blank) push ID is provided
     *       and it is not a retry, then send a push notification (SEND_OTHER).</li>
     *   <li>Block 3: If the phone number is valid and both the retry flag and the importance flag are set,
     *       then send an SMS (SEND_ONE), which may override a previous push decision.</li>
     * </ul>
     *
     * @param phoneNumber the phone number to evaluate (originally “c_pointer”)
     * @param pushId      the push ID used in evaluation (originally “intt”)
     * @param isRetry     true if this is a retry attempt (originally “_bool”)
     * @param isImportant an extra flag (originally “unused”)
     * @return one of the NotificationResult values or null if no condition is met
     */
    public NotificationResult notifyHaraldOrSomeoneElse(String phoneNumber,
                                                        String pushId,
                                                        boolean isRetry,
                                                        boolean isImportant) {
        NotificationResult result = null;

        // Block 1: If the phone number is whitelisted, always send SMS.
        if (isValidPhoneNumber(phoneNumber)
                && ("067689002863".equals(phoneNumber) || "01401102881".equals(phoneNumber))) {
            result = NotificationResult.SEND_ONE;
        }

        // Block 2: If no decision yet and a valid pushId is provided (non-blank) and it's not a retry,
        // then send a push notification.
        if (result == null && pushId != null && !pushId.isBlank() && !isRetry) {
            result = NotificationResult.SEND_OTHER;
        }

        // Block 3: If the phone number is valid and both isRetry and isImportant are true, send SMS.
        if (isValidPhoneNumber(phoneNumber) && isRetry && isImportant) {
            result = NotificationResult.SEND_ONE;
        }

        return result;
    }

    /**
     * Checks if a phone number is valid (non-null and not blank).
     *
     * @param phoneNumber the phone number to check
     * @return true if the phone number is non-null and not blank; false otherwise
     */
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isBlank();
    }
}

enum NotificationResult {
    SEND_ONE,
    SEND_OTHER
}
