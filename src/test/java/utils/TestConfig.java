package utils;

public class TestConfig {

    private static String baseUrl;

    /**
     * Sets main url string
     */
    public static void setBaseUrl(String baseURL) {
        TestConfig.baseUrl = baseURL;
    }

    /**
     * Gets path to base URL
     *
     * @return The base URL
     */
    public static String getBaseUrl() {
        return TestConfig.baseUrl;
    }
}
