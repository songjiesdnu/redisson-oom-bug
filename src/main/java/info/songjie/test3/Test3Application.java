package info.songjie.test3;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Test3Application {

    public static void main(String[] args) {
        SpringApplication.run(Test3Application.class, args);
    }

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.setNettyThreads(1);
        config.useClusterServers()
                .setScanInterval(1000) // cluster state scan interval in milliseconds
                .addNodeAddress("redis://10.193.8.33:8307")
                .setKeepAlive(false);
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

}
