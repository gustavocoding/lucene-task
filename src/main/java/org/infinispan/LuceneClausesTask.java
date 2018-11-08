package org.infinispan;

import java.util.Map;
import java.util.Optional;

import org.apache.lucene.search.BooleanQuery;
import org.infinispan.tasks.ServerTask;
import org.infinispan.tasks.TaskContext;

public class LuceneClausesTask implements ServerTask<Integer> {

   private TaskContext taskContext;

   @Override
   public void setTaskContext(TaskContext taskContext) {
      this.taskContext = taskContext;
   }

   @Override
   public String getName() {
      return "lucene-task";
   }

   @Override
   public Integer call() {
      Optional<Map<String, ?>> parameters = taskContext.getParameters();
      if (parameters.isPresent()) {
         Integer maxClauses = (Integer) parameters.get().get("maxClauses");
         BooleanQuery.setMaxClauseCount(maxClauses);
      }
      return BooleanQuery.getMaxClauseCount();
   }
}
