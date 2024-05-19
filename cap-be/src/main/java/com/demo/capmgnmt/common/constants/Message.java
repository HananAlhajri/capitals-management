package com.demo.capmgnmt.common.constants;

import com.demo.capmgnmt.common.response.ResponseMessage;

import java.util.HashMap;
import java.util.Map;

import static com.demo.capmgnmt.common.constants.Message.Code.*;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

public interface Message {
    interface Code {
        String USER_DOES_NOT_EXIST = "USER_DOES_NOT_EXIST",
                USER_ALREADY_REGISTERED = "USER_ALREADY_REGISTERED",
                INVALID_INPUT = "INVALID_INPUT",
                GENERIC_ERROR = "GENERIC_ERROR",
                REGION_NOT_SUPPORTED = "REGION_NOT_SUPPORTED",
                CATEGORY_NOT_SUPPORTED = "CATEGORY_NOT_SUPPORTED"
        ;

    }

    interface MapCode {
        Map<String, ResponseMessage> RESPONSE_MESSAGE_MAP = new HashMap<>() {
            {
                put(USER_DOES_NOT_EXIST, new ResponseMessage(
                        USER_DOES_NOT_EXIST,
                        "المستخدم غير موجود",
                        "User does not exist"));
                put(USER_ALREADY_REGISTERED, new ResponseMessage(
                        USER_ALREADY_REGISTERED,
                        "البريد الالكتروني مسجل بالفعل، جرّب تدخل نظامنا؟",
                        "The email you're trying is already registered, try logging in"));
                put(GENERIC_ERROR, new ResponseMessage(
                    GENERIC_ERROR,
                    "الخطأ مننا هالمرة.. جرب بعد شوي",
                    "Ops.. something went wrong. Please try again"));
                put(REGION_NOT_SUPPORTED, new ResponseMessage(
                        REGION_NOT_SUPPORTED,
                        "اعذرنا يالطيب .. مابعد وصلنا منطقتك",
                        "Sorry, the region you entered isn't supported yet."));
                put(CATEGORY_NOT_SUPPORTED, new ResponseMessage(
                        CATEGORY_NOT_SUPPORTED,
                        "مابعد توسعنا لهدرجة .. دوّر لك قسم غيره!",
                        "This category isn't supported yet..maybe in the future!"));
            }
        };
    }
}
