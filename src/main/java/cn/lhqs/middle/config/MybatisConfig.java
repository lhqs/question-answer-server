package cn.lhqs.middle.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-01 12:55
 * description : MybatisConfig.class
 * version : 1.0
 */

@org.springframework.context.annotation.Configuration
class MybaitsConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }

        };
    }
}


// import java.util.Properties;
// import org.apache.ibatis.plugin.Interceptor;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;
// import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
// import com.github.pagehelper.PageHelper;
//
// import javax.sql.DataSource;


// @Configuration
// //加上这个注解，使得支持事务
// @EnableTransactionManagement
// public class MybatisConfig  implements TransactionManagementConfigurer {
//
//     @Autowired
//     DataSource dataSource;
//
//     @Override
//     public PlatformTransactionManager annotationDrivenTransactionManager() {
//         return new DataSourceTransactionManager(dataSource);
//     }
//
//     @Bean(name = "sqlSessionFactory")
//     public SqlSessionFactory sqlSessionFactoryBean(PageHelper pageHelper) {
//         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//         bean.setDataSource(dataSource);
//
//     //自定义数据库配置的时候，需要将pageHelper的bean注入到Plugins中，如果采用系统默认的数据库配置，则只需要定义pageHelper的bean，会自动注入。
//     bean.setPlugins(new Interceptor[] { pageHelper });
//         try {
//             return bean.getObject();
//         } catch (Exception e) {
//             e.printStackTrace();
//             throw new RuntimeException(e);
//         }
//     }
//
//     @Bean
//     public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//         return new SqlSessionTemplate(sqlSessionFactory);
//     }
//
//     @Bean
//     public PageHelper pageHelper() {
//         PageHelper pageHelper = new PageHelper();
//         Properties p = new Properties();
//         p.setProperty("offsetAsPageNum", "true");
//         p.setProperty("rowBoundsWithCount", "true");
//         p.setProperty("reasonable", "true");
//         p.setProperty("dialect", "mysql");
//         pageHelper.setProperties(p);
//         return pageHelper;
//     }
// }

