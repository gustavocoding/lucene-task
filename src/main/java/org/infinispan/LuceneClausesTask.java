package org.infinispan;

import org.apache.lucene.search.BooleanQuery;
import org.infinispan.tasks.ServerTask;
import org.infinispan.tasks.TaskContext;

public class LuceneClausesTask implements ServerTask<Integer> {

   @Override
   public void setTaskContext(TaskContext taskContext) {
   }

   @Override
   public String getName() {
      return "lucene-task";
   }

   @Override
   public Integer call() {
      BooleanQuery.setMaxClauseCount(2000);
      return BooleanQuery.getMaxClauseCount();
   }
}
