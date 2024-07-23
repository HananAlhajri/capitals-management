package com.demo.capmgnmt.common.constants;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

public interface APIsUrl {
    interface Common {
        String API_BASE_URL = "/api",
                LIKE_URL = "/like",
                DISLIKE_URL = "/dislike";
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

    interface Item {
        String ITEM_BASE_URL = Common.API_BASE_URL + "/item",
                VIEW_ITEM_URL = "/view";
    }

    interface Comment {
        String COMMENT_BASE_URL = "/comment";
    }
}
