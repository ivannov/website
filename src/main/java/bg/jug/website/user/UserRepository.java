package bg.jug.website.user;

import bg.jug.website.config.WebsiteEntityManagerResolver;
import bg.jug.website.model.user.User;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * @author Ivan St. Ivanov
 */
@Repository
@EntityManagerConfig(entityManagerResolver = WebsiteEntityManagerResolver.class)
public interface UserRepository extends EntityRepository<User, Long> {
}
