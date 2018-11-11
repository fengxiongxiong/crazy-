defaultCatalog = "grailstest"
dataSource{
    pooled= true
    jmxExport= true
    username = "root"
    password = "123456"
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    properties {
        jmxEnabled = true
        initialSize = 5
        maxActive = 50
        minIdle = 5
        maxIdle = 25
        maxWait = 10000
        maxAge = 10 * 60000
        timeBetweenEvictionRunsMillis = 5000
        minEvictableIdleTimeMillis = 60000
        validationQuery = "SELECT 1"
        validationQueryTimeout = 3
        validationInterval = 15000
        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = false
        jdbcInterceptors = "ConnectionState;StatementCache(max=200)"
        defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
    }
}
environments {
    development {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost/${defaultCatalog}?useUnicode=true&characterEncoding=UTF-8&createDatabaseIfNotExist=true"
            logSql = true
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost/${defaultCatalog}?useUnicode=true&characterEncoding=UTF-8&createDatabaseIfNotExist=true"
            //logSql = true
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost/${defaultCatalog}?useUnicode=true&characterEncoding=UTF-8&createDatabaseIfNotExist=true"
            //logSql = true
        }
    }
}
grails.gorm.default.constraints = {
    '*'(nullable: true)
}
grails.gorm.failOnError = true

grails.converters.json.default.deep = true  //as json 时可以把里面的对象全部转换成json

sequence.flushInterval = 60

ribbon.ConnectTimeout = 10000000
ribbon.ReadTimeout = 10000000

server.session.timeout = 7200   //session 超时时间 默认1800 s

grails.auth.interceptor.skip = [   //跳过验证
//                                   [controller: "", action: ""],
]
