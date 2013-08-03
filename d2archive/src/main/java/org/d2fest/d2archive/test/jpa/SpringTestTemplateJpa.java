package org.d2fest.d2archive.test.jpa;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
/**
 * DbUnit에대한 테스트설정을 공유하기 위한 추상클래스
 * @author <a href="mailto:byleem@nextree.co.kr">임병인</a>
 * @since 2012. 11. 15.
 */
@ContextConfiguration(locations = { "classpath:appCtx-jpa-test.xml" })
// @DbUnitConfiguration(databaseConnection = "testDS")
@DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection")
@TestExecutionListeners({
  DependencyInjectionTestExecutionListener.class,
  DirtiesContextTestExecutionListener.class,
  TransactionDbUnitTestExecutionListener.class, // needed if using transactions otherwise use TransactionalTestExecutionListener.class
  DbUnitTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "jpaTransactionManager", defaultRollback = true)
public abstract class SpringTestTemplateJpa {

}