package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("호출 url="+url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect:"+url);
    }

    public void call(String message) {
        System.out.println("call:"+url+" msg:"+message);
    }

    public void disconnect() {
        System.out.println("close "+url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("init");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
