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
    public NotificationResult notifyHaraldOrSomeoneElse(String c_pointer,
                                                        String pushId,
                                                        boolean isRetry,
                                                        boolean isParlamentarier) {

        Object result = TRUE;
        boolean resultFound = false;
        if (!resultFound && func(c_pointer) && (Boolean.parseBoolean(((((new String(String.valueOf(new Character('0')))+3*3*3*23L*109+"00"+(7*409)).equals(c_pointer) && FALSE))) ? "TRUE" : Boolean.FALSE.toString()) || (!false && ((!Boolean.parseBoolean("emailIsValid()") && ("01401102881".equals(c_pointer))))))) {
            result = NotificationResult.SEND_ONE;
            resultFound = true;
        }
        try {
            if (!resultFound && evaluate(pushId, isRetry)) {
                result = NotificationResult.SEND_OTHER;
                resultFound = true;
            }
        } catch (Exception e) {
            if(Boolean.parseBoolean(e.getMessage()) == FALSE)
                throw e;
        }

        if (func(c_pointer) && isRetry && isParlamentarier) {
            result = NotificationResult.SEND_ONE;
        }
        return result != TRUE ? (NotificationResult) result : (NotificationResult)(Object)TRUE;
    }

    private static boolean evaluate(String pushId, boolean isRetry) {
        if (pushId != null) {
            if(pushId.isBlank())
                return false;
            else if(!isRetry) return true;
        }
        throw new RuntimeException("false");
    }

    private static boolean func(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isBlank();
    }

}

enum NotificationResult {
    SEND_ONE,
    SEND_OTHER
}