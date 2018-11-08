# lucene-task

* Execute ```mvn clean install -s maven-settings.xml```

* Copy the jar ```target/lucene-task-1.0-SNAPSHOT.jar``` to the server's deployment folder, aka ```standalone/deployments```.

The task can be executed with:

```java
import java.util.HashMap;
import java.util.Map;

import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

public class ClientTest {

   public static void main(String[] args) {
      Configuration build = new ConfigurationBuilder().build();
      RemoteCacheManager remoteCacheManager = new RemoteCacheManager(build);

      Map<String, Integer> params = new HashMap<>();
      params.put("maxClauses", 2050);
      RemoteCache<Object, Object> cache = remoteCacheManager.getCache();
      Object execute = cache.execute("lucene-task", params);
      
      System.out.println("Result: " + execute);
   }
}

```
