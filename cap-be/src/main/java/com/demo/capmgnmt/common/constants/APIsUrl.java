package com.demo.capmgnmt.common.constants;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

public interface APIsUrl {
    interface Common {
        String API_BASE_URL = "/api";
    }

    interface User {
        String USER_BASE_URL = "/user",
                CREATE_USER = Common.API_BASE_URL + USER_BASE_URL + "/create",
                UPDATE_USER = USER_BASE_URL + "/update",
                DELETE_USER = USER_BASE_URL + "/delete";
    }

    interface Lookup {
        String LOOKUP_BASE_URL = Common.API_BASE_URL + "/lookup",
                CATEGORIES = "/categories",
                ITEMS = "/items";
    }

    interface Cart {
        String CART_BASE_URL = Common.API_BASE_URL + "/cart",
                ADD_ITEM = "/add",
                REMOVE_ITEM = "/remove",
                VIEW_CART = "/view";
    }
}
