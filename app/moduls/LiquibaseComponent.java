package moduls;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.CompositeResourceAccessor;
import liquibase.resource.FileSystemResourceAccessor;
import play.db.Database;
import play.api.inject.ApplicationLifecycle;
import play.libs.F;


import javax.inject.Inject;
import java.sql.Connection;
/**
 * Created by anton on 21.03.17.
 */

public interface LiquibaseComponent{
}

class LiquibaseComponentImpl implements LiquibaseComponent{

    @Inject
    public LiquibaseComponentImpl(ApplicationLifecycle lifecycle,final Database db){
        lifecycle.addStopHook(() -> {
            return F.Promise.pure(null);
        });
        String changeLog = config.getString("liquibase.changelog");
        System.out.println(changeLog + "Path for Change");
        db.withConnection(connection -> {
                    Liquibase liqui = null;
                    try {
                        liqui = getLiquibase(changeLog, connection);
                        liqui.update("dev");
                    } catch (LiquibaseException e) {
                        e.printStackTrace();
                    }
                    return liqui;});
    }
    Config config = ConfigFactory.load();

    public Liquibase getLiquibase(String changeLogFilePath, Connection connection) throws LiquibaseException {
        FileSystemResourceAccessor fileAccessor = new FileSystemResourceAccessor();
        ClassLoaderResourceAccessor classLoaderAccessor = new ClassLoaderResourceAccessor(classLoader());
        CompositeResourceAccessor fileOpener = new CompositeResourceAccessor(fileAccessor, classLoaderAccessor);
        return new Liquibase(changeLogFilePath, fileOpener, new JdbcConnection(connection));
    }

    public ClassLoader classLoader(){
        ClassLoader cl = ActorSystem.class.getClassLoader();
        return cl;
    }
}
/**
 class LiquibaseComponentImpl @Inject()(lifecycle: ApplicationLifecycle, db: Database) extends LiquibaseComponent {
 // previous contents of Plugin.onStart

 lazy val config = ConfigFactory.load()

 def performMigrations: Unit = {
 print("hello Ivanko")
 val changeLog = config.getString("liquibase.changelog")

 db.withConnection { connection =>
 val liqui = try {getLiquibase(changeLog, connection)} catch {case e: Exception => throw new Exception("Liquibase can't be instantiated")}
 liqui.update("dev")
 }

 }

 def getLiquibase(changeLogFilePath: String, connection: Connection): Liquibase = {
 val fileAccessor = new FileSystemResourceAccessor()
 val classLoaderAccessor = new ClassLoaderResourceAccessor(classLoader)
 val fileOpener = new CompositeResourceAccessor(fileAccessor, classLoaderAccessor)
 new Liquibase(changeLogFilePath, fileOpener, new JdbcConnection(connection))
 }

 def classLoader: ClassLoader = classOf[ActorSystem].getClassLoader

 lifecycle.addStopHook { () =>
 // previous contents of Plugin.onStop
 Future.successful(())
 }

 performMigrations
 }


 import java.sql.Connection
 import javax.inject.Inject

 import akka.actor.ActorSystem
 import com.google.inject.AbstractModule
 import com.typesafe.config.ConfigFactory
 import liquibase.Liquibase
 import liquibase.database.jvm.JdbcConnection
 import liquibase.resource.{ClassLoaderResourceAccessor, CompositeResourceAccessor, FileSystemResourceAccessor}
 import play.api.db.Database
 import play.api.inject.ApplicationLifecycle

 import scala.concurrent.Future

 trait LiquibaseComponent
 */