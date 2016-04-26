package bg.jug.website.user;

import bg.jug.website.config.WebsiteEntityManagerResolver;
import bg.jug.website.model.user.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.Resolvers;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.coordinate.MavenDependency;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ivan St. Ivanov
 */
@RunWith(Arquillian.class)
public class UserServiceIntegrationTest {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "website-test.war")
                .addPackage(UserService.class.getPackage())
                .addClass(WebsiteEntityManagerResolver.class)
                .addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve().withTransitivity().asFile())
                .addClass(User.class)
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(webArchive.toString(true));
        return webArchive;
    }

    @Inject
    private UserService userService;

    @Test
    @InSequence(1)
    public void shouldCreateUser() throws Exception {
        User testUser = new User("Ivan St. Ivanov", "ivan@example.com", "ivan");
        User persistedUser = userService.addUser(testUser);
        assertNotNull(persistedUser.getId());
        assertEquals(testUser.getFullname(), persistedUser.getFullname());
    }
}
