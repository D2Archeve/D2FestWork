package org.d2fest.d2archive.test.neo4j;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *	<font style="color:red">
 *	Implementing class must declare applicationContext field.
 *	<br/>
 *	example : @Autowired public ApplicationContext applicationContext;
 *	</font>
 *	
 * @author <a href="mailto:vaslife@gmail.com">vaslife</a>
 * @since 2013. 7. 2.
 */
@ContextConfiguration(locations = "classpath:appCtx-neo4j-rest-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class SpringTestTemplateNeo4j {
	//
//	@Autowired
//	protected Neo4jTemplate template;
/*
	@Rule
	public Neo4jRule neo4jRule = newNeo4jRule().defaultSpringGraphDatabaseServiceNeo4j();*/

/*	
	@Rollback(false)
	@BeforeTransaction
	public void cleanUpGraph() {
		Neo4jHelper.cleanDb(template);
	}*/

}
