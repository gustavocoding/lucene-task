# lucene-task

* Execute ```mvn clean install -s maven-settings.xml```

* Copy the jar ```target/lucene-task-1.0-SNAPSHOT.jar``` to the server's deployment folder, aka ```standalone/deployments```.

The task can be execute with:

```java
import java.util.Collections;

import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

public class ClientTest {
   
   public static void main(String[] args) {
      Configuration build = new ConfigurationBuilder().build();
      RemoteCacheManager remoteCacheManager = new RemoteCacheManager(build);

      RemoteCache<Object, Object> cache = remoteCacheManager.getCache();
      Object execute = cache.execute("lucene-task", Collections.emptyMap());
      System.out.println("Result: " + execute);
   }
}
```
