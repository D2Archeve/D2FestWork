package org.d2fest.d2archive.test.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * Spring Test Case with DBunit
 *
 * @author <a href="mailto:kchuh@nextree.co.kr">허기철</a>
 * @since 2012. 5. 10.
 */
public abstract class SpringDbUnitTestCase {

    /** 데이터소스 */
    @Autowired
    private DataSource dataSource;

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * 트랜젝션 시작전 수행할 작업
     *
     * @throws Exception 초기 데이터 로딩 중 문제가 생길 경우 발생
     */
    @BeforeTransaction
    public void beforeTransaction() throws Exception {
        this.createTable();
        this.loadTestData();
    }

    /**
     * 트랜젝션 종료후 수행할 작업
     *
     * @throws Exception 테스트 데이터 삭제 중 문제가 생길 경우 발생
     */
    @AfterTransaction
    public void afterTransaction() throws Exception {
        this.cleanTestData();
    }

    // -------------------------------------------------------------------------
    // Protected Method
    // -------------------------------------------------------------------------

    /**
     * 테스트데이터를 로드하기 위해서는 이 메소드를 구현해야 함
     *
     * @return 테스트데이터 XML 리소스 위치. 예) com/skmnc/ndds/platform/log/da/sqlmap/xxx.xml
     */
    protected List<String> addDataFiles() {
        return null;
    }

    /**
     * 테스트데이터를 로드하기 위해서는 이 메소드를 구현해야 함
     *
     * @return 테스트데이터 XML 리소스 위치. 예) com/skmnc/ndds/platform/log/da/sqlmap/xxx.xml
     */
    protected String addDataFile() {
        return null;
    }

    /**
     * @return 데이터소스
     */
    protected DataSource getDataSource() {
        return this.dataSource;
    }

    /**
     * @return 스키마명
     */
    protected String getSchemaName() {
        return "xe";
    }

    /**
     * 테이블 생성
     */
    protected void createTable() {
        // 테이블 생성
    }

    // -------------------------------------------------------------------------
    // Private Method
    // -------------------------------------------------------------------------

    /**
     * 초기 테스트 데이터 로딩
     */
    private void loadTestData() throws Exception {
        DatabaseOperation.INSERT.execute(getMySqlConnection(), getDataSet());
    }

    /**
     * 테스트 데이터 삭제
     */
    private void cleanTestData() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(getMySqlConnection(), getDataSet());
    }

    /**
     * IDatabaseConnection 생성
     *
     * @return IDatabaseConnection. <code>not null</code> 보장.
     */
//    private IDatabaseConnection getOracleConnection() throws Exception {
//    	//
//        DatabaseConnection connection = new DatabaseConnection(this.dataSource.getConnection(), getSchemaName());	// for Oracle
//        DatabaseConfig config = connection.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new Oracle10DataTypeFactory());	// for Oracle
//        config.setProperty("http://www.dbunit.org/features/caseSensitiveTableNames", true);        
//        return connection;
//    }

    private IDatabaseConnection getMySqlConnection() throws Exception {
    	//
        DatabaseConnection connection = new DatabaseConnection(this.dataSource.getConnection());		// for mysql
        DatabaseConfig config = connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());		// for mysql
        config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());		// for mysql
        return connection;
    }

    /**
     * IDataSet 생성
     *
     * @return IDataSet. <code>not null</code> 보장.
     */
    private IDataSet getDataSet() throws Exception {
    	//
        List<String> dataFiles = this.getDataFiles();
        if (dataFiles == null) {
            dataFiles = new ArrayList<String>();
        }

        List<IDataSet> dbUnitDataSets = new ArrayList<IDataSet>(dataFiles.size());

        for (String file : dataFiles) {
            ReplacementDataSet dataSet = new ReplacementDataSet(new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(file)));
            // 값이 [NULL] 이면 null 값으로 처리함.
            dataSet.addReplacementObject("[NULL]", null);
            dbUnitDataSets.add(dataSet);
        }

        return new CompositeDataSet(dbUnitDataSets.toArray(new IDataSet[dbUnitDataSets.size()]));
    }

    /**
     * 테스트데이터 XML 파일 위치 목록
     *
     * @return 테스트데이터 XML 파일 위치 목록. <code>not null</code> 보장.
     */
    private List<String> getDataFiles() {
    	//
        List<String> dataFiles = new ArrayList<String>();

        if (this.addDataFiles() != null) {
            dataFiles.addAll(this.addDataFiles());
        }

        if (this.addDataFile() != null) {
            dataFiles.add(this.addDataFile());
        }

        return dataFiles;
    }

}
