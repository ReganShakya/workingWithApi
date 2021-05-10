package com.web.restapi.db;

import org.sql2o.Sql2o;
import static spark.Spark.port;

/**
 *
 * @author regan
 */
public class DbConfiguration {
    private DbConfiguration(){
    }
    
    public static Sql2o getConnetion(){
        
        String datasourse = "jdbc:h2:~/reviews.db";
//        if (args.length > 0) {
//            if (args.length != 2) {
//                System.out.println("java Api <port> <datasource>");
//                System.exit(0);
//            }
//            port(Integer.parseInt(args[0]));
//            datasourse = args[1];
//        }
        Sql2o sql2o = new Sql2o(
                String.format("%s;INIT=RUNSCRIPT from 'classpath:db/init.sql'", datasourse),
                 "", "");
        return sql2o;
    }
}
