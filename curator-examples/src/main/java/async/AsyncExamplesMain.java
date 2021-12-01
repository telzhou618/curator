package async;

import framework.CreateClientExamples;
import org.apache.curator.framework.CuratorFramework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhougaojun
 * @since 2021/12/1
 */
public class AsyncExamplesMain {

    public static void main(String[] args) throws IOException {
        CuratorFramework client = CreateClientExamples.createSimple("127.0.0.1:2181");
        client.getConnectionStateListenable().addListener((c, newState) -> {
            System.out.println("state=" + newState);
        });
        client.start();

        AsyncExamples.createThenWatchSimple(client,"/demo");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
    }
}
