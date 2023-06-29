package configuratio;

public class AgentFactory {
    static void create(Agents agent){
        switch (agent){
            case ANDROIDRU -> createandroidRU();
            case iPHONEEN -> createIphoneEN();
        }
    }

    private static void createIphoneEN() {
        DriverFactory.server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");

            request.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/114.0.5735.124 Mobile/15E148 Safari/604.1");
            request.headers().add("Accept-Language", "en");
            request.headers().add("Content-Language", "en_EN");

            request.headers().remove("Referer");
            return null;
        });
    }

    private static void createandroidRU() {
        DriverFactory.server.addRequestFilter(
                (request, contents, messageInfo) -> {
                    request.headers().remove("user-agent");
                    request.headers().remove("Accept-Language");
                    request.headers().remove("Content-Language");


                    request.headers().add("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv)" +
                            "AppleWebKit/537.36 (KHTML, like Gecko)" +
                            "Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
                    request.headers().add("Accept-Language", "ru");
                    request.headers().add("Content-Language", "ru_RU");

                    request.headers().remove("Referer");

                    return null;
                });
    }

}
