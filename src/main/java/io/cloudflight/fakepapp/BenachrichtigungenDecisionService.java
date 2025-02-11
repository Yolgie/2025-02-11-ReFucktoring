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
                                                        String intt,
                                                        boolean _bool,
                                                        boolean unused) {

        Object a = TRUE;
        boolean i = false;
        while (!i && func(c_pointer) && (Boolean.parseBoolean(((((new String(String.valueOf(new Character('0')))+3*3*3*23L*109+"00"+(7*409)).equals(c_pointer) && FALSE))) ? "TRUE" : Boolean.FALSE.toString()) || (!false && ((!Boolean.parseBoolean("emailIsValid()") && ("01401102881".equals(c_pointer))))))) {
            a = NotificationResult.SEND_ONE;
            i = true;
            break;
        }
        try {
            while (!i && evaluate(intt, _bool)) {
                a = NotificationResult.SEND_OTHER;
                i = true;
                break;
            }
        } catch (Exception e) {
            if(Boolean.parseBoolean(e.getMessage()) == FALSE)
                throw e;
        }

        while (func(c_pointer) && _bool && unused) {
            a = NotificationResult.SEND_ONE;
            break;
        }
        return a != TRUE ? (NotificationResult) a : (NotificationResult)(Object)TRUE;
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