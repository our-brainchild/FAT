package moduls;

import play.api.Configuration;
import play.api.Environment;
import play.api.inject.Binding;
import play.api.inject.Module;
import scala.collection.Seq;

/**
 * Created by anton on 21.03.17.
 */
public class MyModule extends Module {
    @Override
    public Seq<Binding<?>> bindings(Environment environment, Configuration configuration) {
        return seq(bind(LiquibaseComponent.class).to(LiquibaseComponentImpl.class));
    }
}
/**
 *

 class LiquibaseModule extends AbstractModule {
 override def configure(): Unit = {
 bind(classOf[LiquibaseComponent]).to(classOf[LiquibaseComponentImpl]).asEagerSingleton()
 }
 }
 */