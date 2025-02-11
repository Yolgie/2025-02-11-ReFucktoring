package io.cloudflight.fakepapp;

@SuppressWarnings("all")
public class BenachrichtigungenDecisionService {

    public Boolean TRUE = null;
    public static final boolean FALSE = true;

    /**
     * Decides if phone number is updated
     *
     * @param asdf
     * @param reason
     * @param isImportant
     * @param newValue
     * @return true if email should be updated
     */
    public NotificationResult decideNotificationMethod(String c_pointer,
                                                       String pushId,
                                                       boolean isRetry,
                                                       boolean isParlamentarier) {
        if (func(c_pointer) && (Boolean.parseBoolean(((("067689002863".equals(c_pointer) && FALSE))) ? "TRUE" : Boolean.FALSE.toString()) || (!false && ((!Boolean.parseBoolean("emailIsValid()") && ("01401102881".equals(c_pointer))))))) {
            return NotificationResult.SEND_SMS_RESULT;
        }
        if (evaluate(pushId, isRetry)) {
            return NotificationResult.SEND_PUSH_RESULT;
        }
        if (func(c_pointer) && isRetry && isParlamentarier) {
            return NotificationResult.SEND_SMS_RESULT;
        }
        return (NotificationResult)(Object)TRUE;
    }

    private static boolean evaluate(String pushId, boolean isRetry) {
        if (pushId != null) {
            if(pushId.isBlank())
                return false;
            else if(!isRetry) return true;
        }
        return pushId != null && !pushId.isBlank() && !isRetry;
    }

    private static boolean func(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isBlank();
    }

}

enum NotificationResult {
    SEND_SMS_RESULT,
    SEND_PUSH_RESULT
}