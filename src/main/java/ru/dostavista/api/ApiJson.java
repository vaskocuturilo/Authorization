package ru.dostavista.api;

import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;
import ru.dostavista.model.Account;

/**
 * The type Api json.
 */
public final class ApiJson {


    /**
     * Constant JSON_PATH.
     */
    private static final String JSON_PATH = "";

    /**
     * Value jsonPath.
     */
    private final JsonPath jsonPath;


    /**
     * Constructor ApiJson.
     *
     * @param json json file.
     */

    private ApiJson(final String json) {
        this.jsonPath = JsonPath.from(json);
    }

    /**
     * From api json.
     *
     * @param json the json
     * @return the api json
     */
    public static ApiJson from(final String json) {
        return new ApiJson(json);
    }

    /**
     * Method getDataFromApiService.
     *
     * @return the post
     */
    public Account getDataFromApiService() {
        return jsonPath.getObject(JSON_PATH, Account.class);
    }

    /**
     * Method for put data with Json Object.
     *
     * @param phone    this is phone.
     * @param password this is password.
     * @return jsonObj to string.
     */
    public static String putJson(String phone, String password) {
        final JSONObject jsonObj = new JSONObject();

        jsonObj.put("phone", phone);
        jsonObj.put("password", password);

        return jsonObj.toString();
    }



}