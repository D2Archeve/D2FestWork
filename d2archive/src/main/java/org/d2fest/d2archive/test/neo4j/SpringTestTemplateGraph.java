package org.d2fest.d2archive.test.neo4j;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author <a href="mailto:vaslife@gmail.com">vaslife</a>
 * @since 2013. 7. 16.
 */
@ContextConfiguration(locations = "classpath:appCtx-graph-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestTemplateGraph {
	//
/*    @SuppressWarnings("rawtypes")
	@Before
    public void clearAllGraphRepositories() {
        Map<String, GraphRepository> graphRepositories = ctx.getBeansOfType(GraphRepository.class);
        for (GraphRepository graphRepository : graphRepositories.values()) {
            graphRepository.deleteAll();
        }
    }*/
		
}
