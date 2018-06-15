package main.metadata.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class C3P0Cnn {

    private static ComboPooledDataSource cpds;
    static {
        initDataSource();
    }

    // 配置数据源
    public static void initDataSource() {
        cpds = new ComboPooledDataSource();
        cpds.setDataSourceName("acms01");
        cpds.setJdbcUrl("jdbc:mysql://test1.sns.sohuno.com:3306/house?useUnicode=true&characterEncoding=UTF8");//连接url
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } //数据库驱动
        cpds.setUser("snstest");//用户名
        cpds.setPassword("snstest");//密码
        cpds.setMaxPoolSize(100);//连接池中保留的最大连接数
        cpds.setMinPoolSize(10);//连接池中保留的最小连接数
        cpds.setAcquireIncrement(10);//一次性创建新连接的数目
        cpds.setInitialPoolSize(10);//初始创建
        cpds.setMaxIdleTime(6000);//最大空闲时间
//        cpds.setAutoCommitOnClose();
    }//*/

    private C3P0Cnn(){}

    // 从连接池中获得连接对象
    public static Connection getConnection(){
        try {
            return cpds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
